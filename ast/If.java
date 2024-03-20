package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing an If/Else statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class If extends Statement
{
    private Condition cond;
    private Statement stmt1;
    private Statement stmt2;

    /**
     * Constructor for the If statement
     * @param cond condition to check in the If statement
     * @param stmt statement to be executed if condition is true
     */
    public If(Condition cond, Statement stmt)
    {
        this.cond = cond;
        this.stmt1 = stmt;
    }

    /**
     * Constructor for the If/Else statement
     * @param cond condition to check in the If statement
     * @param stmt1 statement to be executed if condition is true
     * @param stmt2 statement to be executed if condition is false
     */
    public If(Condition cond, Statement stmt1, Statement stmt2)
    {
        this.cond = cond;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

    /**
     * Execution behavior of the If/Else statement
     * @param env environment where all variable values are stored
     */
    public void exec(Environment env)
    {
        if (cond.eval(env) == 1)
        {
            stmt1.exec(env);
        }
        else if (stmt2 != null)
        {
            stmt2.exec(env);
        }
    }
}
