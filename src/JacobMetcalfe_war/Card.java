package JacobMetcalfe_war;

/**
 *
 * @author yacob
 */
public class Card {
    public enum Suits {
        CLUBS,
        HEARTS,
        DIAMONDS,
        SPADES
    }
    public enum Values {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }
    
    private Suits suit;
    private Values value;
    
    Card(Values value, Suits suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public void setValue(Values value) {
        this.value = value;
    }
    public Values getValue() {
        return value;
    }
    
    public void setSuit(Suits suit) {
        this.suit = suit;
    }
    public Suits getSuit() {
        return suit;
    }
    
    @Override
    public String toString() {
        return value + " of " + suit;
    }
    
}
