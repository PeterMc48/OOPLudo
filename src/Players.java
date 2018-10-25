import javax.swing.*;

public class Players extends JFrame {
    private String name;
    private String colour;

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
    public Players(String name,String colour){
        setName(name);
        setColour(colour);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
