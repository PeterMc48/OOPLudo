import javax.swing.*;
import java.awt.*;

public class Ludo{
    public static void main(String[] args) {
        Board b = new Board();
        b.setVisible(true);
        getPlayersname();

    }
    public static void getPlayersname()
    {
        int players = Integer.parseInt(JOptionPane.showInputDialog("How many Players"));

        Players[] player = new Players[players];
        //getting players
        for(int i =0;i<player.length;i++)
        {
            String name = JOptionPane.showInputDialog("What is your Name:");
            String colour = JOptionPane.showInputDialog("What colour would you like to be:");
            if(colour.equals("Blue")) {

            }
            if(colour.equals("Red"))
            {

            }
            if(colour.equals("Green"))
            {

            }
            if(colour.equals("pink"))
            {

            }

        }



    }
}
