package net.iplantevin.ql.tests;

import net.iplantevin.ql.antlr.QLLexer;
import net.iplantevin.ql.antlr.QLParser;
import net.iplantevin.ql.ast.astbuilder.ASTBuilder;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Tests for antlr4 grammar
 *
 * @author Ivan
 */
public class GrammarTest {
    private static String basePath = "/Users/Ivan/Documents/Master SE/Software Construction/poly-ql/ivan/ql-project/src/net/iplantevin/ql/tests/inputs/";
    private static String ext = ".txt";
    private static String outExt = "_out.txt";

    private QLParser getParser(String fileName) throws IOException {
        String filePath = basePath + fileName + ext;
        ASTBuilder builder = new ASTBuilder(filePath);
        return builder.getParser();
    }

    private String getExpectedTree(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(basePath + fileName + outExt)));
    }

    private String getMessage(String fileName) {
        return "The parse tree for input file '" + fileName + ext +
                "' does not match the expected tree:";
    }

    @Test
    public void testCorrectExpressions() throws IOException {
        QLParser parser;
        String expected, actual;

        // Holds all files to test for expression rule.
        String[] files = new String[]{"expr1", "expr2", "expr3", "expr4", "expr5"};

        for (String file : files) {
            parser = getParser(file);
            expected = getExpectedTree(file);
            actual = parser.expr().toStringTree(parser);
            Assert.assertEquals(getMessage(file), expected, actual);
        }
    }

    @Test
    public void testCorrectForms() throws IOException {
        QLParser parser;
        String expected, actual;

        // Holds all files to test for form rule.
        String[] files = new String[]{"form1"};

        for (String file : files) {
            parser = getParser(file);
            expected = getExpectedTree(file);
            actual = parser.form().toStringTree(parser);
            Assert.assertEquals(getMessage(file), expected, actual);
        }
    }
}
