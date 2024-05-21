package ast;

import java.util.List;

import emitter.Emitter;
import environment.Environment;

/**
 * This class represents the global variables declared at the start of the program
 * that will be stored in the .data section in MIPS.
 * 
 * @author Chiling Han
 * @version 16 May 2024
 */
public class Var extends Statement
{
    private List<String> names;

    /**
     * Constructor for the Var statement
     * @param names names of all the variables
     */
    public Var(List<String> names)
    {
        this.names = names;

    }

    /**
     * 
     * @return the list of variable names
     */
    public List<String> getNames()
    {
        return names;
    }

    /**
     * Execution behavior of the Var statement
     * @param env environment where all variable values are stored
     */
    public void exec(Environment env)
    {
        for (String n: names)
        {
            env.declareVariable(n, 0);
        }
    }

    /**
     * Compile behavior of the Var statement
     * @param e emitter that deals with the asm file
     */
    public void compile(Emitter e)
    {
        for (String n: names)
        {
            if (e.isLocalVariable(n))
            {
                e.emitPush("$zero");
            }
            else
            {
                e.emit("var" + n + ": .word 0");
            }
        }
    }
}
