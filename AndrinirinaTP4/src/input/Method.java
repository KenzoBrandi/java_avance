package input;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 *  A class that represents a method of a class in a class diagram 
 */
public class Method implements Entity 
{
    /**
     * the name of the method 
     */
    private final String name;

    /**
     * the description of the method 
     */
    private final String documentation;

    /**
     * the type of the method result (may be null if the result is void or if the method is a constructor)
     */
    private final String type;

    /**
     * the parameters of the method
     */
    private final List<Parameter> parameters;

    /**
     * Constructor
     * 
     * @param name          name of the method 
     * @param documentation description of the method 
     * @param type          type of the method result (may be null if the result is void or if the method is a constructor)
     * @param parameters    parameters of the method
     */
    public Method(String name, String documentation, String type, List<Parameter> parameters)
    {
        this.name = name;
        this.documentation = documentation;
        this.type = type;
        this.parameters = parameters;
    }    

    /**
     * Check whether the method is a constructor
     * 
     * @return true if the method is a constructor
     */
    public boolean isConstructor()
    {
        return false;
    }

    /**
     * Check whether the method is concrete (i.e is not abstract and has a method body)
     * 
     * @return true if the method is concrete
     */
    public boolean isConcrete()
    {
        return false;
    }

    @Override
    public String getName() 
    {
        return this.name;
    }    

    /**
     * Give the description of the method
     * 
     * @return the method description
     */
    public String getDocumentation()
    {
        return this.documentation;
    }

    /**
     * Give the type of the method result (may be null if the result is void or if the method is a constructor)
     * 
     * @return the method result type
     */
    public String getType()
    {
        return this.type;
    }
    
    /**
     * Give the parameters of the method
     * 
     * @return the method parameters
     */
    public List<Parameter> getParameters()
    {
        return this.parameters;
    }

    @Override
    public String toString() {
        String string = "\n /**"+ documentation+"**/\n "+name+ "(";
        if (parameters != null){
            for (Parameter parameter : parameters){
                string += parameter.toString() +",";
            }
        }
        
        string += ")";
        if (type != null){
            string += ": "+type;
        }
        
        return string;
    }  
    
    public void generate(BufferedWriter writer) throws IOException{
        if (isConstructor()){
            writer.write("public "+getName()+"(");
        } else if (isConcrete()){
            writer.write("public "+type+" "+getName()+"(");
        } else{
            writer.write("public abstract "+type+" "+getName()+"(");
        }
        
        if (parameters != null){
            int i = 0;
            for (Parameter parameter : parameters){
                writer.write(parameter.getType()+" "+parameter.getName());
                if (i < parameters.size()-1){
                    writer.write(", ");
                }
                i++;
            }
        }
        writer.write(")");
        if (!isConcrete()){
            writer.write(";");
        }
    }
}
