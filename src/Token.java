

import javax.swing.*;

import java.awt.*;



//JB Modified Code here - changed class so that Token inherits from JButton

//So a Token "is a" JButton, but with an additional attribute called colour

//Rest of class all written by Peter



public class Token extends JButton {


    private String colour;
    private Position pos;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

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


        return "Token Data:\n\nColour: " + getColour() + "\nJButton Data: " + super.toString(); //Modified by JB so that colour of Token gets displayed also

    }

}

