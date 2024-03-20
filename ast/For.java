package ast;

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
        int limit = check.eval(env);
        env.setVariable(varName, env.getVariable(assign.getVariable()));

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
}
