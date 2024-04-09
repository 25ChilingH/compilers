package ast;

import environment.Environment;
import java.util.*;

/**
 * ProcedureDeclaration object representing the declaration of a procedure or function. 
 * 
 * @author Chiling Han
 * @version April 8, 2024
 */
public class ProcedureDeclaration extends Statement
{
    private String name;
    private Statement statement;
    private List<String> params;

    /**
     * Constructor for the ProcedureDeclaration object
     * @param name the name of the procedure being declared
     * @param statement the block of statements in the procedure
     * @param params the parameters in the declaration of the procedure
     */
    public ProcedureDeclaration(String name, Statement statement, List<String> params)
    {
        this.name = name;
        this.statement = statement;
        this.params = params;
    }

    /**
     * @return the block statement in the declared procedure
     */
    public Statement getStatement()
    {
        return statement;
    }

    /**
     * @return the list of parameter names in the declared procedure
     */
    public List<String> getParams()
    {
        return params;
    }

    /**
     * Execution behavior of ProcedureDeclaration object. Stores the procedure
     * in the environment.
     * @param env environment where all variable values and procedure declarations are stored
     */
    public void exec(Environment env)
    {
        env.setProcedure(name, this);
    }
}
