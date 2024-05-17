package emitter;

import scanner.ScanErrorException;
import scanner.Scanner;
import java.io.*;

import parser.Parser;

/**
 * EmitterTester is the tester for the Emitter by compiling the program and
 * writing to a .txt file containing MIPS instructions.
 * 
 * @author Chiling Han
 * @version April 30, 2024
 */
public class EmitterTester
{

    /**
     * Default file path to write to
     */
    public static final String OUTPUT_FILE = "./emitter/main.txt";

    /**
     * Default file path of PASCAL code
     */
    public static final String FILE_PATH = "./emitter/emitterTest1.txt";

    /**
     * Main method that will run the tester on the Emitter class
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
        parser.parseProgram().compile(OUTPUT_FILE);
    }
}
