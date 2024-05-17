package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * Component of an abstract syntax tree representing a numerical expression.
 * @author Chiling Han
 * @version March 20, 2024
 */
public abstract class Expression
{
    /**
     * Evaluation behavior of the expression
     * @param env environment where all variable values are stored
     * @return numerical equivalent of the expression
     */
    public abstract int eval(Environment env);

    /**
     * Compile behavior of the Expression
     * @param e emitter that all MIPS instructions will use to write to a file
     */
    public void compile(Emitter e)
    {
        throw new RuntimeException("Implement me!");
    }

}
