import javax.swing.*;
import java.awt.*;

public class Token {
    private String colour;

    public String getColour()
    {
        return colour;
    }
    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public Token(String colour) {
        setColour(colour);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}