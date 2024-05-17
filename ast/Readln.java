package ast;

import java.util.Scanner;

import emitter.Emitter;
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

    /**
     * Compile behavior of the Readln statement
     * @param e emitter that deals with the asm file
     */
    public void compile(Emitter e)
    {
        e.emit("li $v0 5");
        e.emit("syscall");
        e.emit("la $t0 var" + var);
        e.emit("sw $v0 ($t0)");
    }
}
