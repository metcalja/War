/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    final int deckSize = 52;
    private int numOfDecks = 1;
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
    
    private void createDeck() {
        int valueVal = 1;
        int suitVal = 0;
        for (int i = 0; i < numOfDecks * deckSize; i++) {
            deck.add(new Card(Card.Values.values()[valueVal], Card.Suits.values()[suitVal]));
            valueVal++;
            
            if (valueVal == 13) {
                valueVal = 1;
                suitVal++;
                if (suitVal == 4) {
                    suitVal = 0;
                }
            }
        }
    }
    public void shuffle() {
        Card[] deckArr = new Card[numOfDecks * deckSize];
        deck.toArray(deckArr);
        List<Card> cardList = Arrays.asList(deckArr);
        Collections.shuffle(cardList);
        this.deck = new ArrayList<>(cardList);
    }
    
    public Card dealCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            System.out.println("No cards left in the deck. Game over.");
            return deck.remove(0);
        }
    }
    public int getDeckSize() {
        return deck.size();
    }

    
}
