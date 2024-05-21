package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * Component of an abstract syntax tree representing an Assignment statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Assignment extends Statement
{
    private String var;
    private Expression exp;

    /**
     * Constructor for Assignment statement
     * @param var variable to be assigned
     * @param exp expression that variable is defined as
     */
    public Assignment(String var, Expression exp)
    {
        this.var = var;
        this.exp = exp;
    }

    /**
     * Execution behavior of the assignment statement
     * @param env environment where all variable values are stored
     * @postcondition variable is stored and assigned a value in the environment
     */
    public void exec(Environment env)
    {
        env.setVariable(var, exp.eval(env));
    }

    /**
     * @return the string of the variable name
     */
    public String getVariable()
    {
        return var;
    }

    /**
     * Compile behavior of the Assignment statement
     * @param e emitter that deals with the MIPS asm file
     */
    public void compile(Emitter e)
    {
        exp.compile(e);
        if (e.isLocalVariable(var))
        {
            e.emit("sw $v0 " + e.getOffset(var) + "($sp)");
        }
        else
        {
            e.emit("la $t0 var" + var);
            e.emit("sw $v0 ($t0)");
        }
    }
}
