package test;

import output.Directory;
import output.RegularFile;
import java.io.File;

public class TestComposite 
{
    
    public static void main(String[] args) 
    {
        String name = args.length > 0 ? args[0] : ".";
        File root = new File(name);
        if (root.isDirectory()) {
            Directory directory = makeDirectory(new File(name));
            System.out.println("Name: " + directory.getName());
            System.out.println("Size: " + directory.size() + " bytes");
        } else {
            System.out.println(name + " is not a directory");
        }
    }

    private static Directory makeDirectory(File dir)
    {
        Directory directory = new Directory(dir.getName());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                directory.add(makeDirectory(file));
            } else {
                directory.add(makeFile(file));
            }
        }
        return directory;
    }

    private static RegularFile makeFile(File file)
    {
        return new RegularFile(file.getName(), (int)file.length());
    }
}
