package environment;

import java.util.Map;

import ast.ProcedureDeclaration;

import java.util.HashMap;

public class Environment
{
    private Map<String, Integer> variables;
    private Map<String, ProcedureDeclaration> procedures;

    public Environment()
    {
        variables = new HashMap<String, Integer>();
        procedures = new HashMap<String, ProcedureDeclaration>();
    }

    public void setVariable(String variable, int value)
    {
        variables.put(variable, value);
    }

    public int getVariable(String variable)
    {
        return variables.get(variable);
    }

    public ProcedureDeclaration getProcedure(String procedureName)
    {
        return procedures.get(procedureName);
    }

    public void setProcedure(String procedureName, ProcedureDeclaration procedure)
    {
        procedures.put(procedureName, procedure);
    }
}
