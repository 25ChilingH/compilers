package environment;

import java.util.Map;

import ast.ProcedureDeclaration;

import java.util.HashMap;

/**
 * Stores variables and contains functionality for setting/getting variables. Has
 * hierarchy for procedure environments for handling procedure calls within
 * procedure calls.
 * 
 * @author Chiling Han
 * @version April 8, 2024
 */
public class Environment
{
    private Map<String, Integer> variables;
    private Map<String, ProcedureDeclaration> procedures;
    private Environment parent;

    /**
     * Constructs an Environment object
     * @param parent
     */
    public Environment(Environment parent)
    {
        variables = new HashMap<String, Integer>();
        procedures = new HashMap<String, ProcedureDeclaration>();
        this.parent = parent;
    }

    /**
     * Stores variable in current environment with corresponding value.
     * @param variable declared variable to be stored in the current environment
     * @param value value that corresponds to the variable
     */
    public void declareVariable(String variable, int value)
    {
        variables.put(variable, value);
    }

    /**
     * Reassigns variable in the parent environment that has the variable stored if the
     * variable cannot be found in the current environment. Otherwise, store it in the current
     * environment. Handles variable scope.
     * 
     * @param variable declared variable to be stored in an environment
     * @param value value that corresponds to the variable
     */
    public void setVariable(String variable, int value)
    {
        Environment env = getHasVarEnvironment(variable);
        if (env != null)
            env.variables.put(variable, value);
        else
            variables.put(variable, value);
    }

    /**
     * Keeps going up the hierarchy until environment with the variable stored is reached
     * @param variable the variable to check if stored in environment
     * @return the environment that has the variable stored
     */
    private Environment getHasVarEnvironment(String variable)
    {
        Environment global = this;
        while (global != null && !global.hasVariable(variable))
        {
            global = global.parent;
        }
        return global;
    }

    /**
     * Retrieves variable value and handles variable scope.
     * @param variable declared variable stored in the environment
     *                 or a parent environment
     * @return the value of the variable in the environment
     */
    public int getVariable(String variable)
    {
        Environment env = getHasVarEnvironment(variable);
        if (env == null)
        {
            return 0;
        }
        return env.variables.get(variable);
    }

    /**
     * @param variable variable to check if stored in current environment
     * @return true if variable is stored in the current environment; false otherwise
     */
    public boolean hasVariable(String variable)
    {
        return variables.containsKey(variable);
    }

    /**
     * @param procedureName name of the procedure to retrieve
     * @return block of statements in procedure declaration
     */
    public ProcedureDeclaration getProcedure(String procedureName)
    {
        return getGlobalEnvironment().procedures.get(procedureName);
    }

    /**
     * Stores procedure in global environment with corresponding declaration.
     * @param procedureName name of the procedure 
     * @param procedure block of statements in procedure declaration
     */
    public void setProcedure(String procedureName, ProcedureDeclaration procedure)
    {
        getGlobalEnvironment().procedures.put(procedureName, procedure);
    }

    /**
     * Keeps going up the hierarchy until global environment reached
     * @return the global environment
     */
    private Environment getGlobalEnvironment()
    {
        Environment global = this;
        while (global.parent != null)
        {
            global = global.parent;
        }
        return global;
    }
}
