package ast;

import environment.Environment;

public class Assignment extends Statement
{
    private String var;
    private Expression exp;

    public Assignment(String var, Expression exp)
    {
        this.var = var;
        this.exp = exp;
    }

    public void exec(Environment env)
    {
        env.setVariable(var, exp.eval(env));
    }
}
