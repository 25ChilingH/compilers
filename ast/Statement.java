package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public abstract class Statement
{
    /**
     * Execution behavior of the Statement
     * @param env environment where all variable values are stored
     */
    public abstract void exec(Environment env);

}
