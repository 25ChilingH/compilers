package ast;
import java.util.*;

import emitter.Emitter;
import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Block statement.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Block extends Statement
{
    private List<Statement> stmts;
    
    /**
     * Constructor for Block statement
     * @param stmts list of statements in the Block
     */
    public Block(List<Statement> stmts)
    {
        this.stmts = stmts;
    }

    /**
     * Execution behavior of the Block statement
     * @param env environment where all variable values are stored
     */
    public void exec(Environment env)
    {
        for (Statement s: stmts)
        {
            s.exec(env);
        }
    }

    /**
     * Compile behavior of the Block expression
     * @param e emitter that deals with the MIPS asm file
     */
    public void compile(Emitter e)
    {
        for (Statement s: stmts)
        {
            s.compile(e);
        }
    }
}
