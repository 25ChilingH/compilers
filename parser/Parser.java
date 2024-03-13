package parser;

import scanner.*;
import java.util.Map;
import java.util.HashMap;

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
    private Map<String, Integer> variables;

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
        variables = new HashMap<String, Integer>();
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
    private int parseNumber() throws ScanErrorException
    {
        int num = Integer.parseInt(currToken);
        eat(currToken);
        return num;
    }

    /**
     * @precondition current token is a factor
     * @postcondition factor that has been eaten
     * @return the integer value of the evaluated numerical factor
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public int parseFactor() throws ScanErrorException
    {
        if (currToken.equals("("))
        {
            eat("(");
            int num = parseExpr();
            eat(")");
            return num;
        }
        else if (currToken.equals("-"))
        {
            eat("-");
            return -1 * parseFactor();
        }
        else
        {
            Integer val = variables.get(currToken);
            if (val != null)
            {
                eat(currToken);
                return val;
            }
            return parseNumber();

        }

    }

    /**
     * @precondition current token is a numerical expression
     * @postcondition numerical expression has been eaten
     * @return the integer value of the evaluated numerical expression
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public int parseExpr() throws ScanErrorException
    {
        int res = parseTerm();
        while (currToken.equals("+") || currToken.equals("-"))
        {
            if (currToken.equals("+"))
            {
                eat("+");
                res += parseTerm();
            }
            else if (currToken.equals("-"))
            {
                eat("-");
                res -= parseTerm();
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
    private int parseTerm() throws ScanErrorException
    {
        int res = parseFactor();
        while (currToken.equals("*") || currToken.equals("/"))
        {
            if (currToken.equals("*"))
            {
                eat("*");
                res *= parseFactor();
            }
            else if (currToken.equals("/"))
            {
                eat("/");
                res /= parseFactor();
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
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    public void parseStatement() throws ScanErrorException
    {
        if (currToken.equals("WRITELN"))
        {
            eat("WRITELN");
            eat("(");
            System.out.println(parseExpr());
            eat(")");
            eat(";");
        }
        else if (currToken.equals("BEGIN"))
        {
            eat("BEGIN");
            while (!currToken.equals("END"))
            {
                parseStatement();
            }
            eat("END");
            eat(";");
        }
        else
        {
            String key = currToken;
            eat(currToken);
            eat(":=");
            int val = parseExpr();
            eat(";");
            variables.put(key, val);
        }
    }
}
