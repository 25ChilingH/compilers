package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing a BinOp, a numerical
 * expression with an operator.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class BinOp extends Expression
{
    private String op;
    private Expression exp1;
    private Expression exp2;

    /**
     * Constructor for the BinOp numerical expression with an operator.
     * @param op operator (addition, subtraction, division, multiplication)
     * @param exp1 first expression evaluated with second using the operator
     * @param exp2 second expression evaluated with first using the operator
     */
    public BinOp(String op, Expression exp1, Expression exp2)
    {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    
    /**
     * Evaluation behavior of the BinOp expression
     * @param env environment where all variable values are stored
     * @return the numerical equivalent of the BinOp expression
     */
    public int eval(Environment env)
    {
        if (op.equals("+"))
        {
            return exp1.eval(env) + exp2.eval(env);
        }
        else if (op.equals("-"))
        {
            return exp1.eval(env) - exp2.eval(env);
        }
        else if (op.equals("*"))
        {
            return exp1.eval(env) * exp2.eval(env);
        }
        else
        {
            return exp1.eval(env) / exp2.eval(env);
        }
    }
}
