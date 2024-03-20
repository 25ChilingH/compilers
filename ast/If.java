package ast;

import environment.Environment;

public class If extends Statement
{
    private Condition cond;
    private Statement stmt1;
    private Statement stmt2;

    public If(Condition cond, Statement stmt)
    {
        this.cond = cond;
        this.stmt1 = stmt;
    }

    public If(Condition cond, Statement stmt, Statement stmt2)
    {
        this.cond = cond;
        this.stmt1 = stmt;
        this.stmt2 = stmt2;
    }

    public void exec(Environment env)
    {
        if (cond.eval(env) == 1)
        {
            stmt1.exec(env);
        }
        else if (stmt2 != null)
        {
            stmt2.exec(env);
        }
    }
}
