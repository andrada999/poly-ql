// Implementation file for parser generated by fsyacc
module QL_Parser
#nowarn "64";; // turn off warnings that type variables used in production annotations are instantiated to concrete type
open Microsoft.FSharp.Text.Lexing
open Microsoft.FSharp.Text.Parsing.ParseHelpers
# 1 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"

open System
open QL_AST
open Microsoft.FSharp.Collections

# 12 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
// This type is the type of tokens accepted by the parser
type token = 
  | COLON
  | END
  | INT
  | STRING
  | BOOL
  | LABEL of (string)
  | ID of (string)
// This type is used to give symbolic names to token indexes, useful for error messages
type tokenId = 
    | TOKEN_COLON
    | TOKEN_END
    | TOKEN_INT
    | TOKEN_STRING
    | TOKEN_BOOL
    | TOKEN_LABEL
    | TOKEN_ID
    | TOKEN_end_of_input
    | TOKEN_error
// This type is used to give symbolic names to token indexes, useful for error messages
type nonTerminalId = 
    | NONTERM__startstart
    | NONTERM_start
    | NONTERM_Qtype
    | NONTERM_StmtExpr

// This function maps tokens to integers indexes
let tagOfToken (t:token) = 
  match t with
  | COLON  -> 0 
  | END  -> 1 
  | INT  -> 2 
  | STRING  -> 3 
  | BOOL  -> 4 
  | LABEL _ -> 5 
  | ID _ -> 6 

// This function maps integers indexes to symbolic token ids
let tokenTagToTokenId (tokenIdx:int) = 
  match tokenIdx with
  | 0 -> TOKEN_COLON 
  | 1 -> TOKEN_END 
  | 2 -> TOKEN_INT 
  | 3 -> TOKEN_STRING 
  | 4 -> TOKEN_BOOL 
  | 5 -> TOKEN_LABEL 
  | 6 -> TOKEN_ID 
  | 9 -> TOKEN_end_of_input
  | 7 -> TOKEN_error
  | _ -> failwith "tokenTagToTokenId: bad token"

/// This function maps production indexes returned in syntax errors to strings representing the non terminal that would be produced by that production
let prodIdxToNonTerminal (prodIdx:int) = 
  match prodIdx with
    | 0 -> NONTERM__startstart 
    | 1 -> NONTERM_start 
    | 2 -> NONTERM_Qtype 
    | 3 -> NONTERM_Qtype 
    | 4 -> NONTERM_Qtype 
    | 5 -> NONTERM_StmtExpr 
    | _ -> failwith "prodIdxToNonTerminal: bad production index"

let _fsyacc_endOfInputTag = 9 
let _fsyacc_tagOfErrorTerminal = 7

// This function gets the name of a token as a string
let token_to_string (t:token) = 
  match t with 
  | COLON  -> "COLON" 
  | END  -> "END" 
  | INT  -> "INT" 
  | STRING  -> "STRING" 
  | BOOL  -> "BOOL" 
  | LABEL _ -> "LABEL" 
  | ID _ -> "ID" 

// This function gets the data carried by a token as an object
let _fsyacc_dataOfToken (t:token) = 
  match t with 
  | COLON  -> (null : System.Object) 
  | END  -> (null : System.Object) 
  | INT  -> (null : System.Object) 
  | STRING  -> (null : System.Object) 
  | BOOL  -> (null : System.Object) 
  | LABEL _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
  | ID _fsyacc_x -> Microsoft.FSharp.Core.Operators.box _fsyacc_x 
let _fsyacc_gotos = [| 0us; 65535us; 1us; 65535us; 0us; 1us; 1us; 65535us; 9us; 10us; 1us; 65535us; 0us; 2us; |]
let _fsyacc_sparseGotoTableRowOffsets = [|0us; 1us; 3us; 5us; |]
let _fsyacc_stateToProdIdxsTableElements = [| 1us; 0us; 1us; 0us; 1us; 1us; 1us; 1us; 1us; 2us; 1us; 3us; 1us; 4us; 1us; 5us; 1us; 5us; 1us; 5us; 1us; 5us; |]
let _fsyacc_stateToProdIdxsTableRowOffsets = [|0us; 2us; 4us; 6us; 8us; 10us; 12us; 14us; 16us; 18us; 20us; |]
let _fsyacc_action_rows = 11
let _fsyacc_actionTableElements = [|1us; 32768us; 6us; 7us; 0us; 49152us; 1us; 32768us; 1us; 3us; 0us; 16385us; 0us; 16386us; 0us; 16387us; 0us; 16388us; 1us; 32768us; 0us; 8us; 1us; 32768us; 5us; 9us; 3us; 32768us; 2us; 6us; 3us; 5us; 4us; 4us; 0us; 16389us; |]
let _fsyacc_actionTableRowOffsets = [|0us; 2us; 3us; 5us; 6us; 7us; 8us; 9us; 11us; 13us; 17us; |]
let _fsyacc_reductionSymbolCounts = [|1us; 2us; 1us; 1us; 1us; 4us; |]
let _fsyacc_productionToNonTerminalTable = [|0us; 1us; 2us; 2us; 2us; 3us; |]
let _fsyacc_immediateActions = [|65535us; 49152us; 65535us; 16385us; 16386us; 16387us; 16388us; 65535us; 65535us; 65535us; 16389us; |]
let _fsyacc_reductions ()  =    [| 
# 111 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : QL_AST.question)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
                      raise (Microsoft.FSharp.Text.Parsing.Accept(Microsoft.FSharp.Core.Operators.box _1))
                   )
                 : '_startstart));
# 120 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : 'StmtExpr)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 16 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                                     _1 
                   )
# 16 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                 : QL_AST.question));
# 131 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 19 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                               Boolean 
                   )
# 19 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                 : 'Qtype));
# 141 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 20 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                                 String 
                   )
# 20 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                 : 'Qtype));
# 151 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 21 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                              Integer 
                   )
# 21 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                 : 'Qtype));
# 161 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
        (fun (parseState : Microsoft.FSharp.Text.Parsing.IParseState) ->
            let _1 = (let data = parseState.GetInput(1) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            let _3 = (let data = parseState.GetInput(3) in (Microsoft.FSharp.Core.Operators.unbox data : string)) in
            let _4 = (let data = parseState.GetInput(4) in (Microsoft.FSharp.Core.Operators.unbox data : 'Qtype)) in
            Microsoft.FSharp.Core.Operators.box
                (
                   (
# 24 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                                             Question(_1, _3, _4) 
                   )
# 24 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fsp"
                 : 'StmtExpr));
|]
# 175 "D:\Mijn documenten\GitHub\poly-ql\EdwinWesterhoud\SoftwConsQL\QL_Fsharp\QL_Parser.fs"
let tables () : Microsoft.FSharp.Text.Parsing.Tables<_> = 
  { reductions= _fsyacc_reductions ();
    endOfInputTag = _fsyacc_endOfInputTag;
    tagOfToken = tagOfToken;
    dataOfToken = _fsyacc_dataOfToken; 
    actionTableElements = _fsyacc_actionTableElements;
    actionTableRowOffsets = _fsyacc_actionTableRowOffsets;
    stateToProdIdxsTableElements = _fsyacc_stateToProdIdxsTableElements;
    stateToProdIdxsTableRowOffsets = _fsyacc_stateToProdIdxsTableRowOffsets;
    reductionSymbolCounts = _fsyacc_reductionSymbolCounts;
    immediateActions = _fsyacc_immediateActions;
    gotos = _fsyacc_gotos;
    sparseGotoTableRowOffsets = _fsyacc_sparseGotoTableRowOffsets;
    tagOfErrorTerminal = _fsyacc_tagOfErrorTerminal;
    parseError = (fun (ctxt:Microsoft.FSharp.Text.Parsing.ParseErrorContext<_>) -> 
                              match parse_error_rich with 
                              | Some f -> f ctxt
                              | None -> parse_error ctxt.Message);
    numTerminals = 10;
    productionToNonTerminalTable = _fsyacc_productionToNonTerminalTable  }
let engine lexer lexbuf startState = (tables ()).Interpret(lexer, lexbuf, startState)
let start lexer lexbuf : QL_AST.question =
    Microsoft.FSharp.Core.Operators.unbox ((tables ()).Interpret(lexer, lexbuf, 0))
