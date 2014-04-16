package org.uva.sea.ql.parser.antlr.QL4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AntlrVisitor;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QLErrorGenerator;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.BoolConditionChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.CyclicDependencyChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.DuplicateLabelChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.DuplicateQuestionChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.InvalidTypeChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.UndefQuestionChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Helpers.QuestionExtractor;

import QL4.QL4Lexer;
import QL4.QL4Parser;

/**
 * This class will request a file and attempt to visit it using QL4 parser
 * generated by applying antlr4 on QL4 grammar
 * 
 * @author Sammie Katt
 * 
 */
public class ASTManager {

	/**
	 * Main function for the QL DSL language. 
	 * This class requests a file to parse, and generates
	 * a question UI.
	 */
	public Form parseQuestionair(String fileToParse) throws IOException {
		// process file into tokens
		ANTLRFileStream fStream = new ANTLRFileStream(fileToParse);
		QL4Lexer lexer = new QL4Lexer(fStream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create antlr tree from tokens
		QL4Parser parser = new QL4Parser(tokens);
		ParseTree tree = parser.form();

		// parse antlr tree into own abstract tree
		AntlrVisitor ASTParser = new AntlrVisitor();
		Form ast = (Form) tree.accept(ASTParser);
		
		return ast;
	}

	
	/**
	 * Checks a form for errors and warnings by visiting
	 * the form with several visitors 
	 * @param ast
	 * @return
	 */
	public List<QLErrorMsg> checkErrors(Form ast) {
		// holds all errors and warning msgs generated
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		// the checker that will perform several checks on our ast input 
		QLErrorGenerator ASTChecker;
		QuestionExtractor extract = new QuestionExtractor();
		
		/**
		 * Questions is a map of identifier -> question
		 * This is necessary for checkers that need to know something
		 * about the question an identifier is refering to
		 */
		Map<Identifier, Question> questions = extract.visit(ast);
		
		ASTChecker = new UndefQuestionChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new DuplicateLabelChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new DuplicateQuestionChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new InvalidTypeChecker(questions);
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new BoolConditionChecker(questions);
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new CyclicDependencyChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		return msgs;
	}
}
