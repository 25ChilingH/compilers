package ast;

import java.util.List;

import emitter.Emitter;
import environment.Environment;

/**
 * Program object that contains a list of procedure declarations and a block statement.
 * 
 * @author Chiling Han
 * @version April 8, 2024
 */
public class Program
{
    private List<Var> vars;
    private List<ProcedureDeclaration> procedures;
    private Statement statement;
    private Emitter emitter;

    /**
     * Constructor for a Program object that contains procedures and statements
     * @param vars list of global variable names
     * @param procedures list of procedure declarations in the Program
     * @param statement block statement in the Program
     */
    public Program(List<Var> vars, List<ProcedureDeclaration> procedures, Statement statement)
    {
        this.vars = vars;
        this.procedures = procedures;
        this.statement = statement;
    }

    /**
     * Execution behavior of Program object
     * @param env environment where all variable values and procedure declarations are stored
     */
    public void exec(Environment env)
    {
        for (ProcedureDeclaration p : procedures)
        {
            p.exec(env);
        }
        statement.exec(env);
    }

    /**
     * Compile behavior of the Program
     * @param out path to write the MIPS asm file to
     */
    public void compile(String out)
    {
        emitter = new Emitter(out);

        emitter.emit(".data");
        emitter.emit("newline: .asciiz \"\\n\"");
        for (Var v : vars)
            v.compile(emitter);

        emitter.emit(".text");
        emitter.emit(".globl main");
        emitter.emit("main:");
        statement.compile(emitter);
        emitter.emit("li $v0 10");
        emitter.emit("syscall");

        emitter.close();
    }
}
