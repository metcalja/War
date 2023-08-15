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
        
        System.out.println("Shuffling deck...");
        deck.shuffle(); // Shuffle the deck
        
        System.out.println("Dealing cards...");
        //this method deals (using the array of players
        gameOfWar.dealHands(players, deck);
        
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);
        
        do {
            gameOfWar.flipCards(players, deck, input);
            Thread.sleep(1000);
            System.out.println("Ready for next flip? (y/n/q)");
            String response = input.nextLine();

            if (response.equalsIgnoreCase("q")) {
                break; // Stop the game loop if player wants to quit
            } else if (response.equalsIgnoreCase("y")) {
                continue; // Continue with the next flip
            } else if (response.equalsIgnoreCase("n")) {
                while (response.equalsIgnoreCase("n")) {
                    System.out.println("Ready to play? (y/n)");
                    response = input.nextLine();
                }
            }
        } while (playerOne.getHand().getHandSize() >= 0);

        
        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.println("Congrats!!! " + playerOne.getName() + " wins!");
        } else if (playerTwo.getScore() > playerOne.getScore()) {
            System.out.println("Oh no! " + playerTwo.getName() + " won!");
        }   
    }
}

