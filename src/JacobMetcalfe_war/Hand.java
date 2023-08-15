package JacobMetcalfe_war;

import java.util.ArrayList;

/**
 *
 * @author yacob
 */
public class Hand {
    //initializing array of cards (for hand) and deck
    private ArrayList<Card> cards = new ArrayList<>();
    private Deck deck;
    //constructor used for making a hand, adds (deals 2 hands)
    public Hand(Deck deck) {
        this.deck = deck;
        addCard(deck.dealCard());
        addCard(deck.dealCard());
    }

    public Hand() {
    }
    //used to add cards to hand (each specific card, used with arrays)
    public void addCard(Card card) {
        cards.add(card);
    }
    //used to remove cards from hands (each specific card, used with arrays)
    public void removeCard(Card card) {
        cards.remove(card);
    }
    //used to get arraylist of cards (cards in hands)
    public ArrayList<Card> getCards() {
        return cards;
    }
    //integer used to see the players hand size through the game
    public int getHandSize() {
        return cards.size();
    }
    
    
    
}
