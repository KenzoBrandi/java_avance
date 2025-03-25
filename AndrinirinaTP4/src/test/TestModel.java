package test;


import java.util.ArrayList;
import java.util.List;

import input.Attribute;
import input.Class;
import input.ConcreteMethod;
import input.Constructor;
import input.Method;
import input.Parameter;

public class TestModel {
    public static void main(String[] args)
    {  
        // AbstractFile class (component)
        List<Attribute> attributes = new ArrayList<>();
        List<Method> methods = new ArrayList<>();

        // TODO: create attributes and methods
        attributes.add(new Attribute("name", "Nom du fichier", "String"));
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(new Parameter("name", "String"));
        String[] body = {
            "   this.name = name;"
        };
        methods.add(new Constructor("AbstractFile","Initialise name", parameters, body));
        methods.add(new Method("size", "Taille fihier", "int", null));

        String doc = "Class that represents a unit that stores data";
        Class component = new Class("AbstractFile", doc, null, attributes, methods); 
        System.out.println("=== Component ===============================================");
        System.out.println(component);
    
        // RegularFile class (leaf)
        attributes = new ArrayList<>();        
        methods = new ArrayList<>();

        // TODO: create attributes and methods
        attributes.add(new Attribute("size", "Taille fichier", "int"));
        parameters = new ArrayList<Parameter>();
        parameters.add(new Parameter("size", "int"));
        parameters.add(new Parameter("name", "String"));
        String[] regFileConstr = {
            "   super(name);",
            "   this.size = size;"
        };
        String[] regFileSize = {
            "   return size;"
        };
        methods.add(new Constructor("RegularFile","Initialise size", parameters,regFileConstr));
        methods.add(new ConcreteMethod("size", "Taille fihier", "int", null,regFileSize));

        doc = "Class that represents a \"normal\" file in the file system";
        Class leaf = new Class("RegularFile", doc, component, attributes, methods); 
        System.out.println("=== Leaf ====================================================");
        System.out.println(leaf);
    
        // Directory class (composite)
        attributes = new ArrayList<>();        
        methods = new ArrayList<>();
        // TODO: create attributes and methods
        parameters = new ArrayList<Parameter>();
        parameters.add(new Parameter("child", "AbstractFile"));
        List<Parameter> constrParameters = new ArrayList<Parameter>();
        constrParameters.add(new Parameter("name", "String"));
        String[] directoryConstr = {
            "   super(name);",
            "   this.children = new ArrayList<AbstractFile>();"
        };
        String[] directorySize = {
            "   int size = 0;",
            "   for (AbstractFile f: children){",
            "       size += f.size();",
            "   }",
            "   return size;"
        };
        String[] directoryAdd = {
            "   children.add(child);"
        };
        attributes.add(new Attribute("children", "Liste des fichiers ou sous-dossiers contenus", "ArrayList<AbstractFile>"));
        methods.add(new Constructor("Directory","Initialise children", constrParameters,directoryConstr));
        methods.add(new ConcreteMethod("size", "Taille répertoire","int" ,null, directorySize));
        methods.add(new ConcreteMethod("add", "Ajout de fichier ou de sous-répertoire","void" ,parameters, directoryAdd));
        doc = "Class that represents a directory in the file system";
        Class composite = new Class("Directory", doc, component, attributes, methods); 
        System.out.println("=== Composite ===============================================");
        System.out.println(composite);
    }
}
