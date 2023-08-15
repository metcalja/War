package JacobMetcalfe_war;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author yacob
 */
public class Deck {
    //setting the deck size to only ONE legal deck
    final int deckSize = 52;
    private int numOfDecks = 1;
    //initialize a arraylist of cards to create a deck of cards
    private ArrayList<Card> deck = new ArrayList<>();
    
    //allows the game to only use one deck
    public Deck() {
        this(1);
    }

    //creates one deck (constructor)
    public Deck(int numOfDecks) {
        this.numOfDecks = numOfDecks;
        createDeck();
    }
    //method for creating decks
    private void createDeck() {
        //sets value to 1 and suit to 0 initially
        int valueVal = 1;
        int suitVal = 0;
        //for loop that creates a new card (using enums that are randomized
        //and adds each card to the deck
        for (int i = 0; i < numOfDecks * deckSize; i++) {
            deck.add(new Card(Card.Values.values()[valueVal], Card.Suits.values()[suitVal]));
            valueVal++;
            //after the value hits 13 it restarts, suit = 4 it goes back to 0
            if (valueVal == 13) {
                valueVal = 1;
                suitVal++;
                if (suitVal == 4) {
                    suitVal = 0;
                }
            }
        }
    }
    //method to shuffle
    public void shuffle() {
        //make a array of cards, changes it to be a "copy" of existing deck
        Card[] deckArr = new Card[numOfDecks * deckSize];
        deck.toArray(deckArr);
        List<Card> cardList = Arrays.asList(deckArr);
        //shuffles second copy and then makes the "deck" the shuffled deck
        Collections.shuffle(cardList);
        this.deck = new ArrayList<>(cardList);
    }
    //method for dealing cards
    public Card dealCard() {
        //if the deck isn't empty, deal
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            //message explaining that the game is over
            System.out.println("No cards left in the deck. Game over.");
            return deck.remove(0);
        }
    }
    //method for showing deck size
    public int getDeckSize() {
        return deck.size();
    }

    
}
