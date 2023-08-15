package JacobMetcalfe_war;

/**
 *
 * @author yacob
 */
public class Card {
    //enum for the different available suite
    public enum Suits {
        CLUBS,
        HEARTS,
        DIAMONDS,
        SPADES
    }
    //enum for the different available values
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
    
    //attributes that reference each type of enum
    
    private Suits suit;
    private Values value;
    
    //constructor for making a Card
    Card(Values value, Suits suit) {
        this.value = value;
        this.suit = suit;
    }
    
    //used to set the value of a card
    public void setValue(Values value) {
        this.value = value;
    }
    //used to get and see what value a card is
    public Values getValue() {
        return value;
    }
    //used to set the suit of a card
    public void setSuit(Suits suit) {
        this.suit = suit;
    }
    //used to get and see the suit of a card
    public Suits getSuit() {
        return suit;
    }
    //toString used to make the "cards" look proper
    @Override
    public String toString() {
        return value + " of " + suit;
    }
    
}
