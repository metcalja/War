/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JacobMetcalfe_war;

/**
 *
 * @author yacob
 */
public class Player {
    private String name;
    private Hand hand;
    private WinningsPile pile;
    private int score = 0;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.pile = new WinningsPile();
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addPoint(int amount) {
        score += amount;
    }
    public Hand getHand() {
        if (hand == null) {
            hand = new Hand(); // Initialize the hand if it's null
        }
        return hand;
    }
    public void addToWinnings(Card card) {
        pile.addCard(card);
    }
    public WinningsPile getWinnings() {
        if (pile == null) {
            pile = new WinningsPile(); // Initialize the hand if it's null
        }
        return pile;
    }
}
