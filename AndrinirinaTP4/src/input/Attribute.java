package input;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *  A class that represents an attribute of a class in a class diagram 
 */
public class Attribute implements Entity
{
    /**
     * the name of the attribute 
     */
    private final String name;

    /**
     * the description of the attribute 
     */
    private final String documentation;

    /**
     * the type of the attribute (primitive type or class or interface name)
     */
    private final String type;

    /**
     * Constructor
     * 
     * @param name          name of the attribute 
     * @param documentation description of the attribute
     * @param type          type of the attribute
     */
    public Attribute(String name, String documentation, String type)
    {
        this.name = name;
        this.documentation = documentation;
        this.type = type;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    /**
     * Give the description of the attribute
     * 
     * @return the attribute description
     */
    public String getDocumentation()
    {
        return this.documentation;
    }

    /**
     * Give the type of the attribute (primitive type or class or interface name)
     * 
     * @return the attribute type
     */
    public String getType()
    {
        return this.type;
    }

    @Override
    public String toString() {
        return "\n /**"+ documentation+ " **/ "+name+ ": "+type;
    } 
    
    public void generate(BufferedWriter writer) throws IOException{
        writer.write("private "+type+" "+getName()+";");
    }
}
