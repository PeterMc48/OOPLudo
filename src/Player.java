

import javax.swing.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Arrays;



public class Player extends Person{
    private boolean winner;
    private int wins;
    private Token[] tokens;

    public boolean isWinner() {
        return winner;
    }
    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {

        this.wins = wins;
    }
    public Player()
    {
        Player player1;
        setWinner(false);
        setWins(0);
        setName("unknown");
    }
    /*JB Code Added
     *A 4-arg constructor to create a Player*/
    public Player(String name,boolean winner,int wins, Token[] tokens)
    {
        super(name);
        setWinner(winner);
        setWins(wins);
        setTokens(tokens);
    }
    /*JB Code Added
     *A mutator for the tokens attribute*/
    public void setTokens(Token[] tokens)
    {
        this.tokens = tokens;
    }

    /*JB Code Added
     *An accessor for the tokens attribute*/
    public Token[] getTokens()

    {

        return tokens;

    }
    public void setToken(Token t)
    {
        setToken(t);
    }
    //JB Code Added -  toString() for Player addded so that you can test out that the link has been made between the Player and Token classes
    //at the moment it only inherits the one from Person, which just displays the Players name
    public String toString()
    {
        return super.toString() + " Winner: " + isWinner() + " Wins: " + getWins() + "\n\nTokens: " + Arrays.toString(getTokens());
    }


    public int rolldice() {
        int roll = (int)((Math.random() * 6)+1);
        JOptionPane.showMessageDialog(null,getName() + " rolled a " + roll);
        return roll;
    }
}

