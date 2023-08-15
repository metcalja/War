package JacobMetcalfe_war;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author yacob
 */
public class groupOfPlayers extends Player {
    //enum for the opponent pool
    public enum Opponents {
        BOBBY,
        JOHN,
        KEVIN,
        MELINDA,
        MICHAEL,
        MARTHA,
        DAWN,
        ALEXA,
        KATE,
        JIMBO,
        DAISY,
        BOWSER
    }
    
    //initialize arraylist and random
    private ArrayList<Player> players = new ArrayList<>();
    private Random rand = new Random();
    
    //empty constructor that can be used to make a instance
    public groupOfPlayers() {
        
    }
    
    //method used to return random opponent for each game
    public String randomOpponent() {
        int oppIndex = rand.nextInt(Opponents.values().length);
        String yourOpponent = Opponents.values()[oppIndex].toString();
        //calls capitalization method
        return capitializeOpponent(yourOpponent);
        
    }
    
    //method used to capitalize given opponent string
    public String capitializeOpponent(String opponent) {
        //turns string lowercase
        opponent = opponent.toLowerCase();
        
        //takes string makes it into character array
        char[] letters = opponent.toCharArray();
        
        //capitalizing first letter
        char firstLetter = letters[0];
        firstLetter = Character.toUpperCase(firstLetter);
        
        //replaces the first character in the array with the capital letter
        letters[0] = firstLetter;
        
        //reverts it to a string, returns it
        String yourOpponentCapitalized = new String(letters); 
        return yourOpponentCapitalized;
    }
    
    //method for adding players to the player array
    public void addPlayers(Player player) {
        players.add(player);
    }
    
    //method used to return the amount of players
    public int numOfPlayers() {
        return players.size();
    }
    
    //used to return list of all the players
    public ArrayList<Player> getAllPlayers() {
        return players;
    } 
    

}
