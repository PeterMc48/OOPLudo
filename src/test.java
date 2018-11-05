import javax.swing.*;
import java.awt.*;

public class test  extends JFrame {
    test()
    {

        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton button = new JButton("roll dice");
        JLabel label = new JLabel("roll dice");
        Container container = getContentPane();
        ImageIcon image = new ImageIcon(getClass().getResource("blueIcon.png"));
        button.setIcon(image);
        label.setIcon(image);
        container.add(button);
       container.add(label);




    }

    public static void main(String[] args) {
        test t = new test();
        t.setVisible(true);
    }
}
