package scanner;

import java.io.*;

/**
 * ScannerTester is the tester for the Scanner class by tokenizing a .txt file
 * 
 * @author Chiling Han
 * @version 25 January 2024
 */
public class ScannerJFlexTester
{

    /**
     * Default file path to retrieve tokens from
     */
    public static final String FILE_PATH = "./scanner/gists.json";

    /**
     * Main method that will run the tester on the Scanner class
     * @param args command line arguments; if present, the first String is the custom file path
     * @throws IOException if file path is not found
     * @throws ScanErrorException if Scanner encounters an unrecognized or illegal character
     */
    public static void main(String[] args) throws IOException, ScanErrorException
    {
        File file = new File((args.length > 0) ? args[0] : FILE_PATH);
        FileReader in = new FileReader(file);

        Scanner scan = new Scanner(in);
        String token = scan.nextToken();
        while (!scan.yyatEOF())
        {
            System.out.println(token);
            token = scan.nextToken();
        }
        System.out.println(token);

    }
    
    
}
