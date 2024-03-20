package ast;

import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Variable expression.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Variable extends Expression
{
    private String name;

    /**
     * Constructor for the Variable expression.
     * @param name the name of the variable
     */
    public Variable(String name)
    {
        this.name = name;
    }

    /**
     * Evaluation behavior of the Variable expression
     * @param env environment where all variable values are stored
     * @return the number stored in the variable
     */
    public int eval(Environment env)
    {
        return env.getVariable(name);
    }
    
}
