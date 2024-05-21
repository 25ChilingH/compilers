package ast;

import environment.Environment;
import java.util.*;

import emitter.Emitter;

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
    private Var vars;
    private List<String> params;

    /**
     * Constructor for the ProcedureDeclaration object
     * @param name the name of the procedure being declared
     * @param vars list of local variable names
     * @param statement the block of statements in the procedure
     * @param params the parameters in the declaration of the procedure
     */
    public ProcedureDeclaration(String name, Var vars, Statement statement, List<String> params)
    {
        this.name = name;
        this.vars = vars;
        this.statement = statement;
        this.params = params;
    }

    /**
     * 
     * @return the name of the Procedure
     */
    public String getName()
    {
        return name;
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
     * 
     * @return the local variables in the procedure
     */
    public Var getVars()
    {
        return vars;
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

    /**
     * Compile behavior of the Procedure Declaration statement
     * @param e emitter that deals with the asm file
     */
    public void compile(Emitter e)
    {
        e.setProcedureContext(this);
        e.emit("proc" + name + ":");
        e.emitPush("$zero");
        vars.compile(e);
        statement.compile(e);
        for (int i = 0; i < vars.getNames().size(); i++)
        {
            e.emitPop("$t0");
        }
        e.emitPop("$v0");
        e.emit("jr $ra");
        e.clearProcedureContext();
    }
}
