package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * Component of an abstract syntax tree representing a For loop statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class For extends Statement
{
    private Assignment assign;
    private Expression check;
    private Statement block;

    /**
     * Constructor representing a For loop statement
     * @param assign variable counter assignment
     * @param check expression to check variable against during looping
     * @param block list of statements to execute in the loop
     */
    public For(Assignment assign, Expression check, Statement block)
    {
        this.assign = assign;
        this.check = check;
        this.block = block;
    }

    /**
     * Execution behavior of the For loop statement
     * @param env environment where all variable values are stored
     * @postcondition counter variable is stored and incremented in environment
     */
    public void exec(Environment env)
    {
        assign.exec(env);
        String varName = assign.getVariable();
        env.setVariable(varName, env.getVariable(assign.getVariable()));
        int limit = check.eval(env);

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

    /**
     * Compile behavior of the For statement
     * @param e emitter that deals with the asm file
     */
    public void compile(Emitter e)
    {
        assign.compile(e);
        int labelId = e.nextLabelID();
        e.emit("for" + labelId + ":");
        e.emit("lw $t1 var" + assign.getVariable()); // counter
        check.compile(e); // limit
        e.emit("bgt $t1 $v0 endfor" + labelId);
        block.compile(e);
        e.emit("lw $t1 var" + assign.getVariable()); // counter
        e.emit("addu $t1 $t1 1"); // increment counter
        e.emit("sw $t1 var" + assign.getVariable());
        e.emit("j for" + labelId);
        e.emit("endfor" + labelId + ":");
    }
}
