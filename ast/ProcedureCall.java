package ast;

import environment.Environment;
import java.util.*;

import emitter.Emitter;

/**
 * ProcedureCall object representing the calling of a procedure or function. 
 * 
 * @author Chiling Han
 * @version April 8, 2024
 */
public class ProcedureCall extends Expression
{
    private String name;
    private List<Expression> args;

    /**
     * Constructor for the ProcedureCall object
     * @param name the name of the procedure being called
     * @param args the list of arguments passed to the procedure call
     */
    public ProcedureCall(String name, List<Expression> args)
    {
        this.name = name;
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
        ProcedureDeclaration procedure = env.getProcedure(name);
        List<String> params = procedure.getParams();
        for (int i = 0; i < params.size(); i++)
        {
            currEnv.declareVariable(params.get(i), args.get(i).eval(env));
        }
        currEnv.setVariable(name, 0);
        procedure.getStatement().exec(currEnv);

        return currEnv.getVariable(name);
    }

    /**
     * Compile behavior of the Procedure Call statement
     * @param e emitter that deals with the asm file
     */
    public void compile(Emitter e)
    {
        e.emitPush("$ra");
        for (Expression arg: args)
        {
            arg.compile(e);
            e.emitPush("$v0");
        }
        e.emit("jal proc" + name);
        for (int i = 0; i < args.size(); i++)
            e.emitPop("$t0");
        e.emitPop("$ra");
    }
}
