package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * Component of an abstract syntax tree representing a While loop statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class While extends Statement
{
    private Condition cond;
    private Statement stmt;

    /**
     * Constructor for the While loop statement.
     * @param cond condition to check in the While loop statement
     * @param stmt statement to be executed in the loop
     */
    public While(Condition cond, Statement stmt)
    {
        this.cond = cond;
        this.stmt = stmt;
    }

    /**
     * Execution behavior of the While loop statement
     * @param env environment where all variable values are stored
     */
    public void exec(Environment env)
    {
        while (cond.eval(env) == 1)
        {
            stmt.exec(env);
        }
    }

    /**
     * Compile behavior of the While statement
     * @param e emitter that deals with the asm file
     */
    public void compile(Emitter e)
    {
        int labelID = e.nextLabelID();
        e.emit("while" + labelID + ":");
        cond.compile(e, "endwhile" + labelID);
        stmt.compile(e);
        e.emit("j while" + labelID);
        e.emit("endwhile" + labelID + ":");
    }
}
