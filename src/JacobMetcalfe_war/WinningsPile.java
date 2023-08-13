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
public class WinningsPile {
    private ArrayList<Card> cards = new ArrayList<>();
    private Deck deck;
    
    public void addCard(Card card) {
        cards.add(card);
    }
    public ArrayList<Card> getWinnings() {
        return cards;
    }
}
