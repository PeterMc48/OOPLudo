import javax.swing.*;
import java.awt.*;

public class Token {
    public Token() {
        Players[] blueToken = new Players[3];
        Players[] redToken = new Players[3];
        Players[] greenToken = new Players[3];
        Players[] pinkToken = new Players[3];

        getBlueTokens(blueToken);
        getRedTokens(redToken);
        getGreenTokens(greenToken);
        getPinkTokens(pinkToken);


    }
    public static Players getBlueTokens(Players[] blue){
        int i=0;
        for(i = 0;i<blue.length;i++)
        {
            blue[i].setBackground(Color.BLUE);
        }
        return blue[i];

    }
    public static Players getRedTokens(Players[] red){
        int i=0;
        for(i = 0;i<red.length;i++)
        {
            red[i].setBackground(Color.RED);
        }
        return red[i];

    }
    public static Players getGreenTokens(Players[] green){
        int i=0;
        for(i = 0;i<green.length;i++)
        {
            green[i].setBackground(Color.GREEN);
        }
        return green[i];

    }
    public static Players getPinkTokens(Players[] pink){
        int i=0;
        for(i = 0;i<pink.length;i++)
        {
            pink[i].setBackground(Color.PINK);
        }
        return pink[i];

    }
}
