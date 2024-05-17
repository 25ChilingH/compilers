package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * Component of an abstract syntax tree representing a Condition expression.
 * @author Chiling Han
 * @version March 20, 2024
 */
public class Condition extends Expression
{
    private String relop;
    private Expression exp1;
    private Expression exp2;

    /**
     * Constructor for the Condition expression
     * @param relop relation operator to compare the two expressions
     * @param exp1 first expression to be compared with the second
     * @param exp2 second expression to be compared with the first
     */
    public Condition(String relop, Expression exp1, Expression exp2)
    {
        this.relop = relop;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * Evaluation behavior of the Condition expression
     * @param env environment where all variable values are stored
     * @return the boolean equivalent of the Condition expression
     */
    public int eval(Environment env)
    {
        if (relop.equals("="))
        {
            return (exp1.eval(env) == exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals("<>"))
        {
            return (exp1.eval(env) != exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals("<"))
        {
            return (exp1.eval(env) < exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals(">"))
        {
            return (exp1.eval(env) > exp2.eval(env)) ? 1 : 0;
        }
        else if (relop.equals("<="))
        {
            return (exp1.eval(env) <= exp2.eval(env)) ? 1 : 0;
        }
        else
        {
            return (exp1.eval(env) >= exp2.eval(env)) ? 1 : 0;
        }
        
    }

    /**
     * Compile behavior of the Condition expression
     * @param e emitter that deals with the asm file
     * @param targetLabel the label to branch to if the condition is false
     */
    public void compile(Emitter e, String targetLabel)
    {
        exp1.compile(e);
        e.emitPush("$v0");
        exp2.compile(e);
        e.emitPop("$t1");
        if (relop.equals("="))
        {
            e.emit("bne $t1 $v0 " + targetLabel);
        }
        else if (relop.equals("<>"))
        {
            e.emit("beq $t1 $v0 " + targetLabel);
        }
        else if (relop.equals("<"))
        {
            e.emit("bge $t1 $v0 " + targetLabel);
        }
        else if (relop.equals(">"))
        {
            e.emit("ble $t1 $v0 " + targetLabel);
        }
        else if (relop.equals("<="))
        {
            e.emit("bgt $t1 $v0 " + targetLabel);
        }
        else
        {
            e.emit("blt $t1 $v0 " + targetLabel);
        }
    }
}
