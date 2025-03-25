package output.card;
public class ColoredCard implements Card {
  private Color color;
  private Value value;
  public ColoredCard(Color color, Value value){
       this.color = color;
       this.value = value;}
  public Color getColor(){
       return this.color;}
  public Value getValue(){
       return value;}
}