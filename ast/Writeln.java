package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Writeln statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Writeln extends Statement
{
    private Expression exp;

    /**
     * Constructor representing Writeln statement.
     * @param exp expression to print out
     */
    public Writeln(Expression exp)
    {
        this.exp = exp;
    }

    /**
     * Execution behavior of the Writeln statement
     * @param env environment where all variable values are stored
     */
    public void exec(Environment env)
    {
        System.out.println(exp.eval(env));
    }
    
}
