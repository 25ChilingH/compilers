package emitter;
import java.io.*;
import java.util.List;

import ast.ProcedureDeclaration;
import ast.Var;

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
    private ProcedureDeclaration currContext;
    private int excessStackHeight;

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
        excessStackHeight++;
        emit("subu $sp $sp 4");
        emit("sw " + reg + " ($sp)");
    }

    /**
     * Pop the value of the topmost stack and store it into a register
     * @param reg contains value after popping out of stack
     */
    public void emitPop(String reg)
    {
        excessStackHeight--;
        emit("lw " + reg + " ($sp)");
        emit("addu $sp $sp 4");
    }

    /**
     * @return the id of the MIPS label 
     */
    public int nextLabelID()
    {
        id++;
        return id;
    }


    /**
     * Remember proc as the current procedure context
     * @param proc procedure to remember as the current
     */
    public void setProcedureContext(ProcedureDeclaration proc)
    {
        excessStackHeight = 0;
        currContext = proc;
    }

    /**
     * Clear the current procedure context
     */
    public void clearProcedureContext()
    {
        currContext = null;
    }

    /**
     * @param varName the variable to check if it's a local variable in the
     *                current procedure context
     * @return true if the variable is a local variable in the current procedure context;
     *         false otherwise
     */
    public boolean isLocalVariable(String varName)
    {
        if (currContext != null)
        {
            if (varName.equals(currContext.getName()))
            {
                return true;
            }
            List<String> params = currContext.getParams();
            for (String param: params)
            {
                if (param.equals(varName))
                {
                    return true;
                }
            }
            Var vars = currContext.getVars();
            for (String s: vars.getNames())
            {
                if (s.equals(varName))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @precondition localVarName is the name of a local variable
     *               for the procedure currently being compiled 
     * @param localVarName the variable to find the offset of the stack pointer from
     * @return the offset from $sp
     */
    public int getOffset(String localVarName)
    {
        List<String> params = currContext.getParams();
        List<String> localVars = currContext.getVars().getNames();
        int idxParam = params.indexOf(localVarName);
        if (idxParam == -1)
        {
            if (localVarName.equals(currContext.getName()))
            {
                return (excessStackHeight - 1) * 4;
            }
            else
            {
                int idxVars = localVars.indexOf(localVarName);
                return (excessStackHeight - idxVars - 1) * 4;
            }
        }
        return (excessStackHeight + params.size() - idxParam - 1) * 4;
    }

    /**
     * Closes the file. Should be called after all calls to emit.
     */
    public void close()
    {
        out.close();
    }
}