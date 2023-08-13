/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JacobMetcalfe_war;

import java.util.ArrayList;

/**
 *
 * @author yacob
 */
public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private Deck deck;
    
    public Hand(Deck deck) {
        this.deck = deck;
        addCard(deck.dealCard());
        addCard(deck.dealCard());
    }

    public Hand() {
    }

    public void addCard(Card card) {
        cards.add(card);
    }
    public void removeCard(Card card) {
        cards.remove(card);
    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public int getHandSize() {
        return cards.size();
    }
    
    
}
