package input;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Interface implements Entity{
    /**
     * the name of the Interface
     */
    private final String name;

    /**
     * the description of the Interface 
     */
    private final String documentation;

    /**
     * the super-Interface of the interface (null if the Interface has no super-Interface) 
     */
    private final Interface superInterface;


    /**
     * the methods of the interface
     */
    private final List<Method> methods;

    /**
     * Constructor
     * 
     * @param name          name of the interface
     * @param documentation description of the interface
     * @param superInterface    super-Interface of the interface (null if the Interface has no super-Interface)
     * @param methods       methods of the interface
     */
        
    public Interface(String name, String documentation, Interface superInterface, List<Method> methods){
        this.name = name;
        this.documentation = documentation;
        this.superInterface = superInterface;
        this.methods = methods;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    /**
     * Give the description of the interface
     * 
     * @return the interface description
     */
    public String getDocumentation()
    {
        return this.documentation;
    }

    /**
     * Give the super-Interface of the interface
     * 
     * @return the super-Interface of the interface (may be null)
     */
    public Interface getSuperInterface()
    {
        return this.superInterface;
    }

    /**
     * Give the methods of the interface
     * 
     * @return the interface methods
     */
    public List<Method> getMethods()
    {
        return this.methods;
    }

    /**
     * 
     * @return false
     */
    public boolean isConcrete()
    {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(documentation+"\n interface "+name);
        if (superInterface != null){
            str.append(" extends "+superInterface.getName());
        }
        str.append("{ \n ");
        str.append("\n Methods: ");
        for (Method method : methods){
            str.append( method.toString() +"\n");
        }
        
        return str.toString();
    }    

    public void generate(BufferedWriter writer) throws IOException{
        if (getName().equals("Directory")){
            writer.write("import java.util.ArrayList;");
            writer.newLine();
        }
        writer.write("public interface "+getName());
        if (superInterface != null ){
            writer.write(" extends " + superInterface.getName()+" ");
        }
        writer.write("{");
        writer.newLine();

        if (methods != null){
            for (Method method : this.methods){
                writer.write("  ");
                method.generate(writer);
                writer.newLine();
            }
        }
        
        writer.write("}");
        
    }
}
