package parser;

import scanner.ScanErrorException;
import scanner.Scanner;
import java.io.*;

import environment.Environment;

/**
 * ParserTester is the tester for the Parser class by parsing a .txt file and converting source
 * code into a format a machine can understand
 * 
 * @author Chiling Han
 * @version 11 March 2024
 */
public class ParserTester
{

    /**
     * Default file path to parse
     */
    public static final String FILE_PATH = "./parser/parserTest8_5.txt";

    /**
     * Main method that will run the tester on the Parser class
     * @param args command line arguments; if present, the first String is the custom file path
     * @throws IOException if file path is not found
     * @throws ScanErrorException if Scanner encounters an unrecognized or illegal character
     */
    public static void main(String[] args) throws IOException, ScanErrorException
    {
        File file = new File((args.length > 0) ? args[0] : FILE_PATH);
        FileInputStream in = new FileInputStream(file);

        Scanner scan = new Scanner(in);
        Parser parser = new Parser(scan);
        Environment env = new Environment(null);
        parser.parseProgram().exec(env);
    }
}
