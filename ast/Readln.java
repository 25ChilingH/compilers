package ast;

import java.util.Scanner;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Readln statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Readln extends Statement
{
    private String var;

    /**
     * Constructor representing the Readln statement
     * @param var variable to store user input
     */
    public Readln(String var)
    {
        this.var = var;
    }

    /**
     * Execution behavior of the Readln statement
     * @param env environment where all variable values are stored
     */
    public void exec(Environment env)
    {
        Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();
        env.setVariable(var, val);
        scan.close();
    }
}
