package input;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 *  A class that represents a concrete method of a class in a class diagram 
 */
public class ConcreteMethod extends Method 
{
    /**
     * the method body: the lines of the body
     */
    private final String[] body;

    /**
     * Constructor
     * 
     * @param name          name of the method 
     * @param documentation description of the method 
     * @param type          type of the method result (may be null if the result is void or if the method is a constructor)
     * @param parameters    parameters of the method
     * @param body          the lines of the method body
     */
    public ConcreteMethod(String name, String documentation, String type, List<Parameter> parameters, String[] body) 
    {
        super(name, documentation, type, parameters);
        this.body = body;
    }
    
    @Override
    public boolean isConcrete()
    {
        return true;
    }

    /**
     * Give the lines of the method body
     * 
     * @return the method body
     */
    public String[] getBody() 
    {
        return this.body;
    }

    @Override
    public String toString() {
        String str = super.toString() +"{ \n";
        for (String line : getBody()){
            str += line +"\n";
        }
        return str + "}";
    }
    public void generate(BufferedWriter writer) throws IOException{
        super.generate(writer);
        writer.write("{");
        for (String line : getBody()){
            writer.newLine();
            writer.write(line);
        }
        writer.write("}");
    }
}
