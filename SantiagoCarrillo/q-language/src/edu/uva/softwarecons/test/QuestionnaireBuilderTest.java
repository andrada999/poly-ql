package edu.uva.softwarecons.test;

import edu.uva.softwarecons.util.ParserBuilder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class QuestionnaireBuilderTest {

    ParserBuilder parserBuilder;

    @Before
    public void setUp() {
        parserBuilder = new ParserBuilder();
    }

    @Test
    public void simpleFormTest(){
        String input = "form Box1HouseOwning {hasSoldHouse: \"Did you sell a house in 2010?\" boolean}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) })");
    }

    @Test
    public void conditionalIfFormTest(){
        String input = "form Box1HouseOwning {if(a==b){hasSoldHouse: \"Did you sell a house in 2010?\" boolean}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr a) == (expr b)) ) { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) }) })");
    }


    @Test
    public void booleansAndFormTest(){
        String input = "form Box1HouseOwning {if(a==b && a<b){hasSoldHouse: \"t\" date}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr (expr a) == (expr b)) && (expr (expr a) < (expr b))) ) { (question hasSoldHouse : \"t\" (type date)) }) })");
    }


    @Test
    public void booleansAndOrFormTest(){
        String input = "form Box1HouseOwning {if(a==b && a<b){hasSoldHouse: \"t\" date}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr (expr a) == (expr b)) && (expr (expr a) < (expr b))) ) { (question hasSoldHouse : \"t\" (type date)) }) })");
    }

    @Test
    public void conditionalIfElseFormTest(){
        String input = "form Box1HouseOwning {if(a==b){hasSoldHouse: \"text\" boolean} else { hasSoldHouse: \"text\" money }}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr a) == (expr b)) ) { (question hasSoldHouse : \"text\" (type boolean)) } (elsestat else { (question hasSoldHouse : \"text\" (type money)) })) })");
    }


    @Test
    public void comparisonFormTest(){
        String input = "form Box1HouseOwning {if(1<=2){hasSoldHouse: \"Did you sell a house in 2010?\" boolean}}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question if ( (expr (expr 1) <= (expr 2)) ) { (question hasSoldHouse : \"Did you sell a house in 2010?\" (type boolean)) }) })");
    }

    @Test
    public void expressionOperationTest(){
        String input = "form Box1HouseOwning { h: \"text\" money(1+5*5)}";
        ParseTree tree = parserBuilder.buildParseTree(input);
        assertEquals(tree.toStringTree(parserBuilder.getParser()),
                "(questionnaire form Box1HouseOwning { (question h : \"text\" (type money) ( (expr (expr 1) + (expr (expr 5) * (expr 5))) )) })");
    }
}