package ast;

import java.util.List;

import environment.Environment;

public class Program
{
    private List<ProcedureDeclaration> procedures;
    private Statement statement;

    public Program(List<ProcedureDeclaration> procedures, Statement statement)
    {
        this.procedures = procedures;
        this.statement = statement;
    }

    public void exec(Environment env)
    {
        for (ProcedureDeclaration p : procedures)
        {
            p.exec(env);
        }
        statement.exec(env);
    }
}
