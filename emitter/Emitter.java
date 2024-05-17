package emitter;
import java.io.*;

/**
 * A simple class that allows you to write to a file. Our compiler will use it to output
 * MIPS instructions to a text file.
 * 
 * @author Chiling Han
 * @version April 30, 2024
 */
public class Emitter
{
    private PrintWriter out;
    private int id;

    /**
     * Creates an emitter for writing to a new file with given name
     * @param outputFileName the path of the new file to write to
     */
    public Emitter(String outputFileName)
    {
        try
        {
            out = new PrintWriter(new FileWriter(outputFileName), true);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prints one line of code to file (with non-labels indented)
     * @param code the String that contains the MIPS instruction to write to the text file
     */
    public void emit(String code)
    {
        if (!code.endsWith(":"))
            code = "\t" + code;
        out.println(code);
    }

    /**
     * Push the value of the register into the stack pointed to by $sp
     * @param reg contains value to push onto the stack
     */
    public void emitPush(String reg)
    {
        emit("subu $sp $sp 4");
        emit("sw " + reg + " ($sp)");
    }

    /**
     * Pop the value of the topmost stack and store it into a register
     * @param reg contains value after popping out of stack
     */
    public void emitPop(String reg)
    {
        emit("lw " + reg + " ($sp)");
        emit("addu $sp $sp 4");
    }

    public int nextLabelID()
    {
        id++;
        return id;
    }

    /**
     * Closes the file.  should be called after all calls to emit.
     */
    public void close()
    {
        out.close();
    }
}