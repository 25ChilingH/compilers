package ast;

import environment.Environment;

public class If extends Statement
{
    private Condition cond;
    private Statement stmt;

    public If(Condition cond, Statement stmt)
    {
        this.cond = cond;
        this.stmt = stmt;
    }

    public void exec(Environment env)
    {
        if (cond.eval(env) == 1)
        {
            stmt.exec(env);
        }
    }
}
