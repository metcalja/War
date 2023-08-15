package JacobMetcalfe_war;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yacob
 */
public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        
        //initialize war class, deck class, players, input
        Deck deck = new Deck();
        War gameOfWar = new War();

        groupOfPlayers players = new groupOfPlayers();
        Scanner input = new Scanner(System.in);
        
        System.out.println(gameOfWar.introMessage());
        System.out.println(gameOfWar.gameplayMessage());
        System.out.println();
        
        //creates a player using the set name constructor
        System.out.println("Enter your name: ");
        Player player = new Player(input.nextLine());
        
        //creates a second player, using the randomopponent method (constructor)
        Player playerTwo = new Player(players.randomOpponent());
        
        //introduction message
        System.out.println("Hello " + player.getName() + ", your opponent is : "
                + playerTwo.getName());
        
        //used to add each player to the game (group)
        players.addPlayers(player);
        players.addPlayers(playerTwo);
        
        //checking if player is ready
        System.out.println("Ready to play ? (y/n)");
        String play = input.nextLine();
        
        //checks the play variable, strips it, if it is "y" game starts
        play = play.strip();
        if (play.equalsIgnoreCase("y")) {
            playGame(players.getAllPlayers(), deck, input, gameOfWar);
        } else {
            
            //if not, loops until they're ready to play
            while (!play.equalsIgnoreCase("y")) {
                System.out.println("Ready to play? (y/n)");
                play = input.nextLine();
                if (play.equalsIgnoreCase("y")) {
                    playGame(players.getAllPlayers(), deck, input, gameOfWar);
                    break; // Exit the loop if user is ready to play
                }
            }
        }

    }
    //gameplay method
    public static void playGame(ArrayList<Player> players, Deck deck, Scanner
            input, War gameOfWar) throws InterruptedException {
        
        // Shuffle the deck
        System.out.println("Shuffling deck...");
        deck.shuffle(); 
        
        System.out.println("Dealing cards...");
        
        //this method deals (using the array of players)
        gameOfWar.dealHands(players, deck);
        
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);
        
        do {
            
            //flip card, then give a second long delay
            gameOfWar.flipCards(players, deck, input);
            Thread.sleep(1000);
            System.out.println("Ready for next flip? (y/n/q)");
            String response = input.nextLine();
            
            // Stop the game loop if player wants to quit
            if (response.equalsIgnoreCase("q")) {
                break; 
                
                // Continue with the next flip
            } else if (response.equalsIgnoreCase("y")) {
                continue; 
            } else if (response.equalsIgnoreCase("n")) {
                
                //while loop that runs until player says y (yes)
                while (response.equalsIgnoreCase("n")) {
                    System.out.println("Ready to play? (y/n)");
                    response = input.nextLine();
                }
            }
            
            //loop continues until either players hand is equal to or above 0
        } while (playerOne.getHand().getHandSize() >= 0 || 
                playerTwo.getHand().getHandSize() >= 0);

        //win / loss
        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.println("Congrats!!! " + playerOne.getName() + " wins!");
        } else if (playerTwo.getScore() > playerOne.getScore()) {
            System.out.println("Oh no! " + playerTwo.getName() + " won!");
        } 
        System.out.println(gameOfWar.exitMessage(playerOne.getName()));
    }
}

