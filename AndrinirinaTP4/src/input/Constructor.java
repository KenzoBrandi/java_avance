package input;

import java.util.List;

/**
 *  A class that represents a constructor of a class in a class diagram 
 */
public class Constructor extends ConcreteMethod 
{
    /**
     * Constructor
     * 
     * @param name          name of the method 
     * @param documentation description of the method 
     * @param parameters    parameters of the method
     * @param body          the lines of the method body
     */
    public Constructor(String name, String documentation, List<Parameter> parameters, String[] body) 
    {
        super(name, documentation, null, parameters, body);
    }
    
    @Override
    public boolean isConstructor()
    {
        return true;
    }

}
