import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;


public class LudoBoard extends JFrame implements ActionListener {

    Player[] players;
    Token[] blueTokens;
    Token[] redTokens;
    Token[] greenTokens;
    Token[] yellowTokens;

    /**
     * buttons to move tokens
     */
    //blue buttons

    public Token blueToken1; //JB Modified Code here - changed all tokens from JButton to Token objects
    public Token blueToken2;
    public Token blueToken3;
    public Token blueToken4;

    //red buttons

    public Token redToken1;
    public Token redToken2;
    public Token redToken3;
    public Token redToken4;

    //green buttons

    public Token greenToken1;
    public Token greenToken2;
    public Token greenToken3;
    public Token greenToken4;

    //yellow buttons

    public Token yellowToken1;
    public Token yellowToken2;
    public Token yellowToken3;
    public Token yellowToken4;

    //dice button
    public JButton rollDice;

    //game squaures
    public JPanel gameSquares[][];

    //turn over
    public boolean turnOver = false;

    //to move the index of the array for the positioning
    public int moveIndex;

    //lookup positions on the board
    public Position pos[] = {
            new Position(4, 0), new Position(3, 0), new Position(3, 1), new Position(3, 2),
            new Position(3, 3), new Position(2, 3), new Position(1, 3), new Position(0, 3),
            new Position(0, 4), new Position(0, 5), new Position(0, 6), new Position(0, 7),
            new Position(1, 7), new Position(2, 7), new Position(3, 7), new Position(3, 8),
            new Position(3, 9), new Position(3, 10), new Position(4, 10), new Position(4, 10),
            new Position(6, 10), new Position(7, 10), new Position(7, 9), new Position(7, 8),
            new Position(7, 7), new Position(8, 7), new Position(9, 7), new Position(10, 7),
            new Position(10, 6), new Position(10, 5), new Position(10, 4), new Position(10, 3),
            new Position(9, 3), new Position(8, 3), new Position(7, 3), new Position(7, 2),
            new Position(7, 1), new Position(7, 0), new Position(6, 0), new Position(5, 0)
    };
    public Position blueHome[] = {
            new Position(1, 1), new Position(1, 2), new Position(2, 1), new Position(2, 2)
    };
    public Position redHome[] = {
            new Position(1, 8), new Position(1, 9), new Position(2, 8), new Position(2, 9)
    };
    public Position greenHome[] = {
            new Position(8, 8), new Position(8, 9), new Position(9, 8), new Position(9, 9)
    };
    public Position yellowHome[] = {
            new Position(8, 1), new Position(8, 2), new Position(9, 1), new Position(9, 2)
    };
    //path to win game
    public Position bluePathHome[] = {
            new Position(5, 1), new Position(5, 2), new Position(5, 3), new Position(5, 4)
    };
    public Position redPathHome[] = {
            new Position(1, 5), new Position(2, 5), new Position(3, 5), new Position(4, 5)
    };
    public Position greenPathHome[] = {
            new Position(5, 6), new Position(5, 7), new Position(5, 8), new Position(5, 9)
    };
    public Position yellowPathHome[] = {
            new Position(6, 5), new Position(7, 5), new Position(8, 5), new Position(9, 5)
    };
    //boolean array to check if a colour is already taken
    boolean[] selected = {false, false, false, false};
    //an int to count the number of players playing the game
    private int numOfPlayers =0;
    //to count though the array of players
    private int countPlayers =0;



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
        gameSquares = new JPanel[11][11];

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
        rollDice = new JButton("Roll Dice");
        gameSquares[5][5].add(rollDice);
        rollDice.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Adding tokens to board
        //blue tokens
        ImageIcon blueimage = new ImageIcon(getClass().getResource("blueIcon.png"));//https://www.kisspng.com/free/brik.html
        blueToken1 = new Token("blue");
        blueToken1.setIcon(blueimage);
        blueToken1.addActionListener(this);
        blueToken1.setVisible(false);
        gameSquares[1][2].add(blueToken1);
        blueToken2 = new Token("blue");
        blueToken2.setIcon(blueimage);
        blueToken2.addActionListener(this);
        blueToken2.setVisible(false);
        gameSquares[1][1].add(blueToken2);
        blueToken3 = new Token("blue");
        blueToken3.setIcon(blueimage);
        blueToken3.addActionListener(this);
        blueToken3.setVisible(false);
        gameSquares[2][1].add(blueToken3);
        blueToken4 = new Token("blue");
        blueToken4.setIcon(blueimage);
        blueToken4.addActionListener(this);
        blueToken4.setVisible(false);
        gameSquares[2][2].add(blueToken4);

        blueTokens = new Token[]{blueToken1,blueToken2,blueToken3,blueToken4};
        //red tokens
        ImageIcon redimage = new ImageIcon(getClass().getResource("redIcon.png"));//https://www.kisspng.com/free/brik.html
        redToken1 = new Token("red");
        redToken1.setIcon(redimage);
        redToken1.setVisible(false);
        gameSquares[2][9].add(redToken1);
        redToken2 = new Token("red");
        redToken2.setIcon(redimage);
        redToken2.setVisible(false);
        gameSquares[1][9].add(redToken2);
        redToken3 = new Token("red");
        redToken3.setIcon(redimage);
        redToken3.setVisible(false);
        gameSquares[1][8].add(redToken3);
        redToken4 = new Token("red");
        redToken4.setIcon(redimage);
        redToken4.setVisible(false);
        gameSquares[2][8].add(redToken4);

        redTokens = new Token[]{redToken1,redToken2,redToken3,redToken4};
        //green tokens
        ImageIcon greenimage = new ImageIcon(getClass().getResource("greenIcon.png"));//https://www.kisspng.com/free/brik.html
        greenToken1 = new Token("green");
        greenToken1.setIcon(greenimage);
        greenToken1.setVisible(false);
        gameSquares[8][8].add(greenToken1);
        greenToken2 = new Token("green");
        greenToken2.setIcon(greenimage);
        greenToken2.setVisible(false);
        gameSquares[8][9].add(greenToken2);
        greenToken3 = new Token("green");
        greenToken3.setIcon(greenimage);
        greenToken3.setVisible(false);
        gameSquares[9][8].add(greenToken3);
        greenToken4 = new Token("green");
        greenToken4.setIcon(greenimage);
        greenToken4.setVisible(false);
        gameSquares[9][9].add(greenToken4);

        greenTokens = new Token[]{greenToken1,greenToken2,greenToken3,greenToken4};
        //yellow token
        ImageIcon yellowimage = new ImageIcon(getClass().getResource("yellowIcon.png"));//https://www.iconspng.com/image/118736/ludo-piece-mustard-yellow
        yellowToken1 = new Token("yellow");
        yellowToken1.setIcon(yellowimage);
        yellowToken1.setVisible(false);
        gameSquares[9][1].add(yellowToken1);
        yellowToken2 = new Token("yellow");
        yellowToken2.setIcon(yellowimage);
        yellowToken2.setVisible(false);
        gameSquares[9][2].add(yellowToken2);
        yellowToken3 = new Token("yellow");
        yellowToken3.setIcon(yellowimage);
        yellowToken3.setVisible(false);
        gameSquares[8][1].add(yellowToken3);
        yellowToken4 = new Token("yellow");
        yellowToken4.setIcon(yellowimage);
        yellowToken4.setVisible(false);
        gameSquares[8][2].add(yellowToken4);

        yellowTokens = new Token[]{yellowToken1,yellowToken2,yellowToken3,yellowToken4};

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




        setHomePos();
        playerMenu();

    }
    //player rolling the dices
    @Override
    public void actionPerformed(ActionEvent e) {
        Player player = new Player();

        //roll dice button pushed
        if (e.getSource() == rollDice) {
            int roll = players[countPlayers].rolldice();
            //the player rolling the dice
            //players[countPlayers].rolldice();

            //if the colour matches the player
            if(players[countPlayers].getTokens().equals(blueTokens)){

                if(e.getSource() == blueToken1)
                {
                    if (roll == 6 && ((blueToken1.getPos().getX() == blueHome[0].getX()) && (blueToken1.getPos().getY() == blueHome[0].getY()))) {

                        moveFromHome();
                        repaint();
                    } else if (roll <= 6 && ((blueToken1.getPos().getX() != blueHome[0].getX()) && (blueToken1.getPos().getY() != blueHome[0].getY()))) {
                        int x;
                        int y;

                        moveIndex += roll;
                        if (moveIndex <= 39) {
                            x = pos[moveIndex].getX();
                            System.out.println(x + " " + moveIndex);
                            y = pos[moveIndex].getY();
                            System.out.println(y + " " + moveIndex);
                            blueToken1.setPos(pos[moveIndex]);
                            System.out.println(blueToken1.toString());
                            gameSquares[x][y].add(blueToken1);
                            repaint();
                        } else if (moveIndex <= 43) {
                            x = bluePathHome[moveIndex - 40].getX();
                            y = bluePathHome[moveIndex - 40].getY();
                            blueToken1.setPos(bluePathHome[moveIndex]);
                            gameSquares[x][y].add(blueToken1);
                            repaint();
                        } else
                            JOptionPane.showMessageDialog(null, players[countPlayers] + "Can't move");


                        //repaint();
                    } else
                        JOptionPane.showMessageDialog(null, players[countPlayers].getName() + "cant move sorry");
                }
                turnOver = true;
            }
                countPlayers++;
                if (countPlayers >= numOfPlayers) {
                    countPlayers = 0;
                }
            }
        }
        public void playerMenu() {
            //get the amount of players and there names and colours

                int selectedindex = 5;

                String name = "";
                String colour = "";

                numOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("How many players: "));
                while (numOfPlayers < 2 || numOfPlayers > 4) {
                    numOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Unable to play the game with that amount of players!! please have 2,3 or 4 players"));
                }
                players = new Player[numOfPlayers];

                for (int i = 0; i < players.length; i++) {
                    name = JOptionPane.showInputDialog("Please enter your name");
                    colour = JOptionPane.showInputDialog("Please choose a colour: blue, red, green or yellow").toLowerCase();

                    //JB Code Added here to loop while the colour value is bad for validation purposes

                    while (!colour.equals("blue") && !colour.equals("red") && !colour.equals("green") && !colour.equals("yellow"))
                        colour = JOptionPane.showInputDialog("Incorrect colour value - must be blue, red, green or yellow").toLowerCase();

                    if (colour.equals("blue")) {
                        selectedindex = 0;
                        blueToken1.setVisible(true);
                        blueToken2.setVisible(true);
                        blueToken3.setVisible(true);
                        blueToken4.setVisible(true);
                        players[i] = new Player(name, false, 0, blueTokens); //JB Added Code to construct Person object and link with their tokens

                    } else if (colour.equals("red")) {
                        selectedindex = 1;
                        redToken1.setVisible(true);
                        redToken2.setVisible(true);
                        redToken3.setVisible(true);
                        redToken4.setVisible(true);
                        players[i] = new Player(name, false, 0, redTokens); //JB Added Code to construct Person object and link with their tokens
                    } else if (colour.equals("green")) {
                        selectedindex = 2;
                        greenToken1.setVisible(true);
                        greenToken2.setVisible(true);
                        greenToken3.setVisible(true);
                        greenToken4.setVisible(true);
                        players[i] = new Player(name, false, 0, greenTokens); //JB Added Code to construct Person object and link with their tokens
                    } else if (colour.equals("yellow")) {
                        selectedindex = 3;
                        yellowToken1.setVisible(true);
                        yellowToken2.setVisible(true);
                        yellowToken3.setVisible(true);
                        yellowToken4.setVisible(true);
                        players[i] = new Player(name, false, 0, yellowTokens); //JB Added Code to construct Person object and link with their tokens
                    }

                    while (selected[selectedindex]) {
                        colour = JOptionPane.showInputDialog("Already taken!! Please choice another").toLowerCase();

                        //JB Code Added here to loop while the colour value is bad for validation purposes

                        while (!colour.equals("blue") && !colour.equals("red") && !colour.equals("green") && !colour.equals("yellow"))
                            colour = JOptionPane.showInputDialog("Incorrect colour value - must be blue, red, green or yellow").toLowerCase();


                        if (colour.equals("blue")) {
                            selectedindex = 0;
                            blueToken1.setVisible(true);
                            blueToken2.setVisible(true);
                            blueToken3.setVisible(true);
                            blueToken4.setVisible(true);
                            players[i] = new Player(name, false, 0, blueTokens); //JB Added Code to construct Person object and link with their tokens

                        } else if (colour.equals("red")) {
                            selectedindex = 1;
                            redToken1.setVisible(true);
                            redToken2.setVisible(true);
                            redToken3.setVisible(true);
                            redToken4.setVisible(true);
                            players[i] = new Player(name, false, 0, redTokens); //JB Added Code to construct Person object and link with their tokens
                        } else if (colour.equals("green")) {
                            selectedindex = 2;
                            greenToken1.setVisible(true);
                            greenToken2.setVisible(true);
                            greenToken3.setVisible(true);
                            greenToken4.setVisible(true);
                            players[i] = new Player(name, false, 0, greenTokens); //JB Added Code to construct Person object and link with their tokens
                        } else if (colour.equals("yellow")) {
                            selectedindex = 3;
                            yellowToken1.setVisible(true);
                            yellowToken2.setVisible(true);
                            yellowToken3.setVisible(true);
                            yellowToken4.setVisible(true);
                            players[i] = new Player(name, false, 0, yellowTokens); //JB Added Code to construct Person object and link with their tokens
                        }
                    }
                    selected[selectedindex] = true;
                }
            }

    void setHomePos()
    {
        blueToken1.setPos(blueHome[0]);
        blueToken2.setPos(blueHome[1]);
        blueToken3.setPos(blueHome[2]);
        blueToken4.setPos(blueHome[3]);

        redToken1.setPos(redHome[0]);
        redToken2.setPos(redHome[1]);
        redToken3.setPos(redHome[2]);
        redToken4.setPos(redHome[3]);

        greenToken1.setPos(greenHome[0]);
        greenToken2.setPos(greenHome[1]);
        greenToken3.setPos(greenHome[2]);
        greenToken4.setPos(greenHome[3]);

        yellowToken1.setPos(yellowHome[0]);
        yellowToken2.setPos(yellowHome[1]);
        yellowToken3.setPos(yellowHome[2]);
        yellowToken4.setPos(yellowHome[3]);
    }
    Component moveFromHome()
    {
        if(blueToken1.getPos().getX() == blueHome[0].getX() && blueToken1.getPos().getY() == blueHome[0].getY())
        {
            gameSquares[pos[0].getX()][pos[0].getY()].add(blueToken1);
            blueToken1.setPos(pos[0]);
        }
        return gameSquares[pos[0].getX()][pos[0].getY()].add(blueToken1);

    }

}

