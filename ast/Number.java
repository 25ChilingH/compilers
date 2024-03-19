package ast;

import environment.Environment;

public class Number extends Expression
{
    private int val;

    public Number(int val)
    {
        this.val = val;
    }

    public int eval(Environment env)
    {
        return val;
    }
    
}
