﻿module TypeCheckerTests

open System
open System.Collections.Generic
open System.Linq
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL.Grammar
open QL.Parsing
open QL.TypeChecker


// Form
[<TestClass>]
type TypeCheckerTests() = 

    [<TestMethod>]
    member x.DuplicateLabelsWarningTest() = 
        //setup
        let input = {Name = "Box1HouseOwning"; StatementList = [Question ("hasSoldHouse","Did you sell a house in 2010?",QL_Boolean,Position());   Question("hasBoughtHouse","Did you sell a house in 2010?",QL_Boolean,Position())];}
        let rules = new List<ITypeRule>();
        rules.Add(new DuplicateLabelsRule());
        let checker = new TypeChecker(rules)

        //execute
        let output = checker.getMessages(input).ToList()

        //assert
        Assert.IsTrue(output.Exists(fun _m -> _m.Message.Equals("Duplicate Label 'Did you sell a house in 2010?'")));


    [<TestMethod>]
    member x.ReferenceUndefinedQuestionErrorTest() =
        let input = {Name = "Box1HouseOwning"; StatementList = [Question("hasBoughtHouse","Did you by a house in 2010?",QL_Boolean,Position()); IfThen(Id("hasSoldHouse"), [ComputedQuestion("valueResidue","Value residue:",QL_Integer,ArithmicExpression(Id("sellingPrice"),Minus,Id("privateDebt")),Position())],Position())];}
        let rules = new List<ITypeRule>();
        rules.Add(new ReferenceUndefinedQuestionsRule());
        let checker = new TypeChecker(rules)

        let output = checker.getMessages(input).ToList()

        Assert.IsTrue(output.Count = 3);
        Assert.IsTrue(output.[0].Message.Contains("hasSoldHouse"));
        Assert.IsTrue(output.[1].Message.Contains("sellingPrice"));
        Assert.IsTrue(output.[2].Message.Contains("privateDebt"));

    [<TestMethod>]
    member x.DuplicateQuestionDeclarationWithDifferentTypesTest() = 
        let input = {Name = "Box1HouseOwning"; StatementList =  [Question ("hasSoldHouse","Did you sell a house in 2010?",QL_Boolean,Position());   Question ("hasSoldHouse","Did you by a house in 2010?",QL_Integer,Position())];}
        let rules = new List<ITypeRule>();
        rules.Add(new DuplicateQuestionDeclarationsMustBeOfSameTypeRule());
        let checker = new TypeChecker(rules)

        let output = checker.getMessages(input).ToList()

        Assert.IsTrue(output.Count = 1);
        Assert.IsTrue(output.[0].Message.Contains("hasSoldHouse") && output.[0].Message.Contains("expected 'boolean'"));

    [<TestMethod>]
    member x.ExpressionTypeShouldMatchExpectedTypeTest() =

//    form ExpressionTest {
//q1: "boolean with int literal" boolean(1)
//q2: "boolean with int arithmic" boolean(1 + 2)
//q3: "int" integer
//q4: "boolean with int id" boolean(q3)
//q5: "string with int literal" string(1)
//q6: "string with int arithmic" string(1+1)
//q7: "string with int id" string(q3)
//q8: "string with binary" string(5 > 3)
//q9: "string with neg" string(!5)
//q10: "int with boolean literal" integer(true)
//q11: "int with string id" integer(q5)
//q12: "int with binary" integer(1 > 2)
//q13: "int with neg" integer(!4)
//if(1+1)
//{
//}
//if("a")
//{
//}
//}

        let input = {Name = "ExpressionTest";
 StatementList =
  [ComputedQuestion
     ("q1","boolean with int literal",QL_Boolean,LiteralStatement (Integer 1),
      Position());
   ComputedQuestion
     ("q2","boolean with int arithmic",QL_Boolean,
      ArithmicExpression
        (LiteralStatement (Integer 1),Plus,LiteralStatement (Integer 2)),
      Position()); Question ("q3","int",QL_Integer,Position());
   ComputedQuestion ("q4","boolean with int id",QL_Boolean,Id "q3",Position());
   ComputedQuestion
     ("q5","string with int literal",QL_String,LiteralStatement (Integer 1),
      Position());
   ComputedQuestion
     ("q6","string with int arithmic",QL_String,
      ArithmicExpression
        (LiteralStatement (Integer 1),Plus,LiteralStatement (Integer 1)),
      Position());
   ComputedQuestion ("q7","string with int id",QL_String,Id "q3",Position());
   ComputedQuestion
     ("q8","string with binary",QL_String,
      BinaryExpression
        (LiteralStatement (Integer 5),GreaterThan,LiteralStatement (Integer 3)),
      Position());
   ComputedQuestion
     ("q9","string with neg",QL_String,Neg (LiteralStatement (Integer 5)),
      Position());
   ComputedQuestion
     ("q10","int with boolean literal",QL_Integer,
      LiteralStatement (Boolean true),Position());
   ComputedQuestion ("q11","int with string id",QL_Integer,Id "q5",Position());
   ComputedQuestion
     ("q12","int with binary",QL_Integer,
      BinaryExpression
        (LiteralStatement (Integer 1),GreaterThan,LiteralStatement (Integer 2)),
      Position());
   ComputedQuestion
     ("q13","int with neg",QL_Integer,Neg (LiteralStatement (Integer 4)),
      Position())];}
        let rules = new List<ITypeRule>();
        rules.Add(new QL.TypeChecker.ExpressionMustBeOfExpectedTypeRule());
        let checker = new TypeChecker(rules)

        let output = checker.getMessages(input).ToList()

        Assert.IsTrue(output.Count = 12);
        //Assert.IsTrue(output.[0].Message.Contains("hasSoldHouse") && output.[0].Message.Contains("expected 'boolean'"));