package input;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * A class that represents a parameter of a method of a class in a class diagram
 */
public class Parameter implements Entity 
{
    /**
     * the name of the parameter 
     */
    private final String name;

    /**
     * the type of the parameter 
     */
    private final String type;

    /**
     * Constructor 
     * 
     * @param name name of the parameter
     * @param type type of the parameter
     */
    public Parameter(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() 
    {
        return this.name;
    }

    /**
     * Give the type of the parameter (primitive type or class or interface name)
     * 
     * @return the parameter type
     */
    public String getType()
    {
        return this.type;
    }
    
    @Override
    public String toString() {
        return  name+ ": "+type;
    }    
    public void generate(BufferedWriter writer) throws IOException{
        writer.write("private "+type+" "+getName()+";");
    }

}
