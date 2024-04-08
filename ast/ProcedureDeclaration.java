package ast;

import environment.Environment;

public class ProcedureDeclaration extends Statement
{
    private String name;
    private Statement statement;

    public ProcedureDeclaration(String name, Statement statement)
    {
        this.name = name;
        this.statement = statement;
    }

    public Statement getStatement()
    {
        return statement;
    }

    public void exec(Environment env)
    {
        env.setProcedure(name, this);
    }
}
