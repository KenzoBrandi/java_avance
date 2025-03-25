package cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implémente le jeu de bataille.
 */
public class Battle implements Game {
    private ArrayList<Card> deck;
    private Hand handOne;
    private Hand handTwo;

    /**
     * Initialise une partie de bataille avec un deck de cartes.
     *
     * @param type Type de jeu (32 ou 52 cartes).
     */
    public Battle(GameType type) {
        deck = new ArrayList<Card>();
        Value[] values = Value.values();
        Color[] colors = Color.values();
        int index;
        if (type.compareTo(GameType.CARD32) == 0) {
            index = 7;
        } else {
            index = 2;
        }
        Card card;
        while (index < values.length) {
            for (Color color : colors) {
                card = new BasicCard(color, values[index]);
                deck.add(card);
            }
            index++;
        }
        deck.add(new Joker());
        deck.add(new Joker());
        Collections.shuffle(deck);
    }

    @Override
    /**
     * Joue une partie de bataille jusqu'à ce qu'un joueur gagne.
     */
    public void play() {
        handOne = new Hand();
        handTwo = new Hand();

        /* Partage des cartes */
        while (!deck.isEmpty()) {
            handOne.insert(deck.get(0));
            deck.remove(0);
            handTwo.insert(deck.get(0));
            deck.remove(0);
        }

        int i;
        while (winner() == null) {
            System.out.println("Joueur 1: \n" +
                    "  Deck J1: " + handOne + "\n"
                    + "  Carte montrée: " + handOne.get(0));
            System.out.println("Joueur 2: \n" +
                    "  Deck J2: " + handTwo + "\n"
                    + "  Carte montrée: " + handTwo.get(0) + "\n ----------------------------");

            int comparison = handOne.get(0).compareTo(handTwo.get(0));
            if (comparison < 0) {
                handTwo.insert(handOne.get(0));
                handOne.remove(handOne.get(0));

                /* Le joueur gagnant range sa carte qu'il vient d'utiliser */
                if (handTwo.size() != 1) {
                    handTwo.insert(handTwo.get(0));
                    handTwo.remove(handTwo.get(0));
                }

            } else if (comparison == 0) {
                i = 1;
                while (comparison == 0) {
                    System.out.println("Bataille!! \n" +
                            "Joueur 1: \n" +
                            "  Deck J1: " + handOne + "\n"
                            + "  Carte montrée: " + handOne.get(i));
                    System.out.println("Joueur 2: \n" +
                            "  Deck J2: " + handTwo + "\n"
                            + "  Carte montrée: " + handTwo.get(i));
                    if (handOne.get(i) == null && handTwo.get(i) != null) {
                        comparison = -1;
                    } else if (handOne.get(i) != null && handTwo.get(i) == null) {
                        comparison = 1;
                    } else {
                        comparison = handOne.get(i).compareTo(handTwo.get(i));
                    }

                    i++;
                }
                if (comparison < 0) {
                    for (int j = 0; j < i; j++) {
                        handTwo.insert(handOne.get(0));
                        handOne.remove(handOne.get(0));
                        /* Le joueur gagnant range en fin de main la carte qu'il vient d'utiliser */
                        if (handTwo.size() != 1) {
                            handTwo.insert(handTwo.get(0));
                            handTwo.remove(handTwo.get(0));
                        }

                    }
                } else {
                    for (int j = 0; j < i; j++) {
                        handOne.insert(handTwo.get(0));
                        handTwo.remove(handTwo.get(0));
                        /* Le joueur gagnant range en fin de main la carte qu'il vient d'utiliser */
                        if (handOne.size() != 1) {
                            handOne.insert(handOne.get(0));
                            handOne.remove(handOne.get(0));
                        }

                    }
                }
            } else {
                handOne.insert(handTwo.get(0));
                handTwo.remove(handTwo.get(0));
                /* Le joueur gagnant range en fin de main la carte qu'il vient d'utiliser */
                if (handOne.size() != 1) {
                    handOne.insert(handOne.get(0));
                    handOne.remove(handOne.get(0));
                }

            }
        }
        System.out.println("Main gagnante : \n" + winner());

    }

    @Override
    /**
     * Retourne la main gagnante.
     *
     * @return La main du joueur gagnant ou {@code null} si la partie continue.
     */
    public Hand winner() {
        if (handOne.size() == 0 && handTwo.size() != 0) {
            return handTwo;
        } else if (handTwo.size() == 0 && handOne.size() != 0) {
            return handOne;
        }
        return null;
    }
}
