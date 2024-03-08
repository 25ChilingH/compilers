package parser;

import scanner.ScanErrorException;
import scanner.Scanner;
import java.io.*;

/**
 * 
 */
public class ParserTester
{

    /**
     * Default file path to parse
     */
    public static final String FILE_PATH = "./parser/parserTest4.txt";

    /**
     * 
     * @param args
     * @throws IOException
     * @throws ScanErrorException
     */
    public static void main(String[] args) throws IOException, ScanErrorException
    {
        File file = new File((args.length > 0) ? args[0] : FILE_PATH);
        FileInputStream in = new FileInputStream(file);

        Scanner scan = new Scanner(in);
        Parser parser = new Parser(scan);
        while (scan.hasNext())
        {
            parser.parseStatement();
        }
    }
}
