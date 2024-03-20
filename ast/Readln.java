package ast;

import java.util.Scanner;

import environment.Environment;

public class Readln extends Statement
{
    private String var;

    public Readln(String var)
    {
        this.var = var;
    }

    public void exec(Environment env)
    {
        Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();
        env.setVariable(var, val);
        scan.close();
    }
}
