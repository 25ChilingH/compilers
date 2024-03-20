package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Number expression.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Number extends Expression
{
    private int val;

    /**
     * Constructor representing the Number expression
     * @param val value of the number
     */
    public Number(int val)
    {
        this.val = val;
    }

    /**
     * Evaluation behavior of the Number expression
     * @param env environment where all variable values are stored
     * @return the numerical equivalent of the Number
     */
    public int eval(Environment env)
    {
        return val;
    }
    
}
