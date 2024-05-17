package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Writeln statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Writeln extends Statement
{
    private Expression exp;

    /**
     * Constructor representing Writeln statement.
     * @param exp expression to print out
     */
    public Writeln(Expression exp)
    {
        this.exp = exp;
    }

    /**
     * Execution behavior of the Writeln statement
     * @param env environment where all variable values are stored
     */
    public void exec(Environment env)
    {
        System.out.println(exp.eval(env));
    }

    /**
     * Compile behavior of the Writeln statement
     * @param e emitter that deals with the asm file
     */
    public void compile(Emitter e)
    {
        exp.compile(e);
        e.emit("move $a0 $v0");
        e.emit("li $v0 1");
        e.emit("syscall");

        e.emit("la $a0 newline");
        e.emit("li $v0 4");
        e.emit("syscall");

    }
    
}
