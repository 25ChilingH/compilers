package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing an Assignment statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Assignment extends Statement
{
    private String var;
    private Expression exp;

    /**
     * Constructor for Assignment statement
     * @param var variable to be assigned
     * @param exp expression that variable is defined as
     */
    public Assignment(String var, Expression exp)
    {
        this.var = var;
        this.exp = exp;
    }

    /**
     * Execution behavior of the assignment statement
     * @param env environment where all variable values are stored
     * @postcondition variable is stored and assigned a value in the environment
     */
    public void exec(Environment env)
    {
        env.setVariable(var, exp.eval(env));
    }

    /**
     * @return the string of the variable name
     */
    public String getVariable()
    {
        return var;
    }
}
