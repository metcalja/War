/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JacobMetcalfe_war;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author yacob
 */
public class groupOfPlayers {
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

    private ArrayList<Player> players = new ArrayList<>();
    private Random rand = new Random();

    public groupOfPlayers() {
        
    }

    public String randomOpponent() {
        int oppIndex = rand.nextInt(Opponents.values().length);
        return Opponents.values()[oppIndex].toString();
    }
    
    public void addPlayers(Player player) {
        players.add(player);
    }
    
    public int numOfPlayers() {
        return players.size();
    }
    
    public ArrayList<Player> getAllPlayers() {
        return players;
    } 
    

}
