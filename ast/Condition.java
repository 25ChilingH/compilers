package ast;

import environment.Environment;

public class Condition extends Expression
{
    private String relop;
    private Expression exp1;
    private Expression exp2;

    public Condition(String relop, Expression exp1, Expression exp2)
    {
        this.relop = relop;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

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
