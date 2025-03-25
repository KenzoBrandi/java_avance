package cardgame;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    /**
     * Constructeur qui initialise la liste des cartes
     */
    public Hand(){
        cards = new ArrayList<Card>();
    }
    /**
     * @return nombre de cartes possédées
     */
    public int size(){
        return cards.size();
    }
    /**
     * Insère une carte dans la main
     * @param card carte à insérer
     */
    public void insert(Card card){
        if (card != null){
            cards.add(card);
        }
    }
    /**
     * Retire une carte de la main
     * @param card instance de la carte à retirer
     * @return la carte retirée si elle est présente, null sinon
     */
    public Card remove(Card card){
        boolean result = cards.remove(card);
        if (result){
            return card;
        }
        return null;
    }
    /**
     * Accède à une carte dans la main
     * @param position index de la carte à accéder dans la main
     * @return
     */
    public Card get(int position){
        if (position < size()){
            return cards.get(position);
        }
        return null;
    }
    /**
     * Redéfinition de la méthode toString
     * @return chaine de caractère contenant toutes les cartes de la main
     */
    public String toString(){
        String result = "";
        for (Card card : cards) {
            result += card.toString() +", ";
        }
        return result;
    }
}
