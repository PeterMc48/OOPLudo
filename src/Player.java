import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Player extends Person implements PlayersTurn{
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
    public Player(String name)
    {

    }


    @Override
    public void rolldice() {
        int roll = (int)((Math.random() * 6)+1);
        JOptionPane.showMessageDialog(null,getName() + " rolled a " + roll);



    }
    public void setToken(Token t)
    {
        setToken(t);
    }

}