package ast;

import environment.Environment;

public class BinOp extends Expression
{
    private String op;
    private Expression exp1;
    private Expression exp2;

    public BinOp(String op, Expression exp1, Expression exp2)
    {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    
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
