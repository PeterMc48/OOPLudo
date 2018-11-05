import javafx.scene.control.Cell;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Board extends JFrame{

 public Board() {
     setTitle("Ludo");
     setSize(1000, 1000);
     setLocation(500, 20);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     Container pane = getContentPane();
     pane.setLayout(new FlowLayout());

     JPanel panel = new JPanel();
     JLabel label = new JLabel();

     panel.setLayout(new GridLayout(11, 11));
     //**2d array to go on the grid*/
     JLabel gridlayout[][] = new JLabel[11][11];
    //panel.add(gridlayout);
     for (int row = 0; row < gridlayout.length; row++) {
         for (int col = 0; col < gridlayout.length; col++) {
             gridlayout[row][col] = new JLabel();
             gridlayout[row][col].setBorder(new LineBorder(Color.BLACK));
             gridlayout[row][col].setOpaque(true);

             panel.add(gridlayout[row][col]);


         }
     }
     //Home space
     //blue
     for (int i = 0; i < 3; i++) {
         gridlayout[i][0].setBackground(Color.BLUE);
     }
     for (int j = 0; j < 3; j++) {
         gridlayout[0][j].setBackground(Color.BLUE);

     }
     //red
     for (int i = 0; i < 3; i++) {

             gridlayout[i][10].setBackground(Color.RED);
     }
     for (int j = 8; j < 11; j++) {

         gridlayout[0][j].setBackground(Color.RED);
     }
     //Pink
     for (int i = 8; i < 11; i++) {
         gridlayout[i][0].setBackground(Color.PINK);
     }
     for (int j = 0; j < 3; j++) {

         gridlayout[10][j].setBackground(Color.PINK);

         }
     //Green
     for (int i = 8; i < 11; i++) {
         gridlayout[i][10].setBackground(Color.GREEN);
     }
         for (int j = 8; j < 11; j++) {
             gridlayout[10][j].setBackground(Color.GREEN);

         }

     //path around board
     for (int x = 3; x < 8; x++) {

         gridlayout[x][0].setBackground(Color.ORANGE);

     }
     for (int y = 0; y < 4; y++) {

         gridlayout[3][y].setBackground(Color.ORANGE);

     }
     for (int x = 0; x < 4; x++) {

         gridlayout[x][3].setBackground(Color.ORANGE);

     }
     for (int y = 3; y < 8; y++) {

         gridlayout[0][y].setBackground(Color.ORANGE);

     }
     for (int x = 0; x < 4; x++) {

         gridlayout[x][7].setBackground(Color.ORANGE);

     }
     for (int y = 7; y < 11; y++) {

         gridlayout[3][y].setBackground(Color.ORANGE);

     }
     for (int x = 3; x < 8; x++) {

         gridlayout[x][10].setBackground(Color.ORANGE);

     }
     for (int y = 7; y < 11; y++) {

         gridlayout[7][y].setBackground(Color.ORANGE);

     }
     for (int x = 7; x < 11; x++) {

         gridlayout[x][7].setBackground(Color.ORANGE);

     }
     for (int y = 3; y < 7; y++) {

         gridlayout[10][y].setBackground(Color.ORANGE);

     }
     for (int x = 7; x < 11; x++) {

         gridlayout[x][3].setBackground(Color.ORANGE);

     }
     for (int y = 0; y < 4; y++) {

         gridlayout[7][y].setBackground(Color.ORANGE);

     }
     //path home for blue
     for (int y = 1; y < 5; y++) {

         gridlayout[5][y].setBackground(Color.BLUE);

     }
     //path home for red
     for (int x = 1; x < 5; x++) {

         gridlayout[x][5].setBackground(Color.RED);

     }
     //path home for green
     for (int y = 6; y < 10; y++) {

         gridlayout[5][y].setBackground(Color.GREEN);

     }
     //path home for pink
     for (int x = 6; x < 10; x++) {

         gridlayout[x][5].setBackground(Color.PINK);

     }
    //blue starting point
     gridlayout[4][0].setText("Start");
     gridlayout[4][0].setFont(new Font("Monospaced",Font.ITALIC,15));
     //red starting point
     gridlayout[0][6].setText("Start");
     gridlayout[0][6].setFont(new Font("Monospaced",Font.ITALIC,15));
     //green starting point
     gridlayout[6][10].setText("Start");
     gridlayout[6][10].setFont(new Font("Monospaced",Font.ITALIC,15));
     //pink starting point
     gridlayout[10][4].setText("Start");
     gridlayout[10][4].setFont(new Font("Monospaced",Font.ITALIC,15));


     JButton dice = new JButton("roll dice");
     //gridlayout[5][5].add(dice);
     pane.add(panel);
     pane.add(dice);
    //blue tokens

     JLabel x = new JLabel("roll dice");

     ImageIcon image = new ImageIcon(getClass().getResource("blueIcon.png"));
     x.setIcon(image);

     pane.add(x);




     ImageIcon blue = new ImageIcon(getClass().getResource("blueIcon.png"));
     JButton blueToken1 = new JButton();
     blueToken1.setIcon(blue);
     pane.add(blueToken1);


     JButton blueToken2 = new JButton();
     JButton blueToken3 = new JButton();
     JButton blueToken4 = new JButton();

     gridlayout[2][2].add(blueToken1);
     gridlayout[2][3].add(blueToken2);
     gridlayout[3][2].add(blueToken3);
     gridlayout[3][3].add(blueToken4);



     //red tokens










 }

}
