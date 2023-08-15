package JacobMetcalfe_war;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yacob
 */
public class War {
    //this class just holds war methods
    
    //method used for flipping cards
    public void flipCards(ArrayList<Player> players, Deck deck, Scanner
            input) {
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);
        //first card for each player
        Card playerOneCard = playerOne.getHand().getCards().get(0);
        Card playerTwoCard = playerTwo.getHand().getCards().get(0);
        //reading out users cards
        System.out.println(playerOne.getName() + "'s card is a: " + 
                playerOneCard);
        System.out.println(playerTwo.getName() + "'s card is a: " + 
                playerTwoCard);
        //used to compare their cards
        int comparison = compareCards(playerOneCard, playerTwoCard);
        //checks the value of the comparison
        if (comparison == 1) {
            //p1 wins
            //have to remove p1 card, so it can be moved
            playerOne.getHand().removeCard(playerOneCard);
            System.out.println(playerOne.getName() + ", won this flip.");
            //remove p2 card
            //add winnings to p1 hand
            playerOne.addToHand(playerTwoCard);
            playerTwo.getHand().removeCard(playerTwoCard);
            playerOne.moveBackOfHand(playerOneCard);
            
        } else if (comparison == 0) {
            //p2 won flip
            //have to remove p2 card, so it can be moved
            playerTwo.getHand().removeCard(playerTwoCard);
            
            System.out.println(playerTwo.getName() + ", won this flip.");
            //remove p1 card
            //add winnings to p2 hand
            playerTwo.addToHand(playerOneCard);
            playerOne.getHand().removeCard(playerOneCard);   
            playerTwo.moveBackOfHand(playerTwoCard);
        } else {
            //tie, player draws card (facedown) flips another, winner take all
            int firstCard = 1;
            //first hidden card (card 2)
            Card playerOneSecondCard = playerOne.getHand()
                    .getCards().get(firstCard);
            Card playerTwoSecondCard = playerTwo.getHand().
                    getCards().get(firstCard);

            int secondCard = 2;
            //flipped card after (card 3)
            Card playerOneThirdCard = playerOne.getHand()
                    .getCards().get(secondCard);
            Card playerTwoThirdCard = playerTwo.getHand()
                    .getCards().get(secondCard);
            //TIE
            System.out.println("WAR!!!!!");
            //reading out cards
            System.out.println(playerOne.getName() + "'s card is a: " + 
                playerOneThirdCard);
            System.out.println(playerTwo.getName() + "'s card is a: " + 
                playerTwoThirdCard);
            //checks tie comparison for third card
            int tieBreakComparison = compareCards(playerOneThirdCard,
                playerTwoThirdCard);
            //this do while goes until tie breaker ends
            do {
                if (tieBreakComparison == 0) {
                    // Player Two wins the tie-breaker
                    //add p1 cards to player two's hand
                    
                    //player 2 adds all player 1 cards
                    playerTwo.addToHand(playerOneCard);
                    playerTwo.addToHand(playerOneSecondCard);  
                    playerTwo.addToHand(playerOneThirdCard);
                    
                    System.out.println(playerTwo.
                            getName() + ", won this flip.");
                    
                    //remove losers card from their hand (p1)
                    playerOne.getHand().removeCard(playerOneCard);
                    playerOne.getHand().removeCard(playerOneSecondCard);
                    playerOne.getHand().removeCard(playerOneThirdCard);
                    
                    //remove winners cards so they can be moved (p2)
                    playerTwo.getHand().removeCard(playerTwoCard);
                    playerTwo.getHand().removeCard(playerTwoSecondCard);
                    playerTwo.getHand().removeCard(playerTwoThirdCard);
                    
                    //move winners cards to back of hand (p2's cards)
                    playerTwo.moveBackOfHand(playerTwoCard);
                    playerTwo.moveBackOfHand(playerTwoSecondCard);
                    playerTwo.moveBackOfHand(playerTwoThirdCard);
                    
                } else if (tieBreakComparison == 1) {
                    //player one wins
                    //add p2's cards to player one's hand
                    playerOne.addToHand(playerTwoCard);
                    playerOne.addToHand(playerTwoSecondCard);
                    playerOne.addToHand(playerTwoThirdCard);
                    
                    System.out.println(playerOne.
                            getName() + ", won this flip.");
                    
                    //remove losers card from their hand (p2)
                    playerTwo.getHand().removeCard(playerTwoCard);
                    playerTwo.getHand().removeCard(playerTwoSecondCard);
                    playerTwo.getHand().removeCard(playerTwoThirdCard);
                    
                    //remove winners cards so they can be moved (p1)
                    playerOne.getHand().removeCard(playerOneCard);
                    playerOne.getHand().removeCard(playerOneSecondCard);
                    playerOne.getHand().removeCard(playerOneThirdCard);
                    
                    //move winners cards to back of hand (p1)
                    playerOne.moveBackOfHand(playerOneCard);
                    playerOne.moveBackOfHand(playerOneSecondCard);
                    playerOne.moveBackOfHand(playerTwoThirdCard);
                    
                }//continues until cards aren't equal
            } while(playerOneThirdCard.getValue().
                    equals(playerTwoThirdCard.getValue()));
            //iterations continue
            firstCard++;
            secondCard++;
        }
        //message for showing score (cards in hand) after every round
        //higher > lower
        System.out.println(playerOne.getName() + "'s card count: " + playerOne.
                getScore() + " | " + playerTwo.getName() + "'s card count: " + 
                    playerTwo.getScore());
        //empty line for spacing
        System.out.println();
        
        
    }
    //method for comparing cards
    public int compareCards(Card cardOne, Card cardTwo) {
        System.out.println("Comparing " + cardOne + ", with " + cardTwo);
        //gets the ordinal value to compare with enumeration ranks
        if (cardOne.getValue().ordinal() > cardTwo.getValue().ordinal()) {
            return 1; // 1 is player one
        } else if (cardTwo.getValue().ordinal() > cardOne.getValue().ordinal()) {
            return 0; // 0 is player 2
        } else {
            return 3; // 3 is tie
        }
    }
    //deal hands to players
    public void dealHands(ArrayList<Player> players, Deck deck) {
        //deal half the deck to each player
        int cardsPerPlayer = deck.getDeckSize() / 2;
        //simple foreach loop to add cards
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                Card drawnCard = deck.dealCard();
                player.getHand().addCard(drawnCard); 
                // Add the card to the player's hand
            }
        }
    }
    
    public String introMessage() {
        return "Hello! Welcome to the game of War! This game was created by"
                + " Jacob Metcalfe, finished on 2023-08-15, made for "
                    + "Prof Ronak Sheth's Software Development course.";
    }
    public String gameplayMessage() {
        return "My spin on War deals half the deck (one deck for two people)"
                + "and then has each player flip a card (automated, opponent is"
                    + " the computer).\nIf there is a tie, players get a  "
                        + "card, don't flip it, then flip another card. This "
                            + "repeats until there is a winner, who takes all "
                                + "the drawn cards.\nThe game ends when one "
                                    + "player runs out of cards.";
    }
    
    public String exitMessage(String user) {
        return "Thank you for playing " + user + "! Hope you enjoyed.";
    }
    
}
