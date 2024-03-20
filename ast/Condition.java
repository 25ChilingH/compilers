package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Condition expression.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Condition extends Expression
{
    private String relop;
    private Expression exp1;
    private Expression exp2;

    /**
     * Constructor for the Condition expression
     * @param relop relation operator to compare the two expressions
     * @param exp1 first expression to be compared with the second
     * @param exp2 second expression to be compared with the first
     */
    public Condition(String relop, Expression exp1, Expression exp2)
    {
        this.relop = relop;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * Evaluation behavior of the Condition expression
     * @param env environment where all variable values are stored
     * @return the boolean equivalent of the Condition expression
     */
    public int eval(Environment env)
    {
        if (relop.equals("="))
        {
            return (exp1.eval(env) == exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals("<>"))
        {
            return (exp1.eval(env) != exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals("<"))
        {
            return (exp1.eval(env) < exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals(">"))
        {
            return (exp1.eval(env) > exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals("<="))
        {
            return (exp1.eval(env) <= exp2.eval(env)) ? 1 : 0;
        }
        else
        {
            return (exp1.eval(env) >= exp2.eval(env)) ? 1 : 0;
        }
        
    }
}
