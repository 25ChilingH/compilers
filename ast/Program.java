package ast;

import java.util.List;

import environment.Environment;

/**
 * Program object that contains a list of procedure declarations and a block statement.
 * 
 * @author Chiling Han
 * @version April 8, 2024
 */
public class Program
{
    private List<ProcedureDeclaration> procedures;
    private Statement statement;

    /**
     * Constructor for a Program object that contains procedures and statements
     * @param procedures list of procedure declarations in the Program
     * @param statement block statement in the Program
     */
    public Program(List<ProcedureDeclaration> procedures, Statement statement)
    {
        this.procedures = procedures;
        this.statement = statement;
    }

    /**
     * Execution behavior of Program object
     * @param env environment where all variable values and procedure declarations are stored
     */
    public void exec(Environment env)
    {
        for (ProcedureDeclaration p : procedures)
        {
            p.exec(env);
        }
        statement.exec(env);
    }
}
