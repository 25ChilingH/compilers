package ast;

import environment.Environment;

public class ProcedureCall extends Expression
{
    private String procedureName;

    public ProcedureCall(String procedureName)
    {
        this.procedureName = procedureName;
    }

    public int eval(Environment env)
    {
        env.getProcedure(procedureName).getStatement().exec(env);
        return 0;
    }
    
}
