package environment;

import java.util.Map;
import java.util.HashMap;

public class Environment
{
    private Map<String, Integer> variables;

    public Environment()
    {
        variables = new HashMap<String, Integer>();
    }

    public void setVariable(String variable, int value)
    {
        variables.put(variable, value);
    }

    public int getVariable(String variable)
    {
        return variables.get(variable);
    }
}
