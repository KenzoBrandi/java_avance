import cardgame.*;

public class Test {
    private void testColor(){
        Color club = Color.CLUB;
        Color spade = Color.SPADE;
        System.out.println(club+" comparée à "+spade+" " +club.compareTo(spade));
    }
    private void testCard(){
        BasicCard card1 = new BasicCard(Color.HEART, Value.EIGHT);
        BasicCard card2 = new BasicCard(Color.HEART, Value.TEN);
        System.out.println("Carte1: "+card1);
        System.out.println("Carte1: "+card2);
        System.out.println(card1+" comparée à "+card2+" " +card1.compareTo(card2));
    }
    private void testHand(){
        Hand hand = new Hand();
        BasicCard card1 = new BasicCard(Color.HEART, Value.EIGHT);
        BasicCard card2 = new BasicCard(Color.SPADE, Value.ACE);
        hand.insert(card1);
        hand.insert(card2);
        System.out.println(hand);
        System.out.println("Après suppression de "+card2);
        hand.remove(card2);
        System.out.println(hand);
        
    }
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.testColor();
        test.testCard();
        test.testHand();
    }
}
