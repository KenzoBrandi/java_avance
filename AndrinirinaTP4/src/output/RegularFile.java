package output;
public class RegularFile extends AbstractFile {
  private int size;
  public RegularFile(String name, int size){
       super(name);
       this.size = size;}
  public int size(){
       return size;}
}