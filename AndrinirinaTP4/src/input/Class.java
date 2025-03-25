package input;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * A class that represents a class in a class diagram
 */
public class Class implements Entity
{
    /**
     * the name of the class
     */
    private final String name;

    /**
     * the description of the class 
     */
    private final String documentation;

    /**
     * the super-class of the class (null if the class has no super-class) 
     */
    private final Class superClass;

    /**
     * the attributes of the class
     */
    private final List<Attribute> attributes;

    /**
     * the methods of the class
     */
    private final List<Method> methods;

    private final Interface superInterface;

    /**
     * Constructor
     * 
     * @param name          name of the class
     * @param documentation description of the class
     * @param superClass    super-class of the class (null if the class has no super-class)
     * @param attributes    attributes of the class
     * @param methods       methods of the class
     */
    public Class(String name, String documentation, Class superClass, List<Attribute> attributes, List<Method> methods)
    {
        this.name = name;
        this.documentation = documentation;
        this.superClass = superClass;
        this.attributes = attributes;
        this.methods = methods;
        superInterface = null;
    }

    //surcharge de constructeur avec implémentation d'une interface
    public Class(String name, String documentation, Class superClass, List<Attribute> attributes, List<Method> methods, Interface superInterface)
    {
        this.name = name;
        this.documentation = documentation;
        this.superClass = superClass;
        this.attributes = attributes;
        this.methods = methods;
        this.superInterface = superInterface;
    }
    
    @Override
    public String getName()
    {
        return this.name;
    }

    /**
     * Give the description of the class
     * 
     * @return the class description
     */
    public String getDocumentation()
    {
        return this.documentation;
    }

    /**
     * Give the super-class of the class
     * 
     * @return the class super-class of the class (may be null)
     */
    public Class getSuperClass()
    {
        return this.superClass;
    }

    /**
     * Give the attributes of the class
     * 
     * @return the class attributes
     */
    public List<Attribute> getAttributes()
    {
        return this.attributes;
    }

    /**
     * Give the methods of the class
     * 
     * @return the class methods
     */
    public List<Method> getMethods()
    {
        return this.methods;
    }

    /**
     * Check whether this class is concrete, i.e. has only concrete methods
     * 
     * @return true if this class is concrete
     */
    public boolean isConcrete()
    {
        for (Method method : this.methods) {
            if (!method.isConcrete()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(documentation+"\n Class "+name);
        if (superClass != null){
            str.append(" extends "+superClass.getName()+ "{ \n");
        }
        if (attributes != null){
            str.append(" Attributes: ");
            for (Attribute attribute: attributes){
                str.append(attribute.toString());
            }
        }
        if (methods != null){
            str.append("\n Methods: ");
            for (Method method : methods){
                str.append( method.toString() +"\n");
            }
        }
        
        
        return str.toString();
    }    

    public void generate(BufferedWriter writer) throws IOException{
        if (getName().equals("Directory")){
            writer.write("import java.util.ArrayList;");
            writer.newLine();
        }
        if (isConcrete()){
            writer.write("public class ");
        } else {
            writer.write("public abstract class ");
        }
        writer.write(getName());
        if (superClass != null ){
            writer.write(" extends " + superClass.getName()+" ");
        }
        if (superInterface != null ){
            writer.write(" implements " + superInterface.getName()+" ");
        }
        writer.write("{");
        writer.newLine();
        if (attributes != null){
            for (Attribute attribute: attributes){
                writer.write("  ");
                attribute.generate(writer);
                writer.newLine();
            }
        }
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