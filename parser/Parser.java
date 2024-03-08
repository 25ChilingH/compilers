package parser;

import scanner.*;
import java.util.Map;
import java.util.HashMap;

/**
 * 
 */
public class Parser
{
    private Scanner scan;
    private String currToken;
    private Map<String, Integer> variables;

    /**
     * 
     * @param scan
     * @throws ScanErrorException
     */
    public Parser(Scanner scan) throws ScanErrorException
    {
        this.scan = scan;
        currToken = scan.nextToken();
        variables = new HashMap<String, Integer>();
    }

    /**
     * 
     * @param expected
     * @throws ScanErrorException
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
     * 
     * @return
     * @throws ScanErrorException 
     */
    private int parseNumber() throws ScanErrorException
    {
        int num = Integer.parseInt(currToken);
        eat(currToken);
        return num;
    }

    /**
     * 
     * @return
     * @throws ScanErrorException
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
     * 
     * @return
     * @throws ScanErrorException
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
     * 
     * @return
     * @throws ScanErrorException
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
     * @throws ScanErrorException 
     * 
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
            System.out.println(currToken);
            eat(currToken);
            eat(":=");
            int val = parseExpr();
            eat(";");
            variables.put(key, val);
        }
    }
}
