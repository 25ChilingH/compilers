package ast;

import environment.Environment;
import java.util.*;

/**
 * ProcedureCall object representing the calling of a procedure or function. 
 * 
 * @author Chiling Han
 * @version April 8, 2024
 */
public class ProcedureCall extends Expression
{
    private String procedureName;
    private List<Expression> args;

    /**
     * Constructor for the ProcedureCall object
     * @param procedureName the name of the procedure being called
     * @param args the list of arguments passed to the procedure call
     */
    public ProcedureCall(String procedureName, List<Expression> args)
    {
        this.procedureName = procedureName;
        this.args = args;
    }

    /**
     * Evaluation behavior of ProcedureCall object
     * @param env environment where all variable values and procedure declarations are stored
     * @return the value of the variable that has the same name as the procedure
     */
    public int eval(Environment env)
    {
        Environment currEnv = new Environment(env);
        ProcedureDeclaration procedure = env.getProcedure(procedureName);
        List<String> params = procedure.getParams();
        for (int i = 0; i < params.size(); i++)
        {
            currEnv.declareVariable(params.get(i), args.get(i).eval(env));
        }
        currEnv.setVariable(procedureName, 0);
        procedure.getStatement().exec(currEnv);

        return currEnv.getVariable(procedureName);
    }
}
