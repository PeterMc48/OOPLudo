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

        for(int i =0;i<player.length;i++)
        {
            String name = JOptionPane.showInputDialog("What is your Name:");
            String colour = JOptionPane.showInputDialog("What colour would you like to be:");
            if(colour.equals("red"))
            {
                Token[] redToken = new Token[3];
                for(int j = 0;j<3;j++)
                {
                    redToken[j] = new Token();

                }
            }
        }



    }
}
