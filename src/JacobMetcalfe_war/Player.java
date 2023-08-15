package JacobMetcalfe_war;

/**
 *
 * @author yacob
 */
public class Player {
    //initializing attributes needed
    /*
    players need hands, winnings pile and their scores
    */
    private String name;
    private Hand hand;
    //private WinningsPile pile;
//    private int score = 0;
    
    //constructor
    public Player() {
    }
    
    //constructor (preferred) each player defines their name, gets a hand and
    //pile
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        //this.pile = new WinningsPile();
        
    }
    //setting each players name
    public void setName(String name) {
        this.name = name;
    }
    //used to see each players name
    public String getName() {
        return name;
    }
    //method used to check players score
    public int getScore() {
        return hand.getHandSize();
    }
    //method used to initialize players hand (if they don't have one)
    public Hand getHand() {
        if (hand == null) {
            hand = new Hand(); // Initialize the hand if it's null
        }
        return hand;
    }
    public void addToHand(Card card) {
        hand.addCard(card);
    }
    public void moveBackOfHand(Card card) {
        hand.getCards().add(hand.getHandSize()-1, card);
    }
    //method used to add the cards won to the winners pile
//    public void addToWinnings(Card card) {
//        pile.addCard(card);
//    }
    //method used to show players winnings, (if their pile is empty it makes one)
//    public WinningsPile getWinnings() {
//        if (pile == null) {
//            pile = new WinningsPile(); // Initialize the hand if it's null
//        }
//        return pile;
//    }
}
