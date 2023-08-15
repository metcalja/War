package JacobMetcalfe_war;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yacob
 */
public class War {
    public void flipCards(ArrayList<Player> players, Deck deck, Scanner
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
            int firstCard = 1;
            //first hidden card
            Card playerOneSecondCard = playerOne.getHand().getCards().get(firstCard);
            Card playerTwoSecondCard = playerTwo.getHand().getCards().get(firstCard);

            int secondCard = 2;
            //flipped card after
            Card playerOneThirdCard = playerOne.getHand().getCards().get(secondCard);
            Card playerTwoThirdCard = playerTwo.getHand().getCards().get(secondCard);
            //TIE
            System.out.println("WAR!!!!!");
            System.out.println(playerOne.getName() + "'s card is a: " + 
                playerOneThirdCard);
            System.out.println(playerTwo.getName() + "'s card is a: " + 
                playerTwoThirdCard);

            int tieBreakComparison = compareCards(playerOneThirdCard,
                playerTwoThirdCard);
            do {
                

                if (tieBreakComparison == 0) {
                    // Player Two wins the tie-breaker
                    //add p1 cards to player two's hand
                    
                    playerTwo.addToHand(playerOneCard);
                    playerTwo.addToHand(playerOneSecondCard);  
                    playerTwo.addToHand(playerOneThirdCard);
                    
                    System.out.println(playerTwo.getName() + ", won this flip.");
                    //remove losers card from their hand
                    playerOne.getHand().removeCard(playerOneCard);
                    playerOne.getHand().removeCard(playerOneSecondCard);
                    playerOne.getHand().removeCard(playerOneThirdCard);
                    
                    //remove winners cards so they can be moved
                    playerTwo.getHand().removeCard(playerTwoCard);
                    playerTwo.getHand().removeCard(playerTwoSecondCard);
                    playerTwo.getHand().removeCard(playerTwoThirdCard);
                    //move winners cards to back of hand
                    playerTwo.moveBackOfHand(playerTwoCard);
                    playerTwo.moveBackOfHand(playerTwoSecondCard);
                    playerTwo.moveBackOfHand(playerTwoThirdCard);
                    
                } else if (tieBreakComparison == 1) {
                    //player one wins
                    //add p2 cards to player one's hand
                    playerOne.addToHand(playerTwoCard);
                    playerOne.addToHand(playerTwoSecondCard);
                    playerOne.addToHand(playerTwoThirdCard);
                    
                    System.out.println(playerOne.getName() + ", won this flip.");
                    //remove losers card from their hand
                    playerTwo.getHand().removeCard(playerTwoCard);
                    playerTwo.getHand().removeCard(playerTwoSecondCard);
                    playerTwo.getHand().removeCard(playerTwoThirdCard);
                    //remove winners cards so they can be moved
                    playerOne.getHand().removeCard(playerOneCard);
                    playerOne.getHand().removeCard(playerOneSecondCard);
                    playerOne.getHand().removeCard(playerOneThirdCard);
                    //move winners cards to back of hand
                    playerOne.moveBackOfHand(playerOneCard);
                    playerOne.moveBackOfHand(playerOneSecondCard);
                    playerOne.moveBackOfHand(playerTwoThirdCard);
                }
            } while(playerOneThirdCard.getValue().
                    equals(playerTwoThirdCard.getValue()));
            firstCard++;
            secondCard++;
        }
            
        System.out.println(playerOne.getName() + "'s card count: " + playerOne.
                getScore() + " | " + playerTwo.getName() + "'s card count: " + 
                    playerTwo.getScore());
        System.out.println();
        
        
    }
    
    public int compareCards(Card cardOne, Card cardTwo) {
        System.out.println("Comparing " + cardOne + ", with " + cardTwo);

        if (cardOne.getValue().ordinal() > cardTwo.getValue().ordinal()) {
            return 1; // 1 is player one
        } else if (cardTwo.getValue().ordinal() > cardOne.getValue().ordinal()) {
            return 0; // 0 is player 2
        } else {
            return 3; // 3 is tie
        }
    }
    
    public void dealHands(ArrayList<Player> players, Deck deck) {
        int cardsPerPlayer = deck.getDeckSize() / 2;

        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                Card drawnCard = deck.dealCard();
                player.getHand().addCard(drawnCard); 
                // Add the card to the player's hand
            }
        }
    }
    
}
