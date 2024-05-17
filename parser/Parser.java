package parser;

import scanner.*;
import java.util.ArrayList;
import java.util.List;

import ast.*;
import ast.Number;

/**
 * Parser is a simple parser for the class Compilers and Interpreters. Processes a text input
 * file by first scanning it using the Scanner class, parsing the stream of tokens produced
 * by the Scanner, and printing the output of the source code.
 * 
 * @author Chiling Han
 * @version March 11, 2024
 *
 * Usage: java ParserTester
 *
 */
public class Parser
{
    private Scanner scan;
    private String currToken;

    /**
     * Parser constructor for construction of a parser that
     * uses a Scanner object to receive a stream of tokens
     * Usage:
     * FileInputStream inStream = new FileInputStream(new File(<file name>);
     * Scanner lex = new Scanner(inStream);
     * Parser parse = new Parser(lex);
     * 
     * @param scan the Scanner object to use
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Parser(Scanner scan) throws ScanErrorException
    {
        this.scan = scan;
        currToken = scan.nextToken();
    }

    /**
     * Gets the next character and ensures that it matches the expected char
     * 
     * @param expected the expected character
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    private void eat(String expected) throws ScanErrorException
    {
        if (currToken.equals(expected))
        {
            currToken = scan.nextToken();
        }
        else
        {
            throw new ScanErrorException("Illegal character: expected <" + expected
                    + "> and found <" + currToken + ">");
        }
    }

    /**
     * @precondition current token is an integer
     * @postcondition integer has been eaten
     * @return the integer value of the current token
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    private Expression parseNumber() throws ScanErrorException
    {
        int num = Integer.parseInt(currToken);
        eat(currToken);
        return new Number(num);
    }

    /**
     * @precondition current token is a factor
     * @postcondition factor that has been eaten
     * @return the integer value of the evaluated numerical factor
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Expression parseFactor() throws ScanErrorException
    {
        if (currToken.equals("("))
        {
            eat("(");
            Expression num = parseExpr();
            eat(")");
            return num;
        }
        else if (currToken.equals("-"))
        {
            eat("-");
            return new BinOp("*", new Number(-1), parseFactor());
        }
        else if (Scanner.isDigit(currToken.charAt(0)))
        {
            return parseNumber();
        }
        else
        {
            Expression exp;
            String name = currToken;
            eat(currToken);
            if (currToken.equals("("))
            {
                List<Expression> args = new ArrayList<Expression>();
                eat("(");
                if (!currToken.equals(")"))
                {
                    args.add(parseExpr());
                    while (!currToken.equals(")"))
                    {
                        eat(",");
                        args.add(parseExpr());
                    }
                }
                eat(")");
                exp = new ProcedureCall(name, args);
            }
            else
            {
                exp = new Variable(name);
            }
            return exp;
        }

    }

    /**
     * @precondition current token is a numerical expression
     * @postcondition numerical expression has been eaten
     * @return the integer value of the evaluated numerical expression
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Expression parseExpr() throws ScanErrorException
    {
        Expression res = parseTerm();
        while (currToken.equals("+") || currToken.equals("-"))
        {
            if (currToken.equals("+"))
            {
                eat("+");
                res = new BinOp("+", res, parseTerm());
            }
            else if (currToken.equals("-"))
            {
                eat("-");
                res = new BinOp("-", res, parseTerm());
            }
        }
        return res;
    }


    /**
     * @precondition current token is a numerical term
     * @postcondition numerical term has been eaten
     * @return the integer value of the evaluated numerical term
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    private Expression parseTerm() throws ScanErrorException
    {
        Expression res = parseFactor();
        while (currToken.equals("*") || currToken.equals("/"))
        {
            if (currToken.equals("*"))
            {
                eat("*");
                res = new BinOp("*", res, parseFactor());
            }
            else if (currToken.equals("/"))
            {
                eat("/");
                res = new BinOp("/", res, parseFactor());
            }
        }
        return res;

    }


    /**
     * Parses a statement, including WRITELN, BEGIN/END blocks, IF/ELSE statements,
     * WHILE loops, FOR loops, READLN, and variable assignments.
     * @precondition current token is a Pascal code statement
     * @postcondition code statement has been eaten
     * @return statement that has been parsed
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Statement parseStatement() throws ScanErrorException
    {
        if (currToken.equals("WRITELN"))
        {
            return (Statement) parseWriteln();
        }
        else if (currToken.equals("BEGIN"))
        {
            return (Block) parseBlock();
        }
        else if (currToken.equals("IF"))
        {
            return (Statement) parseIf();
        }
        else if (currToken.equals("WHILE"))
        {
            return (Statement) parseWhile();
        }
        else if (currToken.equals("FOR"))
        {
            return (Statement) parseFor();
        }
        else if (currToken.equals("READLN"))
        {
            return (Statement) parseReadln();
        }
        else
        {
            return (Statement) parseAssignment(false);
        }
    }

    /**
     * @return statement representing Var declaration
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Var parseVar() throws ScanErrorException
    {
        List<String> names = new ArrayList<>();
        eat("VAR");
        names.add(currToken);
        eat(currToken);
        while (!currToken.equals(";"))
        {
            eat(",");
            names.add(currToken);
            eat(currToken);
        }
        eat(";");
        return new Var(names);
    }

    /**
     * 
     * @return statement representing a Readln statement
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Readln parseReadln() throws ScanErrorException
    {
        eat("READLN");
        eat("(");
        String var = currToken;
        eat(currToken);
        eat(")");
        eat(";");
        return new Readln(var);
    }

    /**
     * 
     * @return statement representing a For loop
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public For parseFor() throws ScanErrorException
    {
        eat("FOR");
        Assignment assign = parseAssignment(true);
        eat("TO");
        Expression check = parseExpr();
        eat("DO");
        Statement block = parseStatement();
        return new For(assign, check, block);
    }

    /**
     * 
     * @return statement representing a Writeln statement
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Writeln parseWriteln() throws ScanErrorException
    {
        eat("WRITELN");
        eat("(");
        Expression exp = parseExpr();
        eat(")");
        eat(";");
        return new Writeln(exp);
    }

    /**
     * 
     * @return statement representing a Block statement
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Block parseBlock() throws ScanErrorException
    {
        ArrayList<Statement> list = new ArrayList<>();
        eat("BEGIN");
        while (!currToken.equals("END"))
        {
            list.add(parseStatement());
        }
        eat("END");
        eat(";");
        return new Block(list);
    }

    /**
     * 
     * @return statement representing an If/Else statement
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public If parseIf() throws ScanErrorException
    {
        eat("IF");
        Expression exp1 = parseExpr();
        String relop = currToken;
        eat(currToken);
        Expression exp2 = parseExpr();
        eat("THEN");
        Statement stmt = parseStatement();
        if (currToken.equals("ELSE"))
        {
            eat("ELSE");
            Statement stmt2 = parseStatement();
            return new If(new Condition(relop, exp1, exp2), stmt, stmt2);
        }
        return new If(new Condition(relop, exp1, exp2), stmt);
    }

    /**
     * 
     * @return statement representing a While loop statement
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public While parseWhile() throws ScanErrorException
    {
        eat("WHILE");
        Expression exp1 = parseExpr();
        String relop = currToken;
        eat(currToken);
        Expression exp2 = parseExpr();
        eat("DO");
        Statement stmt = parseStatement();
        return new While(new Condition(relop, exp1, exp2), stmt);
    }

    /**
     * 
     * @param forLoop if the assignment is within a For loop
     * @return statement representing an Assignment statement
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Assignment parseAssignment(boolean forLoop) throws ScanErrorException
    {
        String key = currToken;
        eat(currToken);
        eat(":=");
        Expression val = parseExpr();
        if (!forLoop)
            eat(";");
        return new Assignment(key, val);
    }

    /**
     * 
     * @return statement representing the ProcedureDeclaration statement
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public ProcedureDeclaration parseProcedure() throws ScanErrorException
    {
        eat("PROCEDURE");
        String procedureName = currToken;
        eat(currToken);
        eat("(");

        List<String> params = new ArrayList<>();
        if (!currToken.equals(")"))
        {
            params.add(currToken);
            eat(currToken);
            while (!currToken.equals(")"))
            {
                eat(",");
                params.add(currToken);
                eat(currToken);
            }
        }

        eat(")");
        eat(";");
        Statement procedureStmt = parseStatement();
        return new ProcedureDeclaration(procedureName, procedureStmt, params);
    }

    /**
     * @return Program object that contains a list of procedure declarations and a 
     *         parsed statement
     *         
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public Program parseProgram() throws ScanErrorException
    {
        List<Var> vars = new ArrayList<>();
        while (currToken.equals("VAR"))
        {
            vars.add(parseVar());
        }
        List<ProcedureDeclaration> procedures = new ArrayList<>();
        while (currToken.equals("PROCEDURE"))
        {
            procedures.add(parseProcedure());
        }
        Statement stmt = parseStatement();
        return new Program(vars, procedures, stmt);
    }
}
