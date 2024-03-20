package ast;

import environment.Environment;

public class For extends Statement
{
    private Assignment assign;
    private Expression check;
    private Statement block;

    public For(Assignment assign, Expression check, Statement block)
    {
        this.assign = assign;
        this.check = check;
        this.block = block;
    }

    public void exec(Environment env)
    {
        assign.exec(env);
        String varName = assign.getVariable();
        int limit = check.eval(env);
        env.setVariable(varName, env.getVariable(assign.getVariable()));

        if (env.getVariable(varName) > limit)
        {
            for (int i = env.getVariable(varName); i >= limit; i--)
            {
                block.exec(env);
                env.setVariable(varName, env.getVariable(varName) - 1);
            }
        }
        else
        {
            for (int i = env.getVariable(varName); i <= limit; i++)
            {
                block.exec(env);
                env.setVariable(varName, env.getVariable(varName) + 1);
            }
        }
    }
}
