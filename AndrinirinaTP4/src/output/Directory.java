package output;
import java.util.ArrayList;
public class Directory extends AbstractFile {
  private ArrayList<AbstractFile> children;
  public Directory(String name){
       super(name);
       this.children = new ArrayList<AbstractFile>();}
  public int size(){
       int size = 0;
       for (AbstractFile f: children){
               size += f.size();
       }
       return size;}
  public void add(AbstractFile child){
       children.add(child);}
}