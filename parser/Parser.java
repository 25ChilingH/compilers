package parser;

import scanner.*;
import java.util.ArrayList;

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
            Variable var = new Variable(currToken);
            eat(currToken);
            return var;
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
     * Prints out the parsed expression if there is a WRITELN(expr). Navigates
     * through BEGIN and END blocks. Stores variable and its corresponding
     * value in a hashmap.
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
            eat("WRITELN");
            eat("(");
            Expression exp = parseExpr();
            eat(")");
            eat(";");
            return new Writeln(exp);
        }
        else if (currToken.equals("BEGIN"))
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
        else if (currToken.equals("IF"))
        {
            eat("IF");
            Expression exp1 = parseExpr();
            String relop = currToken;
            eat(currToken);
            Expression exp2 = parseExpr();
            eat("THEN");
            Statement stmt = parseStatement();
            return new If(new Condition(relop, exp1, exp2), stmt);
        }
        else if (currToken.equals("WHILE"))
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
        else
        {
            String key = currToken;
            eat(currToken);
            eat(":=");
            Expression val = parseExpr();
            eat(";");
            return new Assignment(key, val);
        }
    }
}
