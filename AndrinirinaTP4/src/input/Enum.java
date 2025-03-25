package input;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Enum extends Class{

    private final String values;
    public Enum(String name, String documentation, String values, List<Attribute> attributes, List<Method> methods){
        super(name, documentation,null, attributes, methods);
        this.values = values;
    }

    @Override
    public boolean isConcrete(){
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getDocumentation()+"\n Enum "+getName());
        str.append("{ \n Values"+values);
        str.append("\n Attributes: ");
        if (getAttributes() != null){
            for (Attribute attribute: getAttributes()){
                str.append(attribute.toString());
            }
        }
        
        if (getMethods() != null){
            str.append("\n Methods: ");
            for (Method method :getMethods()){
                str.append( method.toString() +"\n");
            }
            
        }
        
        return str.toString();
    }    

    public void generate(BufferedWriter writer) throws IOException{

        writer.write("public enum "+getName()+"{");
        writer.newLine();
        writer.write(values);
        writer.newLine();
        if (getAttributes() != null){
            for (Attribute attribute: getAttributes()){
                writer.write("  ");
                attribute.generate(writer);
                writer.newLine();
            }
        }
        if (getMethods() != null){   
            for (Method method : getMethods()){
                writer.write("  ");
                method.generate(writer);
                writer.newLine();
            }
        }
        writer.write("}");
        
    }
    
}
