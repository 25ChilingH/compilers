package scanner;

import java.io.*;

/**
 * Scanner is a simple scanner for the class Compilers and Interpreters. Processes a text input
 * file by reading characters sequentially, breaking them into tokens, and subsequently providing
 * these tokens through the nextToken() function.
 * 
 * @author Chiling Han
 * @version Jan 25, 2024
 *
 * Usage: java ScannerTester
 *
 */
public class ScannerOriginal
{
    private BufferedReader in;
    private char currentChar;
    private boolean eof;

    /**
     * Scanner constructor for construction of a scanner that
     * uses an InputStream object for input.
     * Usage:
     * FileInputStream inStream = new FileInputStream(new File(<file name>);
     * Scanner lex = new Scanner(inStream);
     * 
     * @param inStream the input stream to use
     */
    public ScannerOriginal(InputStream inStream)
    {
        in = new BufferedReader(new InputStreamReader(inStream));
        eof = false;
        getNextChar();
    }

    /**
     * Scanner constructor for constructing a scanner that
     * scans a given input string. It sets the end-of-file flag an then reads
     * the first character of the input string into the instance field currentChar.
     * Usage: Scanner lex = new Scanner(input_string);
     * 
     * @param inString the string to scan
     */
    public ScannerOriginal(String inString)
    {
        in = new BufferedReader(new StringReader(inString));
        eof = false;
        getNextChar();
    }

    /**
     * Gets the next character from the BufferedReader.
     * Sets the eof flag to true if the next character read is -1.
     */
    private void getNextChar()
    {
        try
        {
            int temp = in.read();
            if (temp == -1)
                eof = true;
            currentChar = (char) temp;
        }
        catch (IOException e)
        {
            System.out.println("No next character can be read.");
        }

    }

    /**
     * Gets the next character and ensures that it matches the expected char
     * 
     * @param expected the expected character
     * @throws ScanErrorException if the expected character does not match
     *                            the current character
     */
    private void eat(char expected) throws ScanErrorException
    {
        if (currentChar != expected)
        {
            throw new ScanErrorException("Illegal character: expected <" + currentChar
                    + "> and found <" + expected + ">");
        }
        else
        {
            getNextChar();
        }
    }

    /**
     * Checks if the end of file has been reached
     * 
     * @return true if the eof flag is false, else false
     */
    public boolean hasNext()
    {
        return !eof;
    }

    /**
     * Breaks the input stream into tokens and returns them
     * @return the String next token which represents an identifier, operand, comment, or number
     * @throws ScanErrorException if the current char is an unrecognized character
     */
    public String nextToken() throws ScanErrorException
    {
        while (isWhiteSpace(currentChar))
        {
            eat(currentChar);
        }

        try
        {
            if (hasNext())
            {
                if (isLetter(currentChar))
                {
                    return scanIdentifier();
                }
                else if (isOperand(currentChar))
                {
                    return scanOperand();
                }
                else if (isDigit(currentChar))
                {
                    return scanNumber();
                }
                else if (isPeriod(currentChar))
                {
                    eof = true;
                    return "EOF";
                }
                else
                {
                    char temp = currentChar;
                    eat(currentChar);
                    throw new ScanErrorException("Unrecognized character: " + temp);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            // System.exit(-1);
        }
        if (eof)
            return "EOF";
        else
            return "";
    }

    /**
     * 
     * @param c char to check
     * @return true if c is a period, else false
     */
    public boolean isPeriod(char c)
    {
        return c == '.';
    }

    /**
     * Checks if the given char is one of the following
     * characters: '=', '+', '-', '*', '/', '%', '(', ')'
     *
     * @param c char to check
     * @return true if c is an operand, else false
     */
    public static boolean isOperand(char c)
    {
        char[] operands = {'>', ':', '<', '=', '+', '-', '*', '/', '%', '(', ')' };
        for (char op : operands)
        {
            if (op == c)
                return true;
        }
        return false;
    }

    /**
     * Checks if the given char is a digit between '0' and '9'
     *
     * @param c char to check
     * @return true if c is a digit, else false
     */
    public static boolean isDigit(char c)
    {
        return '0' <= c && c <= '9';
    }

    /**
     * Checks if the given char is a letter between 'A' and 'Z' or
     * 'a' and 'z'
     *
     * @param c char to check
     * @return true if c is a letter, else false
     */
    public static boolean isLetter(char c)
    {
        return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z';
    }

    /**
     * Checks if the given char is one of the following
     * characters: ' ', '\t', '\r', '\n'
     * 
     * @param c char to check
     * @return true if c is a whitespace, else false
     */
    public static boolean isWhiteSpace(char c)
    {
        char[] whiteSpace = { ' ', '\t', '\r', '\n' };
        for (char wc : whiteSpace)
        {
            if (wc == c)
                return true;
        }
        return false;
    }

    /**
     * Ignores comments denoted by "//"
     * 
     * @preconddition currentChar and previous character is '/'
     * @return empty string
     * @throws ScanErrorException if the token is not a comment
     */
    private String scanComment() throws ScanErrorException
    {
        while (currentChar != '\n')
        {
            eat(currentChar);
        }
        return "";

    }

    /**
     * Retrieves a number token starting from the current character
     * 
     * @precondition currentChar is a digit
     * @return number token that is all digits
     * @throws ScanErrorException if the token is not a sequence of digits
     */
    private String scanNumber() throws ScanErrorException
    {
        String number = "";
        while (isDigit(currentChar))
        {
            number += currentChar;
            eat(currentChar);
        }
        return number;

    }

    /**
     * Retrieves an identifier token starting from the current character
     * 
     * @precondition currentChar is a letter
     * @return identifier token that is a combination of digits and letters
     * @throws ScanErrorException if the token is not a combo of digits and letters
     */
    private String scanIdentifier() throws ScanErrorException
    {
        String identifier = "";

        while (isDigit(currentChar) || isLetter(currentChar))
        {
            identifier += currentChar;
            eat(currentChar);
        }

        return identifier;
    }

    /**
     * Retrieves an operand token starting from the current character
     * 
     * @precondition currentChar is an operand
     * @return operand token that is one operand
     * @throws ScanErrorException if the token is not an operand
     */
    private String scanOperand() throws ScanErrorException
    {
        String operand = "";
        operand += currentChar;
        eat(currentChar);
        if (operand.equals("/"))
        {
            if (currentChar == '/')
            {
                return scanComment();
            }
        }
        else if (operand.equals("<"))
        {
            if (currentChar == '=' || currentChar == '>')
            {
                char temp = currentChar;
                eat(currentChar);
                return operand + temp;
            }
        }
        else if (operand.equals(">"))
        {
            if (currentChar == '=')
            {
                eat(currentChar);
                return ">=";
            }
        }
        else if (operand.equals(":"))
        {
            if (currentChar == '=')
            {
                eat(currentChar);
                return ":=";
            }
        }
        return operand;
    }

}
