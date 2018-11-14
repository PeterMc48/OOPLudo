import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LudoBoard extends JFrame implements ActionListener {
    //no argument constractor
    /**
     * Array of players to play the game
     */
    Player[] players;
    boolean[] selected = {false, false, false, false};
    //no argument constractor
    public LudoBoard() {

        //JFrame attributes
        setSize(1000, 1000);
        setTitle("Ludo");
        setLocation(500, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //JPanel object to go on top of the JFrame
        JPanel gamepanel = new JPanel(new GridLayout(11, 11));
        //gamepanel.setLayout(new FlowLayout());
        add(gamepanel);
        //Game grid made of a 2d array of JLabels
        JPanel gameSquares[][] = new JPanel[11][11];

        for (int row = 0; row < gameSquares.length; row++) {
            for (int col = 0; col < gameSquares.length; col++) {
                //boarder around each label
                gameSquares[row][col] = new JPanel();
                gameSquares[row][col].setBorder(new LineBorder(Color.BLACK));
                gameSquares[row][col].setOpaque(true);
                gamepanel.add(gameSquares[row][col]);
            }
        }
        //Home space
        //blue
        for (int i = 0; i < 3; i++) {
            gameSquares[i][0].setBackground(Color.BLUE);
        }
        for (int j = 0; j < 3; j++) {
            gameSquares[0][j].setBackground(Color.BLUE);

        }
        //red
        for (int i = 0; i < 3; i++) {

            gameSquares[i][10].setBackground(Color.RED);
        }
        for (int j = 8; j < 11; j++) {

            gameSquares[0][j].setBackground(Color.RED);
        }
        //Yellow
        for (int i = 8; i < 11; i++) {
            gameSquares[i][0].setBackground(Color.YELLOW);
        }
        for (int j = 0; j < 3; j++) {

            gameSquares[10][j].setBackground(Color.YELLOW);

        }
        //Green
        for (int i = 8; i < 11; i++) {
            gameSquares[i][10].setBackground(Color.GREEN);
        }
        for (int j = 8; j < 11; j++) {
            gameSquares[10][j].setBackground(Color.GREEN);

        }
        //path around the board
        for (int x = 3; x < 8; x++) {
            gameSquares[x][0].setBackground(Color.white);
        }
        for (int y = 0; y < 4; y++) {
            gameSquares[3][y].setBackground(Color.white);
        }
        for (int x = 0; x < 4; x++) {

            gameSquares[x][3].setBackground(Color.white);

        }
        for (int y = 3; y < 8; y++) {

            gameSquares[0][y].setBackground(Color.white);

        }
        for (int x = 0; x < 4; x++) {

            gameSquares[x][7].setBackground(Color.white);

        }
        for (int y = 7; y < 11; y++) {

            gameSquares[3][y].setBackground(Color.white);

        }
        for (int x = 3; x < 8; x++) {

            gameSquares[x][10].setBackground(Color.white);

        }
        for (int y = 7; y < 11; y++) {

            gameSquares[7][y].setBackground(Color.white);

        }
        for (int x = 7; x < 11; x++) {

            gameSquares[x][7].setBackground(Color.white);

        }
        for (int y = 3; y < 7; y++) {

            gameSquares[10][y].setBackground(Color.white);

        }
        for (int x = 7; x < 11; x++) {

            gameSquares[x][3].setBackground(Color.white);

        }
        for (int y = 0; y < 4; y++) {

            gameSquares[7][y].setBackground(Color.white);

        }
        //path home for blue
        for (int y = 1; y < 5; y++) {

            gameSquares[5][y].setBackground(Color.BLUE);

        }
        //path home for red
        for (int x = 1; x < 5; x++) {

            gameSquares[x][5].setBackground(Color.RED);

        }
        //path home for green
        for (int y = 6; y < 10; y++) {

            gameSquares[5][y].setBackground(Color.GREEN);

        }
        //path home for Yellow
        for (int x = 6; x < 10; x++) {

            gameSquares[x][5].setBackground(Color.YELLOW);

        }

        //Roll Dice Button
        JButton rollDice = new JButton("Roll Dice");
        gameSquares[5][5].add(rollDice);
        rollDice.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Adding tokens to board
        //blue tokens
        ImageIcon blueimage = new ImageIcon(getClass().getResource("blueIcon.png"));//https://www.kisspng.com/free/brik.html
        JButton blueToken1 = new JButton();
        blueToken1.setIcon(blueimage);
        blueToken1.addActionListener(this);
        blueToken1.setVisible(false);
        gameSquares[1][2].add(blueToken1);
        JButton blueToken2 = new JButton();
        blueToken2.setIcon(blueimage);
        blueToken2.addActionListener(this);
        blueToken2.setVisible(false);
        gameSquares[1][1].add(blueToken2);
        JButton blueToken3 = new JButton();
        blueToken3.setIcon(blueimage);
        blueToken3.addActionListener(this);
        blueToken3.setVisible(false);
        gameSquares[2][1].add(blueToken3);
        JButton blueToken4 = new JButton();
        blueToken4.setIcon(blueimage);
        blueToken4.addActionListener(this);
        blueToken4.setVisible(false);
        gameSquares[2][2].add(blueToken4);
        //red tokens
        ImageIcon redimage = new ImageIcon(getClass().getResource("redIcon.png"));//https://www.kisspng.com/free/brik.html
        JButton redToken1 = new JButton();
        redToken1.setIcon(redimage);
        redToken1.setVisible(false);
        gameSquares[2][9].add(redToken1);
        JButton redToken2 = new JButton();
        redToken2.setIcon(redimage);
        redToken2.setVisible(false);
        gameSquares[1][9].add(redToken2);
        JButton redToken3 = new JButton();
        redToken3.setIcon(redimage);
        redToken3.setVisible(false);
        gameSquares[1][8].add(redToken3);
        JButton redToken4 = new JButton();
        redToken4.setIcon(redimage);
        redToken4.setVisible(false);
        gameSquares[2][8].add(redToken4);
        //green tokens
        ImageIcon greenimage = new ImageIcon(getClass().getResource("greenIcon.png"));//https://www.kisspng.com/free/brik.html
        JButton greenToken1 = new JButton();
        greenToken1.setIcon(greenimage);
        greenToken1.setVisible(false);
        gameSquares[8][8].add(greenToken1);
        JButton greenToken2 = new JButton();
        greenToken2.setIcon(greenimage);
        greenToken2.setVisible(false);
        gameSquares[8][9].add(greenToken2);
        JButton greenToken3 = new JButton();
        greenToken3.setIcon(greenimage);
        greenToken3.setVisible(false);
        gameSquares[9][8].add(greenToken3);
        JButton greenToken4 = new JButton();
        greenToken4.setIcon(greenimage);
        greenToken4.setVisible(false);
        gameSquares[9][9].add(greenToken4);
        //yellow token
        ImageIcon yellowimage = new ImageIcon(getClass().getResource("yellowIcon.png"));//https://www.iconspng.com/image/118736/ludo-piece-mustard-yellow
        JButton yellowToken1 = new JButton();
        yellowToken1.setIcon(yellowimage);
        yellowToken1.setVisible(false);
        gameSquares[9][1].add(yellowToken1);
        JButton yellowToken2 = new JButton();
        yellowToken2.setIcon(yellowimage);
        yellowToken2.setVisible(false);
        gameSquares[9][2].add(yellowToken2);
        JButton yellowToken3 = new JButton();
        yellowToken3.setIcon(yellowimage);
        yellowToken3.setVisible(false);
        gameSquares[8][1].add(yellowToken3);
        JButton yellowToken4 = new JButton();
        yellowToken4.setIcon(yellowimage);
        yellowToken4.setVisible(false);
        gameSquares[8][2].add(yellowToken4);


        //Blue starting point
        JLabel blueStartingPoint = new JLabel();
        blueStartingPoint.setText("Start");
        blueStartingPoint.setFont(new Font("MONOSPACED", Font.ITALIC, 15));
        blueStartingPoint.setForeground(Color.BLUE);
        gameSquares[4][0].add(blueStartingPoint);

        //Red starting point
        JLabel redStartingPoint = new JLabel();
        redStartingPoint.setText("Start");
        redStartingPoint.setFont(new Font("MONOSPACED", Font.ITALIC, 15));
        redStartingPoint.setForeground(Color.RED);
        gameSquares[0][6].add(redStartingPoint);
        //Green starting point
        JLabel greenStartingPoint = new JLabel();
        greenStartingPoint.setText("Start");
        greenStartingPoint.setFont(new Font("MONOSPACED", Font.ITALIC, 15));
        greenStartingPoint.setForeground(Color.green);
        gameSquares[6][10].add(greenStartingPoint);

        //Yellow starting point
        JLabel yellowStartingPoint = new JLabel();
        yellowStartingPoint.setText("Start");
        yellowStartingPoint.setFont(new Font("MONOSPACED", Font.ITALIC, 15));
        yellowStartingPoint.setForeground(Color.yellow);
        gameSquares[10][4].add(yellowStartingPoint);


        PlayerMenu();


    }

    public void createLookUp() {
        Position pos[] = {
                new Position(0, 4), new Position(0, 3), new Position(1, 3), new Position(2, 3),
                new Position(3, 3), new Position(3, 2), new Position(3, 1), new Position(3, 0),
                new Position(4, 0), new Position(5, 0), new Position(6, 0), new Position(7, 0),
                new Position(7, 1), new Position(7, 2), new Position(7, 3), new Position(8, 3),
                new Position(9, 3), new Position(10, 3), new Position(10, 4), new Position(10, 5),
                new Position(10, 6), new Position(10, 7), new Position(9, 7), new Position(8, 7),
                new Position(7, 7), new Position(7, 8), new Position(7, 9), new Position(7, 10),
                new Position(6, 10), new Position(5, 10), new Position(4, 10), new Position(3, 10),
                new Position(3, 9), new Position(3, 8), new Position(3, 7), new Position(2, 7),
                new Position(1, 7), new Position(0, 7), new Position(0, 6), new Position(0, 5)


        };


        // Position pos[] = {0,0,1,2,3,3,3,3,4,5,6,7,7,7,7,8,9,10,
        //       10,10,10,10,9,8,7,7,7,7,6,5,4,3,3,3,3,2,1,0,0,0};
        //int posY[] = {4,3,3,3,3,2,1,0,0,0,0,0,1,2,3,3,3,3,4,5,6,7,7,7,7,
        //      8,9,10,10,10,10,10,9,8,7,7,7,7,6,5};
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Player players = new Player();
        if (e.getActionCommand().equals("Roll Dice")) {

            players.rolldice();
        }
        if (e.getActionCommand().equals("blueIcon.png")) {

        }
    }
    //get the amount of players and there names and colours
    public void PlayerMenu() {


        int index =0;

        String name = "";
        String colour = "";

        int numOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("How many players: "));
        while (numOfPlayers < 2 || numOfPlayers > 4) {
            numOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Unable to play the game with that amount of players!! please have 2,3 or 4 players"));
        }
        players = new Player[numOfPlayers];

        for (int i = 0; i < players.length; i++) {
            name = JOptionPane.showInputDialog("Enter name");
            colour = JOptionPane.showInputDialog("Choose colour");

            if(colour.toUpperCase().equals("blue"))
            {
                index = 0;
            }
            else if(colour.toUpperCase().equals("red"))
            {
                index = 1;
            }
            else if(colour.toUpperCase().equals("green"))
            {
                index = 2;
            }
            else if(colour.toUpperCase().equals("yellow"))
            {
                index = 3;
            }

            while (selected[index]) {
                colour = JOptionPane.showInputDialog("Already taken!! Please choice another");
                if(colour.equals("blue"))
                {
                    index = 0;
                }
                else if(colour.toUpperCase().equals("red"))
                {
                    index = 1;
                }
                else if(colour.toUpperCase().equals("green"))
                {
                    index = 2;
                }
                else if(colour.toUpperCase().equals("yellow"))
                {
                    index = 3;
                }
            }
            selected[index] = true;

        }

    }
}

