/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JacobMetcalfe_war;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yacob
 */
public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();

        groupOfPlayers players = new groupOfPlayers();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        Player player = new Player(input.nextLine());

        Player playerTwo = new Player(players.randomOpponent());

        System.out.println("Hello " + player.getName() + ", your opponent is : "
                + playerTwo.getName());

        players.addPlayers(player);
        players.addPlayers(playerTwo);

        System.out.println("Ready to play ? (y/n)");
        String play = input.nextLine();
        if (play.equalsIgnoreCase("y")) {
            playGame(players.getAllPlayers(), deck, input);
        } else {
            while (play.equalsIgnoreCase("n")) {
                System.out.println("Ready to play ? (y/n)");
                play = input.nextLine();
            }
        }
    }
    
    public static void dealHands(ArrayList<Player> players, Deck deck) {
        int cardsPerPlayer = deck.getDeckSize() / 2;

        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                Card drawnCard = deck.dealCard();
                player.getHand().addCard(drawnCard); // Add the card to the player's hand
            }
        }
    }

    
    public static void playGame(ArrayList<Player> players, Deck deck, Scanner
            input) throws InterruptedException {
        System.out.println("Shuffling deck...");
        deck.shuffle(); // Shuffle the deck

        System.out.println("Dealing cards...");
        dealHands(players, deck);
        
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);
        
        do {
            flipCards(players, deck, input);
            Thread.sleep(2000); 
        } while(playerOne.getHand().getHandSize() > 0);
        
        if (playerOne.getScore() > playerTwo.getScore()) {
            System.out.println("Congrats!!! " + playerOne.getName() + " wins!");
        } else if (playerTwo.getScore() > playerOne.getScore()) {
            System.out.println("Oh no! " + playerTwo.getName() + " won!");
        }
        
        
        
}

    
    public static void flipCards(ArrayList<Player> players, Deck deck, Scanner
            input) {
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);
        
        Card playerOneCard = playerOne.getHand().getCards().get(0);
        Card playerTwoCard = playerTwo.getHand().getCards().get(0);
        
        System.out.println(playerOne.getName() + "'s card is a: " + 
                playerOneCard);
        System.out.println(playerTwo.getName() + "'s card is a: " + 
                playerTwoCard);
        
        int comparison = compareCards(playerOneCard, playerTwoCard);
        
        if (comparison == 1) {
            //p1 wins
            playerOne.addToWinnings(playerOneCard);
            playerOne.addToWinnings(playerTwoCard);
            playerOne.addPoint(2);
            System.out.println(playerOne.getName() + ", won this flip.");
            playerOne.getHand().removeCard(playerOneCard);
            playerTwo.getHand().removeCard(playerTwoCard);
            
        } else if (comparison == 0) {
            //p2 won flip
            playerTwo.addToWinnings(playerOneCard);
            playerTwo.addToWinnings(playerTwoCard);
            playerTwo.addPoint(2);
            System.out.println(playerTwo.getName() + ", won this flip.");
            playerOne.getHand().removeCard(playerOneCard);
            playerTwo.getHand().removeCard(playerTwoCard);
            
        } else {
            //TIE
            System.out.println("Tie breaker...");
            Card playerOneCardTwo = playerOne.getHand().getCards().get(1);
            Card playerTwoCardTwo = playerTwo.getHand().getCards().get(1);

            
            System.out.println(playerOne.getName() + "'s card is a: " + 
                playerOneCardTwo);
            System.out.println(playerTwo.getName() + "'s card is a: " + 
                playerTwoCardTwo);
            
            int tieBreakComparison = compareCards(playerOneCardTwo,
                playerTwoCardTwo);
        
        if (tieBreakComparison == 0) {
            // Player Two wins the tie-breaker
            playerTwo.addToWinnings(playerOneCard);
            playerTwo.addToWinnings(playerTwoCard);
            playerTwo.addToWinnings(playerOneCardTwo);
            playerTwo.addToWinnings(playerTwoCardTwo);
            playerTwo.addPoint(4);
            System.out.println(playerTwo.getName() + ", won this flip.");
            playerOne.getHand().removeCard(playerOneCard);
            playerOne.getHand().removeCard(playerOneCardTwo);
            playerTwo.getHand().removeCard(playerTwoCard);
            playerTwo.getHand().removeCard(playerTwoCardTwo);
            
        } else if (tieBreakComparison == 1) {
            // Player One wins the tie-breaker
            playerOne.addToWinnings(playerOneCard);
            playerOne.addToWinnings(playerTwoCard);
            playerOne.addToWinnings(playerOneCardTwo);
            playerOne.addToWinnings(playerTwoCardTwo);
            playerOne.addPoint(4);
            System.out.println(playerOne.getName() + ", won this flip.");
            playerOne.getHand().removeCard(playerOneCard);
            playerOne.getHand().removeCard(playerOneCardTwo);
            playerTwo.getHand().removeCard(playerTwoCard);
            playerTwo.getHand().removeCard(playerTwoCardTwo);
        } else {
            System.out.println("Tie even after tie breaker, no points.");
        }
    }
        System.out.println(playerOne.getName() + "'s score: " + playerOne.
                getScore() + " | " + playerTwo.getName() + "'s score: " + 
                    playerTwo.getScore());
        
        
}
    public static int compareCards(Card cardOne, Card cardTwo) {
        System.out.println("Comparing " + cardOne + " (" + cardOne.getValue().
                ordinal() + ") with " + cardTwo + " (" + cardTwo.getValue()
                        .ordinal() + ")");

        if (cardOne.getValue().ordinal() > cardTwo.getValue().ordinal()) {
            return 1; // 1 is player one
        } else if (cardTwo.getValue().ordinal() > cardOne.getValue().ordinal()) {
            return 0; // 0 is player 2
        } else {
            return 3; // 3 is tie
        }
    }


}
