import javax.swing.*;

public class Players extends JFrame {
    private String name;
    private String colour;
    protected Token tokens;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public Players(String name,String colour,Token tokens){
        setName(name);
        setColour(colour);
    }
}
