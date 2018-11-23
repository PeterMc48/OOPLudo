import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LudoBoard extends JFrame implements ActionListener {

    Player[] players;
    Token[] blueTokens;
    Token[] redTokens;
    Token[] greenTokens;
    Token[] yellowTokens;

    /**
     *  tokens
     */
    //blue buttons

    public Token blueToken1; //JB Modified Code here - changed all tokens from JButton to Token objects //i changed all the JButtons to JLabels
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
    public int moveIndexblue1;
    public int moveIndexblue2;
    public int moveIndexblue3;
    public int moveIndexblue4;

    public int moveIndexred1;
    public int moveIndexred2;
    public int moveIndexred3;
    public int moveIndexred4;

    public int moveIndexgreen1;
    public int moveIndexgreen2;
    public int moveIndexgreen3;
    public int moveIndexgreen4;

    public int moveIndexyellow1;
    public int moveIndexyellow2;
    public int moveIndexyellow3;
    public int moveIndexyellow4;

    //lookup positions on the board
    public Position bluepos[] = {
            new Position(4, 0), new Position(3, 0), new Position(3, 1), new Position(3, 2),
            new Position(3, 3), new Position(2, 3), new Position(1, 3), new Position(0, 3),
            new Position(0, 4), new Position(0, 5), new Position(0, 6), new Position(0, 7),
            new Position(1, 7), new Position(2, 7), new Position(3, 7), new Position(3, 8),
            new Position(3, 9), new Position(3, 10), new Position(4, 10), new Position(5, 10),
            new Position(6, 10), new Position(7, 10), new Position(7, 9), new Position(7, 8),
            new Position(7, 7), new Position(8, 7), new Position(9, 7), new Position(10, 7),
            new Position(10, 6), new Position(10, 5), new Position(10, 4), new Position(10, 3),
            new Position(9, 3), new Position(8, 3), new Position(7, 3), new Position(7, 2),
            new Position(7, 1), new Position(7, 0), new Position(6, 0), new Position(5, 0)
    };
    public Position redpos[] = {
            new Position(0,6),new Position(0, 7),new Position(1, 7), new Position(2, 7),
            new Position(3, 7), new Position(3, 8),new Position(3, 9), new Position(3, 10),
            new Position(4, 10), new Position(5, 10),new Position(6, 10), new Position(7, 10),
            new Position(7, 9), new Position(7, 8),new Position(7, 7), new Position(8, 7),
            new Position(9, 7), new Position(10, 7),new Position(10, 6), new Position(10, 5),
            new Position(10, 4), new Position(10, 3),new Position(9, 3), new Position(8, 3),
            new Position(7, 3), new Position(7, 2),new Position(7, 1), new Position(7, 0),
            new Position(6, 0), new Position(5, 0),new Position(4, 0), new Position(3, 0),
            new Position(3, 1), new Position(3, 2),new Position(3, 3), new Position(2, 3),
            new Position(1, 3), new Position(0, 3),new Position(0, 4), new Position(0, 5)
    };
    public Position greenpos[] = {
            new Position(6, 10), new Position(7, 10), new Position(7, 9), new Position(7, 8),
            new Position(7, 7), new Position(8, 7), new Position(9, 7), new Position(10, 7),
            new Position(10, 6), new Position(10, 5), new Position(10, 4), new Position(10, 3),
            new Position(9, 3), new Position(8, 3), new Position(7, 3), new Position(7, 2),
            new Position(7, 1), new Position(7, 0), new Position(6, 0), new Position(5, 0),
            new Position(4, 0), new Position(3, 0), new Position(3, 1), new Position(3, 2),
            new Position(3, 3), new Position(2, 3), new Position(1, 3), new Position(0, 3),
            new Position(0, 4), new Position(0, 5),new Position(0,6),new Position(0, 7),
            new Position(1, 7), new Position(2, 7),new Position(3, 7), new Position(3, 8),
            new Position(3, 9), new Position(3, 10),new Position(4, 10), new Position(5, 10)

    };
    public Position yellowpos[] = {
            new Position(10, 4), new Position(10, 3),new Position(9, 3), new Position(8, 3),
            new Position(7, 3), new Position(7, 2),new Position(7, 1), new Position(7, 0),
            new Position(6, 0), new Position(5, 0),new Position(4, 0), new Position(3, 0),
            new Position(3, 1), new Position(3, 2),new Position(3, 3), new Position(2, 3),
            new Position(1, 3), new Position(0, 3),new Position(0, 4), new Position(0, 5),
            new Position(0,6),new Position(0, 7),new Position(1, 7), new Position(2, 7),
            new Position(3, 7), new Position(3, 8),new Position(3, 9), new Position(3, 10),
            new Position(4, 10), new Position(4, 10),new Position(6, 10), new Position(7, 10),
            new Position(7, 9), new Position(7, 8),new Position(7, 7), new Position(8, 7),
            new Position(9, 7), new Position(10, 7),new Position(10, 6), new Position(10, 5)
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
    private int numOfPlayers = 0;
    //to count though the array of players
    private int countPlayers = 0;


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
        blueToken1.setVisible(false);
        blueToken1.setText("blue1");
        gameSquares[1][2].add(blueToken1);
        blueToken2 = new Token("blue");
        blueToken2.setIcon(blueimage);
        blueToken2.setText("blue2");
        blueToken2.setVisible(false);
        gameSquares[1][1].add(blueToken2);
        blueToken3 = new Token("blue");
        blueToken3.setIcon(blueimage);
        blueToken3.setText("blue3");
        blueToken3.setVisible(false);
        gameSquares[2][1].add(blueToken3);
        blueToken4 = new Token("blue");
        blueToken4.setIcon(blueimage);
        blueToken4.setText("blue4");
        blueToken4.setVisible(false);
        gameSquares[2][2].add(blueToken4);

        blueTokens = new Token[]{blueToken1, blueToken2, blueToken3, blueToken4};
        //red tokens
        ImageIcon redimage = new ImageIcon(getClass().getResource("redIcon.png"));//https://www.kisspng.com/free/brik.html
        redToken1 = new Token("red");
        redToken1.setIcon(redimage);
        redToken1.setVisible(false);
        redToken1.setText("red1");
        gameSquares[2][9].add(redToken1);
        redToken2 = new Token("red");
        redToken2.setIcon(redimage);
        redToken2.setVisible(false);
        redToken2.setText("red2");
        gameSquares[1][9].add(redToken2);
        redToken3 = new Token("red");
        redToken3.setIcon(redimage);
        redToken3.setVisible(false);
        redToken3.setText("red3");
        gameSquares[1][8].add(redToken3);
        redToken4 = new Token("red");
        redToken4.setIcon(redimage);
        redToken4.setVisible(false);
        redToken4.setText("red4");
        gameSquares[2][8].add(redToken4);

        redTokens = new Token[]{redToken1, redToken2, redToken3, redToken4};
        //green tokens
        ImageIcon greenimage = new ImageIcon(getClass().getResource("greenIcon.png"));//https://www.kisspng.com/free/brik.html
        greenToken1 = new Token("green");
        greenToken1.setIcon(greenimage);
        greenToken1.setVisible(false);
        greenToken1.setText("green1");
        gameSquares[8][8].add(greenToken1);
        greenToken2 = new Token("green");
        greenToken2.setIcon(greenimage);
        greenToken2.setVisible(false);
        greenToken2.setText("green2");
        gameSquares[8][9].add(greenToken2);
        greenToken3 = new Token("green");
        greenToken3.setIcon(greenimage);
        greenToken3.setVisible(false);
        greenToken3.setText("green3");
        gameSquares[9][8].add(greenToken3);
        greenToken4 = new Token("green");
        greenToken4.setIcon(greenimage);
        greenToken4.setVisible(false);
        greenToken4.setText("green4");
        gameSquares[9][9].add(greenToken4);

        greenTokens = new Token[]{greenToken1, greenToken2, greenToken3, greenToken4};
        //yellow token
        ImageIcon yellowimage = new ImageIcon(getClass().getResource("yellowIcon.png"));//https://www.iconspng.com/image/118736/ludo-piece-mustard-yellow
        yellowToken1 = new Token("yellow");
        yellowToken1.setIcon(yellowimage);
        yellowToken1.setVisible(false);
        yellowToken1.setText("yellow1");
        gameSquares[9][1].add(yellowToken1);
        yellowToken2 = new Token("yellow");
        yellowToken2.setIcon(yellowimage);
        yellowToken2.setVisible(false);
        yellowToken2.setText("yellow2");
        gameSquares[9][2].add(yellowToken2);
        yellowToken3 = new Token("yellow");
        yellowToken3.setIcon(yellowimage);
        yellowToken3.setVisible(false);
        yellowToken3.setText("yellow3");
        gameSquares[8][1].add(yellowToken3);
        yellowToken4 = new Token("yellow");
        yellowToken4.setIcon(yellowimage);
        yellowToken4.setVisible(false);
        yellowToken4.setText("yellow4");
        gameSquares[8][2].add(yellowToken4);

        yellowTokens = new Token[]{yellowToken1, yellowToken2, yellowToken3, yellowToken4};

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

        playerMenu();
        setHomePos();




    }

    //player rolling the dices
    @Override
    public void actionPerformed(ActionEvent e) {
        Player player = new Player();

        int roll = 0;
        //roll dice button pushed
        if (e.getSource() == rollDice) {
            roll = players[countPlayers].rolldice();
            //the player rolling the dice
            //players[countPlayers].rolldice();


            //if the colour matches the player
            if (players[countPlayers].getTokens().equals(blueTokens)) {
                while((roll == 6)){ /*&& ((blueToken1.getPos().getX() == blueHome[0].getX()) && (blueToken1.getPos().getY() == blueHome[0].getY())) ||
                        ((blueToken2.getPos().getX() == blueHome[1].getX()) && (blueToken2.getPos().getY() == blueHome[1].getY())) ||
                        ((blueToken3.getPos().getX() == blueHome[2].getX()) && (blueToken3.getPos().getY() == blueHome[2].getY())) ||
                        ((blueToken4.getPos().getX() == blueHome[3].getX()) && (blueToken4.getPos().getY() == blueHome[3].getY()))) {*/

                    String chooseToken = JOptionPane.showInputDialog("please choice a token to move blue1,blue2,blue3,blue4").toLowerCase();

                    while (!chooseToken.equals("blue1") && !chooseToken.equals("blue2") && !chooseToken.equals("blue3") && !chooseToken.equals("blue4")) {
                        chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move blue1,blue2,blue3,blue4").toLowerCase();
                    }
                    //switch (chooseToken) {
                    //  case "blue1":
                    if (chooseToken.equals("blue1")) {
                        if (((blueToken1.getPos().getX() == blueHome[0].getX()) && (blueToken1.getPos().getY() == blueHome[0].getY()))) {
                            moveBlue1FromHome();
                            repaint();


                        } else if (((blueToken1.getPos().getX() != blueHome[0].getX()) && (blueToken1.getPos().getY() != blueHome[0].getY()))) {
                            int x;
                            int y;

                            moveIndexblue1 += roll;
                            if (moveIndexblue1 <= 39) {
                                x = bluepos[moveIndexblue1].getX();
                                System.out.println(x + " " + moveIndexblue1);
                                y = bluepos[moveIndexblue1].getY();
                                System.out.println(y + " " + moveIndexblue1);
                                blueToken1.setPos(bluepos[moveIndexblue1]);
                                System.out.println(blueToken1.toString());
                                gameSquares[x][y].add(blueToken1);
                                repaint();
                            }

                        }
                    }       //break;
                    //case "blue2":
                    else if (chooseToken.equals("blue2")) {
                        if (((blueToken2.getPos().getX() == blueHome[1].getX()) && (blueToken2.getPos().getY() == blueHome[1].getY()))) {
                            moveBlue2FromHome();
                            repaint();

                        } else if (((blueToken2.getPos().getX() != blueHome[1].getX()) && (blueToken2.getPos().getY() != blueHome[1].getY()))) {
                            int x;
                            int y;

                            moveIndexblue2 += roll;
                            if (moveIndexblue2 <= 39) {
                                x = bluepos[moveIndexblue2].getX();
                                System.out.println(x + " " + moveIndexblue2);
                                y = bluepos[moveIndexblue2].getY();
                                System.out.println(y + " " + moveIndexblue2);
                                blueToken2.setPos(bluepos[moveIndexblue2]);
                                System.out.println(blueToken2.toString());
                                gameSquares[x][y].add(blueToken2);
                                repaint();
                            }

                        }
                        //       break;
                        //   case "blue3":
                    } else if (chooseToken.equals("blue3")) {
                        if (((blueToken3.getPos().getX() == blueHome[2].getX()) && (blueToken3.getPos().getY() == blueHome[2].getY()))) {
                            moveBlue3FromHome();
                            repaint();

                        } else if (((blueToken3.getPos().getX() != blueHome[2].getX()) && (blueToken3.getPos().getY() != blueHome[2].getY()))) {
                            int x;
                            int y;

                            moveIndexblue3 += roll;
                            if (moveIndexblue3 <= 39) {
                                x = bluepos[moveIndexblue3].getX();
                                System.out.println(x + " " + moveIndexblue3);
                                y = bluepos[moveIndexblue3].getY();
                                System.out.println(y + " " + moveIndexblue3);
                                blueToken3.setPos(bluepos[moveIndexblue3]);
                                System.out.println(blueToken3.toString());
                                gameSquares[x][y].add(blueToken3);
                                repaint();
                            }

                        }
                        //       break;
                        //  case "blue4":
                    } else if (chooseToken.equals("blue4")) {
                        if (((blueToken4.getPos().getX() == blueHome[3].getX()) && (blueToken4.getPos().getY() == blueHome[3].getY()))) {
                            moveBlue4FromHome();
                            repaint();

                        } else if (((blueToken4.getPos().getX() != blueHome[3].getX()) && (blueToken4.getPos().getY() != blueHome[3].getY()))) {
                            int x;
                            int y;

                            moveIndexblue4 += roll;
                            if (moveIndexblue4 <= 39) {
                                x = bluepos[moveIndexblue4].getX();
                                System.out.println(x + " " + moveIndexblue4);
                                y = bluepos[moveIndexblue4].getY();
                                System.out.println(y + " " + moveIndexblue4);
                                blueToken4.setPos(bluepos[moveIndexblue4]);
                                System.out.println(blueToken4.toString());
                                gameSquares[x][y].add(blueToken4);
                                repaint();

                            }

                        }

                    }
                    roll = players[countPlayers].rolldice();
                    // break;
                    //default:
                    //       JOptionPane.showMessageDialog(null, "Invalid Token choose");
                }

                if (roll < 6 && (blueToken1.getPos().getX() != blueHome[0].getX()) && (blueToken1.getPos().getY() != blueHome[0].getY()) ||
                        (blueToken2.getPos().getX() != blueHome[1].getX()) && (blueToken2.getPos().getY() != blueHome[1].getY()) ||
                        (blueToken3.getPos().getX() != blueHome[2].getX()) && (blueToken3.getPos().getY() != blueHome[2].getY()) ||
                        (blueToken4.getPos().getX() != blueHome[3].getX()) && (blueToken4.getPos().getY() != blueHome[3].getY())) {
                String chooseToken = JOptionPane.showInputDialog("please choice a token to move blue1,blue2,blue3,blue4").toLowerCase();

                while (!chooseToken.equals("blue1") && !chooseToken.equals("blue2") && !chooseToken.equals("blue3") && !chooseToken.equals("blue4")) {
                    chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move blue1,blue2,blue3,blue4").toLowerCase();
                }
                if (chooseToken.equals("blue1")) {
                    if ((blueToken1.getPos().getX() != blueHome[0].getX()) && (blueToken1.getPos().getY() != blueHome[0].getY())) {
                        int x;
                        int y;

                        moveIndexblue1 += roll;
                        if (moveIndexblue1 <= 39) {
                            x = bluepos[moveIndexblue1].getX();
                            System.out.println(x + " " + moveIndexblue1);
                            y = bluepos[moveIndexblue1].getY();
                            System.out.println(y + " " + moveIndexblue1);
                            blueToken1.setPos(bluepos[moveIndexblue1]);
                            System.out.println(blueToken1.toString());
                            gameSquares[x][y].add(blueToken1);
                            repaint();
                        } else if (moveIndexblue1 > 39 && moveIndexblue1 < 43) {
                            x = bluePathHome[moveIndexblue1 - 40].getX();
                            y = bluePathHome[moveIndexblue1 - 40].getY();
                            blueToken1.setPos(bluePathHome[moveIndexblue1]);
                            gameSquares[x][y].add(blueToken1);
                            repaint();
                        }
                        else if(moveIndexblue1 >= 43)
                        {
                            moveIndexblue1 = moveIndexblue1 - roll;
                            if(moveIndexblue1 <=39)
                            {
                                x = bluepos[moveIndexblue1 - 43].getX();
                                y = bluepos[moveIndexblue1 - 43].getY();
                                blueToken1.setPos(bluepos[moveIndexblue1]);
                                gameSquares[x][y].add(blueToken1);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                            else if(moveIndexblue1 >=40)
                            {
                                x = bluePathHome[moveIndexblue1 - 43].getX();
                                y = bluePathHome[moveIndexblue1 - 43].getY();
                                blueToken1.setPos(bluePathHome[moveIndexblue1]);
                                gameSquares[x][y].add(blueToken1);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                } else if (chooseToken.equals("blue2")) {
                    if ((blueToken2.getPos().getX() != blueHome[1].getX()) && (blueToken2.getPos().getY() != blueHome[1].getY())) {
                        int x;
                        int y;

                        moveIndexblue2 += roll;
                        if (moveIndexblue2 <= 39) {
                            x = bluepos[moveIndexblue2].getX();
                            System.out.println(x + " " + moveIndexblue2);
                            y = bluepos[moveIndexblue2].getY();
                            System.out.println(y + " " + moveIndexblue2);
                            blueToken2.setPos(bluepos[moveIndexblue2]);
                            System.out.println(blueToken2.toString());
                            gameSquares[x][y].add(blueToken2);
                            repaint();
                        } else if (moveIndexblue2 <= 43) {
                            x = bluePathHome[moveIndexblue2 - 40].getX();
                            y = bluePathHome[moveIndexblue2 - 40].getY();
                            blueToken2.setPos(bluePathHome[moveIndexblue2]);
                            gameSquares[x][y].add(blueToken2);
                            repaint();
                        }
                        else if(moveIndexblue1 >= 43)
                        {
                            moveIndexblue2 = moveIndexblue2 - roll;
                            if(moveIndexblue2 <=39)
                            {
                                x = bluepos[moveIndexblue2 - 43].getX();
                                y = bluepos[moveIndexblue2 - 43].getY();
                                blueToken2.setPos(bluepos[moveIndexblue2]);
                                gameSquares[x][y].add(blueToken2);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                            else if(moveIndexblue2 >=40)
                            {
                                x = bluePathHome[moveIndexblue2 - 43].getX();
                                y = bluePathHome[moveIndexblue2 - 43].getY();
                                blueToken2.setPos(bluePathHome[moveIndexblue2]);
                                gameSquares[x][y].add(blueToken2);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                } else if (chooseToken.equals("blue3")) {
                    if ((blueToken3.getPos().getX() != blueHome[2].getX()) && (blueToken3.getPos().getY() != blueHome[2].getY())) {
                        int x;
                        int y;

                        moveIndexblue3 += roll;
                        if (moveIndexblue3 <= 39) {
                            x = bluepos[moveIndexblue3].getX();
                            System.out.println(x + " " + moveIndexblue3);
                            y = bluepos[moveIndexblue3].getY();
                            System.out.println(y + " " + moveIndexblue3);
                            blueToken3.setPos(bluepos[moveIndexblue3]);
                            System.out.println(blueToken3.toString());
                            gameSquares[x][y].add(blueToken3);
                            repaint();
                        } else if (moveIndexblue3 <= 43) {
                            x = bluePathHome[moveIndexblue3 - 40].getX();
                            y = bluePathHome[moveIndexblue3 - 40].getY();
                            blueToken3.setPos(bluePathHome[moveIndexblue3]);
                            gameSquares[x][y].add(blueToken3);
                            repaint();
                        }
                        else if(moveIndexblue3 >= 43)
                        {
                            moveIndexblue3 = moveIndexblue3 - roll;
                            if(moveIndexblue3 <=39)
                            {
                                x = bluepos[moveIndexblue3 - 43].getX();
                                y = bluepos[moveIndexblue3 - 43].getY();
                                blueToken3.setPos(bluepos[moveIndexblue3]);
                                gameSquares[x][y].add(blueToken3);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                            else if(moveIndexblue3 >=40)
                            {
                                x = bluePathHome[moveIndexblue3 - 43].getX();
                                y = bluePathHome[moveIndexblue3 - 43].getY();
                                blueToken3.setPos(bluePathHome[moveIndexblue3]);
                                gameSquares[x][y].add(blueToken3);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                } else if (chooseToken.equals("blue4")) {
                    if ((blueToken4.getPos().getX() != blueHome[3].getX()) && (blueToken4.getPos().getY() != blueHome[3].getY())) {
                        int x;
                        int y;

                        moveIndexblue4 += roll;
                        if (moveIndexblue4 <= 39) {
                            x = bluepos[moveIndexblue4].getX();
                            System.out.println(x + " " + moveIndexblue4);
                            y = bluepos[moveIndexblue4].getY();
                            System.out.println(y + " " + moveIndexblue4);
                            blueToken4.setPos(bluepos[moveIndexblue4]);
                            System.out.println(blueToken4.toString());
                            gameSquares[x][y].add(blueToken4);
                            repaint();
                        } else if (moveIndexblue4 <= 43) {
                            x = bluePathHome[moveIndexblue4 - 40].getX();
                            y = bluePathHome[moveIndexblue4 - 40].getY();
                            blueToken4.setPos(bluePathHome[moveIndexblue4]);
                            gameSquares[x][y].add(blueToken4);
                            repaint();
                        }
                        else if(moveIndexblue4 >= 43)
                        {
                            moveIndexblue4 = moveIndexblue4 - roll;
                            if(moveIndexblue4 <=39)
                            {
                                x = bluepos[moveIndexblue4 - 43].getX();
                                y = bluepos[moveIndexblue4 - 43].getY();
                                blueToken4.setPos(bluepos[moveIndexblue4]);
                                gameSquares[x][y].add(blueToken4);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                            else if(moveIndexblue4 >=40)
                            {
                                x = bluePathHome[moveIndexblue4 - 43].getX();
                                y = bluePathHome[moveIndexblue4 - 43].getY();
                                blueToken4.setPos(bluePathHome[moveIndexblue4]);
                                gameSquares[x][y].add(blueToken4);
                                repaint();
                                JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                }
            }
            else
                    JOptionPane.showMessageDialog(null, players[countPlayers] + "Can't move");
            }
            if (players[countPlayers].getTokens().equals(redTokens)) {
                while((roll == 6)){ /*&& ((blueToken1.getPos().getX() == blueHome[0].getX()) && (blueToken1.getPos().getY() == blueHome[0].getY())) ||
                        ((blueToken2.getPos().getX() == blueHome[1].getX()) && (blueToken2.getPos().getY() == blueHome[1].getY())) ||
                        ((blueToken3.getPos().getX() == blueHome[2].getX()) && (blueToken3.getPos().getY() == blueHome[2].getY())) ||
                        ((blueToken4.getPos().getX() == blueHome[3].getX()) && (blueToken4.getPos().getY() == blueHome[3].getY()))) {*/

                    String chooseToken = JOptionPane.showInputDialog("please choice a token to move red1,red2,red3,red4").toLowerCase();

                    while (!chooseToken.equals("red1") && !chooseToken.equals("red2") && !chooseToken.equals("red3") && !chooseToken.equals("red4")) {
                        chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move red1,red2,red3,red4").toLowerCase();
                    }
                    //switch (chooseToken) {
                    //  case "blue1":
                    if (chooseToken.equals("red1")) {
                        if (((redToken1.getPos().getX() == redHome[0].getX()) && (redToken1.getPos().getY() == redHome[0].getY()))) {
                            movered1FromHome();
                            repaint();
                        } else if (((redToken1.getPos().getX() != redHome[0].getX()) && (redToken1.getPos().getY() != redHome[0].getY()))) {
                            int x;
                            int y;

                            moveIndexred1 += roll;
                            if (moveIndexred1 <= 39) {
                                x = redpos[moveIndexred1].getX();
                                System.out.println(x + " " + moveIndexred1);
                                y = redpos[moveIndexred1].getY();
                                System.out.println(y + " " + moveIndexred1);
                                redToken1.setPos(redpos[moveIndexred1]);
                                System.out.println(redToken1.toString());
                                gameSquares[x][y].add(redToken1);
                                repaint();
                            }
                        }
                    }       //break;
                    //case "blue2":
                    else if (chooseToken.equals("red2")) {
                        if (((redToken2.getPos().getX() == redHome[1].getX()) && (redToken2.getPos().getY() == redHome[1].getY()))) {
                            movered2FromHome();
                            repaint();
                        } else if (((redToken2.getPos().getX() != redHome[1].getX()) && (redToken2.getPos().getY() != redHome[1].getY()))) {
                            int x;
                            int y;

                            moveIndexred2 += roll;
                            if (moveIndexred2 <= 39) {
                                x = redpos[moveIndexred2].getX();
                                System.out.println(x + " " + moveIndexred2);
                                y = redpos[moveIndexred2].getY();
                                System.out.println(y + " " + moveIndexred2);
                                redToken2.setPos(redpos[moveIndexred2]);
                                System.out.println(redToken2.toString());
                                gameSquares[x][y].add(redToken2);
                                repaint();
                            }
                        }
                        //       break;
                        //   case "blue3":
                    } else if (chooseToken.equals("red3")) {
                        if (((redToken3.getPos().getX() == redHome[2].getX()) && (redToken3.getPos().getY() == redHome[2].getY()))) {
                            movered3FromHome();
                            repaint();
                        } else if (((redToken3.getPos().getX() != redHome[2].getX()) && (redToken3.getPos().getY() != redHome[2].getY()))) {
                            int x;
                            int y;

                            moveIndexred3 += roll;
                            if (moveIndexred3 <= 39) {
                                x = redpos[moveIndexred3].getX();
                                System.out.println(x + " " + moveIndexred3);
                                y = redpos[moveIndexred3].getY();
                                System.out.println(y + " " + moveIndexred3);
                                redToken3.setPos(redpos[moveIndexred3]);
                                System.out.println(redToken3.toString());
                                gameSquares[x][y].add(redToken3);
                                repaint();
                            }
                        }
                        //       break;
                        //  case "blue4":
                    } else if (chooseToken.equals("red4")) {
                        if (((redToken4.getPos().getX() == redHome[3].getX()) && (redToken4.getPos().getY() == redHome[3].getY()))) {
                            movered4FromHome();
                            repaint();
                        } else if (((redToken4.getPos().getX() != redHome[3].getX()) && (redToken4.getPos().getY() != redHome[3].getY()))) {
                            int x;
                            int y;

                            moveIndexred4 += roll;
                            if (moveIndexred4 <= 39) {
                                x = redpos[moveIndexred4].getX();
                                System.out.println(x + " " + moveIndexred4);
                                y = redpos[moveIndexred4].getY();
                                System.out.println(y + " " + moveIndexred4);
                                redToken4.setPos(redpos[moveIndexred4]);
                                System.out.println(redToken4.toString());
                                gameSquares[x][y].add(redToken4);
                                repaint();
                            }
                        }
                    }
                    roll = players[countPlayers].rolldice();
                    // break;
                    //default:
                    //       JOptionPane.showMessageDialog(null, "Invalid Token choose");
                }

                if (roll < 6 && (redToken1.getPos().getX() != redHome[0].getX()) && (redToken1.getPos().getY() != redHome[0].getY()) ||
                        (redToken2.getPos().getX() != redHome[1].getX()) && (redToken2.getPos().getY() != redHome[1].getY()) ||
                        (redToken3.getPos().getX() != redHome[2].getX()) && (redToken3.getPos().getY() != redHome[2].getY()) ||
                        (redToken4.getPos().getX() != redHome[3].getX()) && (redToken4.getPos().getY() != redHome[3].getY())) {
                    String chooseToken = JOptionPane.showInputDialog("please choice a token to move red1,red2,red3,red4").toLowerCase();

                    while (!chooseToken.equals("red1") && !chooseToken.equals("red2") && !chooseToken.equals("red3") && !chooseToken.equals("red4")) {
                        chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move red1,red2,red3,red4").toLowerCase();
                    }
                    if (chooseToken.equals("red1")) {
                        if ((redToken1.getPos().getX() != redHome[0].getX()) && (redToken1.getPos().getY() != redHome[0].getY())) {
                            int x;
                            int y;

                            moveIndexred1 += roll;
                            if (moveIndexred1 <= 39) {
                                x = redpos[moveIndexred1].getX();
                                System.out.println(x + " " + moveIndexred1);
                                y = redpos[moveIndexred1].getY();
                                System.out.println(y + " " + moveIndexred1);
                                redToken1.setPos(redpos[moveIndexred1]);
                                System.out.println(redToken1.toString());
                                gameSquares[x][y].add(redToken1);
                                repaint();
                            } else if (moveIndexred1 > 39 && moveIndexred1 < 43) {
                                x = redPathHome[moveIndexred1 - 40].getX();
                                y = redPathHome[moveIndexred1 - 40].getY();
                                redToken1.setPos(redPathHome[moveIndexred1]);
                                gameSquares[x][y].add(redToken1);
                                repaint();
                            }
                            else if(moveIndexred1 >= 43)
                            {
                                moveIndexred1 = moveIndexred1 - roll;
                                if(moveIndexred1 <=39)
                                {
                                    x = redpos[moveIndexred1 - 43].getX();
                                    y = redpos[moveIndexred1 - 43].getY();
                                    redToken1.setPos(redpos[moveIndexred1]);
                                    gameSquares[x][y].add(redToken1);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexred1 >=40)
                                {
                                    x = redPathHome[moveIndexred1 - 43].getX();
                                    y = redPathHome[moveIndexred1 - 43].getY();
                                    redToken1.setPos(redPathHome[moveIndexred1]);
                                    gameSquares[x][y].add(redToken1);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("red2")) {
                        if ((redToken2.getPos().getX() != redHome[1].getX()) && (redToken2.getPos().getY() != redHome[1].getY())) {
                            int x;
                            int y;

                            moveIndexred2 += roll;
                            if (moveIndexred2 <= 39) {
                                x = redpos[moveIndexred2].getX();
                                System.out.println(x + " " + moveIndexred2);
                                y = redpos[moveIndexred2].getY();
                                System.out.println(y + " " + moveIndexred2);
                                redToken2.setPos(redpos[moveIndexred2]);
                                System.out.println(redToken2.toString());
                                gameSquares[x][y].add(redToken2);
                                repaint();
                            } else if (moveIndexred2 <= 43) {
                                x = redPathHome[moveIndexred2 - 40].getX();
                                y = redPathHome[moveIndexred2 - 40].getY();
                                redToken2.setPos(redPathHome[moveIndexred2]);
                                gameSquares[x][y].add(redToken2);
                                repaint();
                            }
                            else if(moveIndexred1 >= 43)
                            {
                                moveIndexred2 = moveIndexred2 - roll;
                                if(moveIndexred2 <=39)
                                {
                                    x = redpos[moveIndexred2 - 43].getX();
                                    y = redpos[moveIndexred2 - 43].getY();
                                    redToken2.setPos(redpos[moveIndexred2]);
                                    gameSquares[x][y].add(redToken2);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexred2 >=40)
                                {
                                    x = redPathHome[moveIndexred2 - 43].getX();
                                    y = redPathHome[moveIndexred2 - 43].getY();
                                    redToken2.setPos(redPathHome[moveIndexred2]);
                                    gameSquares[x][y].add(redToken2);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("red3")) {
                        if ((redToken3.getPos().getX() != redHome[2].getX()) && (redToken3.getPos().getY() != redHome[2].getY())) {
                            int x;
                            int y;

                            moveIndexred3 += roll;
                            if (moveIndexred3 <= 39) {
                                x = redpos[moveIndexred3].getX();
                                System.out.println(x + " " + moveIndexred3);
                                y = redpos[moveIndexred3].getY();
                                System.out.println(y + " " + moveIndexred3);
                                redToken3.setPos(redpos[moveIndexred3]);
                                System.out.println(redToken3.toString());
                                gameSquares[x][y].add(redToken3);
                                repaint();
                            } else if (moveIndexred3 <= 43) {
                                x = redPathHome[moveIndexred3 - 40].getX();
                                y = redPathHome[moveIndexred3 - 40].getY();
                                redToken3.setPos(redPathHome[moveIndexred3]);
                                gameSquares[x][y].add(redToken3);
                                repaint();
                            }
                            else if(moveIndexred3 >= 43)
                            {
                                moveIndexred3 = moveIndexred3 - roll;
                                if(moveIndexred3 <=39)
                                {
                                    x = redpos[moveIndexred3 - 43].getX();
                                    y = redpos[moveIndexred3 - 43].getY();
                                    redToken3.setPos(redpos[moveIndexred3]);
                                    gameSquares[x][y].add(redToken3);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexred3 >=40)
                                {
                                    x = redPathHome[moveIndexred3 - 43].getX();
                                    y = redPathHome[moveIndexred3 - 43].getY();
                                    redToken3.setPos(redPathHome[moveIndexred3]);
                                    gameSquares[x][y].add(redToken3);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("red4")) {
                        if ((redToken4.getPos().getX() != redHome[3].getX()) && (redToken4.getPos().getY() != redHome[3].getY())) {
                            int x;
                            int y;

                            moveIndexred4 += roll;
                            if (moveIndexred4 <= 39) {
                                x = redpos[moveIndexred4].getX();
                                System.out.println(x + " " + moveIndexred4);
                                y = redpos[moveIndexred4].getY();
                                System.out.println(y + " " + moveIndexred4);
                                redToken4.setPos(redpos[moveIndexred4]);
                                System.out.println(redToken4.toString());
                                gameSquares[x][y].add(redToken4);
                                repaint();
                            } else if (moveIndexred4 <= 43) {
                                x = redPathHome[moveIndexred4 - 40].getX();
                                y = redPathHome[moveIndexred4 - 40].getY();
                                redToken4.setPos(redPathHome[moveIndexred4]);
                                gameSquares[x][y].add(redToken4);
                                repaint();
                            }
                            else if(moveIndexred4 >= 43)
                            {
                                moveIndexred4 = moveIndexred4 - roll;
                                if(moveIndexred4 <=39)
                                {
                                    x = redpos[moveIndexred4 - 43].getX();
                                    y = redpos[moveIndexred4 - 43].getY();
                                    redToken4.setPos(redpos[moveIndexred4]);
                                    gameSquares[x][y].add(redToken4);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexred4 >=40)
                                {
                                    x = redPathHome[moveIndexred4 - 43].getX();
                                    y = redPathHome[moveIndexred4 - 43].getY();
                                    redToken4.setPos(redPathHome[moveIndexred4]);
                                    gameSquares[x][y].add(redToken4);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, players[countPlayers] + "Can't move");
            }
            if (players[countPlayers].getTokens().equals(greenTokens)) {
                while((roll == 6)){ /*&& ((blueToken1.getPos().getX() == blueHome[0].getX()) && (blueToken1.getPos().getY() == blueHome[0].getY())) ||
                        ((blueToken2.getPos().getX() == blueHome[1].getX()) && (blueToken2.getPos().getY() == blueHome[1].getY())) ||
                        ((blueToken3.getPos().getX() == blueHome[2].getX()) && (blueToken3.getPos().getY() == blueHome[2].getY())) ||
                        ((blueToken4.getPos().getX() == blueHome[3].getX()) && (blueToken4.getPos().getY() == blueHome[3].getY()))) {*/

                    String chooseToken = JOptionPane.showInputDialog("please choice a token to move green1,green2,green3,green4").toLowerCase();

                    while (!chooseToken.equals("green") && !chooseToken.equals("green") && !chooseToken.equals("green3") && !chooseToken.equals("green4")) {
                        chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move green1,green2,green3,green4").toLowerCase();
                    }
                    //switch (chooseToken) {
                    //  case "blue1":
                    if (chooseToken.equals("green1")) {
                        if (((greenToken1.getPos().getX() == greenHome[0].getX()) && (greenToken1.getPos().getY() == greenHome[0].getY()))) {
                            movegreen1FromHome();
                            repaint();
                        } else if (((greenToken1.getPos().getX() != greenHome[0].getX()) && (greenToken1.getPos().getY() != greenHome[0].getY()))) {
                            int x;
                            int y;

                            moveIndexgreen1 += roll;
                            if (moveIndexgreen1 <= 39) {
                                x = greenpos[moveIndexgreen1].getX();
                                System.out.println(x + " " + moveIndexgreen1);
                                y = greenpos[moveIndexgreen1].getY();
                                System.out.println(y + " " + moveIndexgreen1);
                                greenToken1.setPos(greenpos[moveIndexgreen1]);
                                System.out.println(greenToken1.toString());
                                gameSquares[x][y].add(greenToken1);
                                repaint();
                            }
                        }
                    }       //break;
                    //case "blue2":
                    else if (chooseToken.equals("green2")) {
                        if (((greenToken2.getPos().getX() == greenHome[1].getX()) && (greenToken2.getPos().getY() == greenHome[1].getY()))) {
                            movegreen2FromHome();
                            repaint();
                        } else if (((greenToken2.getPos().getX() != greenHome[1].getX()) && (greenToken2.getPos().getY() != greenHome[1].getY()))) {
                            int x;
                            int y;

                            moveIndexgreen2 += roll;
                            if (moveIndexgreen2 <= 39) {
                                x = greenpos[moveIndexgreen2].getX();
                                System.out.println(x + " " + moveIndexgreen2);
                                y = greenpos[moveIndexgreen2].getY();
                                System.out.println(y + " " + moveIndexgreen2);
                                greenToken2.setPos(greenpos[moveIndexgreen2]);
                                System.out.println(greenToken2.toString());
                                gameSquares[x][y].add(greenToken2);
                                repaint();
                            }
                        }
                        //       break;
                        //   case "blue3":
                    } else if (chooseToken.equals("green3")) {
                        if (((greenToken3.getPos().getX() == greenHome[2].getX()) && (greenToken3.getPos().getY() == greenHome[2].getY()))) {
                            movegreen3FromHome();
                            repaint();
                        } else if (((greenToken3.getPos().getX() != greenHome[2].getX()) && (greenToken3.getPos().getY() != greenHome[2].getY()))) {
                            int x;
                            int y;

                            moveIndexgreen3 += roll;
                            if (moveIndexgreen3 <= 39) {
                                x = greenpos[moveIndexgreen3].getX();
                                System.out.println(x + " " + moveIndexgreen3);
                                y = greenpos[moveIndexgreen3].getY();
                                System.out.println(y + " " + moveIndexred3);
                                redToken3.setPos(greenpos[moveIndexgreen3]);
                                System.out.println(greenToken3.toString());
                                gameSquares[x][y].add(greenToken3);
                                repaint();
                            }
                        }
                        //       break;
                        //  case "blue4":
                    } else if (chooseToken.equals("green4")) {
                        if (((greenToken4.getPos().getX() == greenHome[3].getX()) && (greenToken4.getPos().getY() == greenHome[3].getY()))) {
                            movegreen4FromHome();
                            repaint();
                        } else if (((greenToken4.getPos().getX() != greenHome[3].getX()) && (greenToken4.getPos().getY() != greenHome[3].getY()))) {
                            int x;
                            int y;

                            moveIndexgreen4 += roll;
                            if (moveIndexgreen4 <= 39) {
                                x = greenpos[moveIndexgreen4].getX();
                                System.out.println(x + " " + moveIndexgreen4);
                                y = greenpos[moveIndexgreen4].getY();
                                System.out.println(y + " " + moveIndexgreen4);
                                greenToken4.setPos(greenpos[moveIndexgreen4]);
                                System.out.println(greenToken4.toString());
                                gameSquares[x][y].add(greenToken4);
                                repaint();
                            }
                        }
                    }
                    roll = players[countPlayers].rolldice();
                    // break;
                    //default:
                    //       JOptionPane.showMessageDialog(null, "Invalid Token choose");
                }

                if (roll < 6 && (greenToken1.getPos().getX() != greenHome[0].getX()) && (greenToken1.getPos().getY() != greenHome[0].getY()) ||
                        (greenToken2.getPos().getX() != greenHome[1].getX()) && (greenToken2.getPos().getY() != greenHome[1].getY()) ||
                        (greenToken3.getPos().getX() != greenHome[2].getX()) && (greenToken3.getPos().getY() != greenHome[2].getY()) ||
                        (greenToken4.getPos().getX() != greenHome[3].getX()) && (greenToken4.getPos().getY() != greenHome[3].getY())) {
                    String chooseToken = JOptionPane.showInputDialog("please choice a token to move green1,green2,green3,green4").toLowerCase();

                    while (!chooseToken.equals("green1") && !chooseToken.equals("green") && !chooseToken.equals("green3") && !chooseToken.equals("green4")) {
                        chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move green1,green2,green3,green4").toLowerCase();
                    }
                    if (chooseToken.equals("green1")) {
                        if ((greenToken1.getPos().getX() != greenHome[0].getX()) && (greenToken1.getPos().getY() != greenHome[0].getY())) {
                            int x;
                            int y;

                            moveIndexgreen1 += roll;
                            if (moveIndexgreen1 <= 39) {
                                x = greenpos[moveIndexgreen1].getX();
                                System.out.println(x + " " + moveIndexgreen1);
                                y = greenpos[moveIndexgreen1].getY();
                                System.out.println(y + " " + moveIndexgreen1);
                                greenToken1.setPos(greenpos[moveIndexgreen1]);
                                System.out.println(greenToken1.toString());
                                gameSquares[x][y].add(greenToken1);
                                repaint();
                            } else if (moveIndexgreen1 > 39 && moveIndexgreen1 < 43) {
                                x = greenPathHome[moveIndexgreen1 - 40].getX();
                                y = greenPathHome[moveIndexgreen1 - 40].getY();
                                greenToken1.setPos(greenPathHome[moveIndexgreen1]);
                                gameSquares[x][y].add(greenToken1);
                                repaint();
                            }
                            else if(moveIndexgreen1 >= 43)
                            {
                                moveIndexgreen1 = moveIndexgreen1 - roll;
                                if(moveIndexgreen1 <=39)
                                {
                                    x = greenpos[moveIndexgreen1 - 43].getX();
                                    y = greenpos[moveIndexgreen1 - 43].getY();
                                    greenToken1.setPos(greenpos[moveIndexgreen1]);
                                    gameSquares[x][y].add(greenToken1);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexgreen1 >=40)
                                {
                                    x = greenPathHome[moveIndexgreen1 - 43].getX();
                                    y = greenPathHome[moveIndexgreen1 - 43].getY();
                                    greenToken1.setPos(greenPathHome[moveIndexgreen1]);
                                    gameSquares[x][y].add(greenToken1);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("green2")) {
                        if ((greenToken2.getPos().getX() != greenHome[1].getX()) && (greenToken2.getPos().getY() != greenHome[1].getY())) {
                            int x;
                            int y;

                            moveIndexgreen2 += roll;
                            if (moveIndexgreen2 <= 39) {
                                x = greenpos[moveIndexgreen2].getX();
                                System.out.println(x + " " + moveIndexred2);
                                y = greenpos[moveIndexgreen2].getY();
                                System.out.println(y + " " + moveIndexgreen2);
                                greenToken2.setPos(greenpos[moveIndexgreen2]);
                                System.out.println(greenToken2.toString());
                                gameSquares[x][y].add(greenToken2);
                                repaint();
                            } else if (moveIndexgreen2 <= 43) {
                                x = greenPathHome[moveIndexgreen2 - 40].getX();
                                y = greenPathHome[moveIndexgreen2 - 40].getY();
                                greenToken2.setPos(greenPathHome[moveIndexgreen2]);
                                gameSquares[x][y].add(greenToken2);
                                repaint();
                            }
                            else if(moveIndexgreen1 >= 43)
                            {
                                moveIndexgreen2 = moveIndexgreen2 - roll;
                                if(moveIndexgreen2 <=39)
                                {
                                    x = greenpos[moveIndexgreen2 - 43].getX();
                                    y = greenpos[moveIndexgreen2 - 43].getY();
                                    greenToken2.setPos(greenpos[moveIndexgreen2]);
                                    gameSquares[x][y].add(greenToken2);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexgreen2 >=40)
                                {
                                    x = greenPathHome[moveIndexgreen2 - 43].getX();
                                    y = greenPathHome[moveIndexgreen2 - 43].getY();
                                    greenToken2.setPos(greenPathHome[moveIndexgreen2]);
                                    gameSquares[x][y].add(greenToken2);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("green3")) {
                        if ((greenToken3.getPos().getX() != greenHome[2].getX()) && (greenToken3.getPos().getY() != greenHome[2].getY())) {
                            int x;
                            int y;

                            moveIndexgreen3 += roll;
                            if (moveIndexgreen3 <= 39) {
                                x = greenpos[moveIndexgreen3].getX();
                                System.out.println(x + " " + moveIndexgreen3);
                                y = greenpos[moveIndexgreen3].getY();
                                System.out.println(y + " " + moveIndexgreen3);
                                greenToken3.setPos(greenpos[moveIndexgreen3]);
                                System.out.println(greenToken3.toString());
                                gameSquares[x][y].add(greenToken3);
                                repaint();
                            } else if (moveIndexgreen3 <= 43) {
                                x = greenPathHome[moveIndexgreen3 - 40].getX();
                                y = greenPathHome[moveIndexgreen3 - 40].getY();
                                greenToken3.setPos(greenPathHome[moveIndexgreen3]);
                                gameSquares[x][y].add(greenToken3);
                                repaint();
                            }
                            else if(moveIndexgreen3 >= 43)
                            {
                                moveIndexgreen3 = moveIndexgreen3 - roll;
                                if(moveIndexgreen3 <=39)
                                {
                                    x = greenpos[moveIndexgreen3 - 43].getX();
                                    y = greenpos[moveIndexgreen3 - 43].getY();
                                    greenToken3.setPos(greenpos[moveIndexgreen3]);
                                    gameSquares[x][y].add(greenToken3);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexgreen3 >=40)
                                {
                                    x = greenPathHome[moveIndexgreen3 - 43].getX();
                                    y = greenPathHome[moveIndexgreen3 - 43].getY();
                                    greenToken3.setPos(greenPathHome[moveIndexgreen3]);
                                    gameSquares[x][y].add(greenToken3);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("green4")) {
                        if ((greenToken4.getPos().getX() != greenHome[3].getX()) && (greenToken4.getPos().getY() != greenHome[3].getY())) {
                            int x;
                            int y;

                            moveIndexgreen4 += roll;
                            if (moveIndexgreen4 <= 39) {
                                x = greenpos[moveIndexgreen4].getX();
                                System.out.println(x + " " + moveIndexgreen4);
                                y = greenpos[moveIndexgreen4].getY();
                                System.out.println(y + " " + moveIndexgreen4);
                                greenToken4.setPos(greenpos[moveIndexgreen4]);
                                System.out.println(greenToken4.toString());
                                gameSquares[x][y].add(greenToken4);
                                repaint();
                            } else if (moveIndexgreen4 <= 43) {
                                x = greenPathHome[moveIndexgreen4 - 40].getX();
                                y = greenPathHome[moveIndexgreen4 - 40].getY();
                                greenToken4.setPos(greenPathHome[moveIndexgreen4]);
                                gameSquares[x][y].add(greenToken4);
                                repaint();
                            }
                            else if(moveIndexgreen4 >= 43)
                            {
                                moveIndexgreen4 = moveIndexgreen4 - roll;
                                if(moveIndexgreen4 <=39)
                                {
                                    x = greenpos[moveIndexgreen4 - 43].getX();
                                    y = greenpos[moveIndexgreen4 - 43].getY();
                                    greenToken4.setPos(greenpos[moveIndexgreen4]);
                                    gameSquares[x][y].add(greenToken4);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexgreen4 >=40)
                                {
                                    x = greenPathHome[moveIndexgreen4 - 43].getX();
                                    y = greenPathHome[moveIndexgreen4 - 43].getY();
                                    greenToken4.setPos(greenPathHome[moveIndexgreen4]);
                                    gameSquares[x][y].add(greenToken4);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, players[countPlayers] + "Can't move");
            }
            if (players[countPlayers].getTokens().equals(yellowTokens)) {
                while((roll == 6)){ /*&& ((blueToken1.getPos().getX() == blueHome[0].getX()) && (blueToken1.getPos().getY() == blueHome[0].getY())) ||
                        ((blueToken2.getPos().getX() == blueHome[1].getX()) && (blueToken2.getPos().getY() == blueHome[1].getY())) ||
                        ((blueToken3.getPos().getX() == blueHome[2].getX()) && (blueToken3.getPos().getY() == blueHome[2].getY())) ||
                        ((blueToken4.getPos().getX() == blueHome[3].getX()) && (blueToken4.getPos().getY() == blueHome[3].getY()))) {*/

                    String chooseToken = JOptionPane.showInputDialog("please choice a token to move yellow1,yellow2,yellow3,yellow4").toLowerCase();

                    while (!chooseToken.equals("yellow1") && !chooseToken.equals("yellow2") && !chooseToken.equals("yellow3") && !chooseToken.equals("yellow4")) {
                        chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move yellow1,yellow2,yellow3,yellow4").toLowerCase();
                    }
                    if (chooseToken.equals("yellow1")) {
                        if (((yellowToken1.getPos().getX() == yellowHome[0].getX()) && (yellowToken1.getPos().getY() == yellowHome[0].getY()))) {
                            moveyellow1FromHome();
                            repaint();
                        } else if (((yellowToken1.getPos().getX() != yellowHome[0].getX()) && (yellowToken1.getPos().getY() != yellowHome[0].getY()))) {
                            int x;
                            int y;

                            moveIndexyellow1 += roll;
                            if (moveIndexyellow1 <= 39) {
                                x = yellowpos[moveIndexyellow1].getX();
                                System.out.println(x + " " + moveIndexyellow1);
                                y = yellowpos[moveIndexyellow1].getY();
                                System.out.println(y + " " + moveIndexyellow1);
                                yellowToken1.setPos(yellowpos[moveIndexyellow1]);
                                System.out.println(yellowToken1.toString());
                                gameSquares[x][y].add(yellowToken1);
                                repaint();
                            }
                        }
                    }
                    else if (chooseToken.equals("yellow2")) {
                        if (((yellowToken2.getPos().getX() == yellowHome[1].getX()) && (yellowToken2.getPos().getY() == yellowHome[1].getY()))) {
                            moveyellow2FromHome();
                            repaint();
                        } else if (((yellowToken2.getPos().getX() != yellowHome[1].getX()) && (yellowToken2.getPos().getY() != yellowHome[1].getY()))) {
                            int x;
                            int y;

                            moveIndexyellow2 += roll;
                            if (moveIndexyellow2 <= 39) {
                                x = yellowpos[moveIndexyellow2].getX();
                                System.out.println(x + " " + moveIndexyellow2);
                                y = yellowpos[moveIndexyellow2].getY();
                                System.out.println(y + " " + moveIndexyellow2);
                                greenToken2.setPos(yellowpos[moveIndexyellow2]);
                                System.out.println(yellowToken2.toString());
                                gameSquares[x][y].add(yellowToken2);
                                repaint();
                            }
                        }
                        }
                        else if (chooseToken.equals("yellow3")) {
                        if (((yellowToken3.getPos().getX() ==yellowHome[2].getX()) && (yellowToken3.getPos().getY() == yellowHome[2].getY()))) {
                            moveyellow3FromHome();
                            repaint();
                        } else if (((yellowToken3.getPos().getX() != yellowHome[2].getX()) && (yellowToken3.getPos().getY() != yellowHome[2].getY()))) {
                            int x;
                            int y;

                            moveIndexyellow3 += roll;
                            if (moveIndexyellow3 <= 39) {
                                x = yellowpos[moveIndexyellow3].getX();
                                System.out.println(x + " " + moveIndexyellow3);
                                y = yellowpos[moveIndexyellow3].getY();
                                System.out.println(y + " " + moveIndexyellow3);
                                yellowToken3.setPos(yellowpos[moveIndexyellow3]);
                                System.out.println(yellowToken3.toString());
                                gameSquares[x][y].add(yellowToken3);
                                repaint();
                            }
                        }
                    } else if (chooseToken.equals("yellow4")) {
                        if (((yellowToken4.getPos().getX() == yellowHome[3].getX()) && (yellowToken4.getPos().getY() == yellowHome[3].getY()))) {
                            moveyellow4FromHome();
                            repaint();
                        } else if (((yellowToken4.getPos().getX() != yellowHome[3].getX()) && (yellowToken4.getPos().getY() != yellowHome[3].getY()))) {
                            int x;
                            int y;

                            moveIndexyellow4 += roll;
                            if (moveIndexyellow4 <= 39) {
                                x = yellowpos[moveIndexyellow4].getX();
                                System.out.println(x + " " + moveIndexyellow4);
                                y = yellowpos[moveIndexyellow4].getY();
                                System.out.println(y + " " + moveIndexyellow4);
                                yellowToken4.setPos(yellowpos[moveIndexyellow4]);
                                System.out.println(yellowToken4.toString());
                                gameSquares[x][y].add(yellowToken4);
                                repaint();
                            }
                        }
                    }
                    roll = players[countPlayers].rolldice();
                }

                if (roll < 6 && (yellowToken1.getPos().getX() != yellowHome[0].getX()) && (yellowToken1.getPos().getY() != yellowHome[0].getY()) ||
                        (yellowToken2.getPos().getX() !=yellowHome[1].getX()) && (yellowToken2.getPos().getY() != yellowHome[1].getY()) ||
                        (yellowToken3.getPos().getX() != yellowHome[2].getX()) && (yellowToken3.getPos().getY() != yellowHome[2].getY()) ||
                        (yellowToken4.getPos().getX() != yellowHome[3].getX()) && (yellowToken4.getPos().getY() != yellowHome[3].getY())) {
                    String chooseToken = JOptionPane.showInputDialog("please choice a token to move yellow1,yellow2,yellow3,yellow4").toLowerCase();

                    while (!chooseToken.equals("yellow1") && !chooseToken.equals("yellow2") && !chooseToken.equals("yellow3") && !chooseToken.equals("yellow4")) {
                        chooseToken = JOptionPane.showInputDialog("Invalid choice!! please choice a token to move yellow1,yellow2,yellow3,yellow4").toLowerCase();
                    }
                    if (chooseToken.equals("yellow")) {
                        if ((yellowToken1.getPos().getX() != yellowHome[0].getX()) && (yellowToken1.getPos().getY() != yellowHome[0].getY())) {
                            int x;
                            int y;

                            moveIndexyellow1 += roll;
                            if (moveIndexyellow1 <= 39) {
                                x = yellowpos[moveIndexyellow1].getX();
                                System.out.println(x + " " + moveIndexyellow1);
                                y = yellowpos[moveIndexyellow1].getY();
                                System.out.println(y + " " + moveIndexyellow1);
                                yellowToken1.setPos(yellowpos[moveIndexyellow1]);
                                System.out.println(yellowToken1.toString());
                                gameSquares[x][y].add(yellowToken1);
                                repaint();
                            } else if (moveIndexyellow1 > 39 && moveIndexyellow1 < 43) {
                                x = yellowPathHome[moveIndexyellow1 - 40].getX();
                                y = yellowPathHome[moveIndexyellow1 - 40].getY();
                                yellowToken1.setPos(yellowPathHome[moveIndexyellow1]);
                                gameSquares[x][y].add(yellowToken1);
                                repaint();
                            }
                            else if(moveIndexyellow1 >= 43)
                            {
                                moveIndexyellow1 = moveIndexyellow1 - roll;
                                if(moveIndexyellow1 <=39)
                                {
                                    x = yellowpos[moveIndexyellow1 - 43].getX();
                                    y = yellowpos[moveIndexyellow1 - 43].getY();
                                    yellowToken1.setPos(yellowpos[moveIndexyellow1]);
                                    gameSquares[x][y].add(yellowToken1);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexyellow1 >=40)
                                {
                                    x = yellowPathHome[moveIndexyellow1 - 43].getX();
                                    y = yellowPathHome[moveIndexyellow1 - 43].getY();
                                    yellowToken1.setPos(yellowPathHome[moveIndexyellow1]);
                                    gameSquares[x][y].add(yellowToken1);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("yellow2")) {
                        if ((yellowToken2.getPos().getX() != yellowHome[1].getX()) && (yellowToken2.getPos().getY() != yellowHome[1].getY())) {
                            int x;
                            int y;

                            moveIndexyellow2 += roll;
                            if (moveIndexgreen2 <= 39) {
                                x = yellowpos[moveIndexyellow2].getX();
                                System.out.println(x + " " + moveIndexred2);
                                y = yellowpos[moveIndexyellow2].getY();
                                System.out.println(y + " " + moveIndexyellow2);
                                yellowToken2.setPos(greenpos[moveIndexyellow2]);
                                System.out.println(yellowToken2.toString());
                                gameSquares[x][y].add(yellowToken2);
                                repaint();
                            } else if (moveIndexyellow2 <= 43) {
                                x = yellowPathHome[moveIndexyellow2 - 40].getX();
                                y = yellowPathHome[moveIndexyellow2 - 40].getY();
                                yellowToken2.setPos(yellowPathHome[moveIndexyellow2]);
                                gameSquares[x][y].add(yellowToken2);
                                repaint();
                            }
                            else if(moveIndexyellow1 >= 43)
                            {
                                moveIndexyellow2 = moveIndexyellow2 - roll;
                                if(moveIndexyellow2 <=39)
                                {
                                    x = yellowpos[moveIndexyellow2 - 43].getX();
                                    y = yellowpos[moveIndexyellow2 - 43].getY();
                                    yellowToken2.setPos(yellowpos[moveIndexyellow2]);
                                    gameSquares[x][y].add(yellowToken2);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexyellow2 >=40)
                                {
                                    x = yellowPathHome[moveIndexyellow2 - 43].getX();
                                    y = yellowPathHome[moveIndexyellow2 - 43].getY();
                                    yellowToken2.setPos(yellowPathHome[moveIndexyellow2]);
                                    gameSquares[x][y].add(yellowToken2);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("yellow3")) {
                        if ((yellowToken3.getPos().getX() != yellowHome[2].getX()) && (yellowToken3.getPos().getY() != yellowHome[2].getY())) {
                            int x;
                            int y;

                            moveIndexyellow3 += roll;
                            if (moveIndexyellow3 <= 39) {
                                x = yellowpos[moveIndexyellow3].getX();
                                System.out.println(x + " " + moveIndexyellow3);
                                y = yellowpos[moveIndexyellow3].getY();
                                System.out.println(y + " " + moveIndexyellow3);
                                yellowToken3.setPos(yellowpos[moveIndexyellow3]);
                                System.out.println(yellowToken3.toString());
                                gameSquares[x][y].add(yellowToken3);
                                repaint();
                            } else if (moveIndexyellow3 <= 43) {
                                x = yellowPathHome[moveIndexyellow3 - 40].getX();
                                y = yellowPathHome[moveIndexyellow3 - 40].getY();
                                yellowToken3.setPos(yellowPathHome[moveIndexyellow3]);
                                gameSquares[x][y].add(yellowToken3);
                                repaint();
                            }
                            else if(moveIndexyellow3 >= 43)
                            {
                                moveIndexyellow3 = moveIndexyellow3 - roll;
                                if(moveIndexyellow3 <=39)
                                {
                                    x = yellowpos[moveIndexyellow3 - 43].getX();
                                    y = yellowpos[moveIndexyellow3 - 43].getY();
                                    yellowToken3.setPos(yellowpos[moveIndexyellow3]);
                                    gameSquares[x][y].add(yellowToken3);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexgreen3 >=40)
                                {
                                    x = greenPathHome[moveIndexgreen3 - 43].getX();
                                    y = greenPathHome[moveIndexgreen3 - 43].getY();
                                    greenToken3.setPos(greenPathHome[moveIndexgreen3]);
                                    gameSquares[x][y].add(greenToken3);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    } else if (chooseToken.equals("yellow4")) {
                        if ((yellowToken4.getPos().getX() != yellowHome[3].getX()) && (yellowToken4.getPos().getY() != yellowHome[3].getY())) {
                            int x;
                            int y;

                            moveIndexyellow4 += roll;
                            if (moveIndexyellow4 <= 39) {
                                x = yellowpos[moveIndexyellow4].getX();
                                System.out.println(x + " " + moveIndexyellow4);
                                y = yellowpos[moveIndexyellow4].getY();
                                System.out.println(y + " " + moveIndexyellow4);
                                yellowToken4.setPos(yellowpos[moveIndexyellow4]);
                                System.out.println(yellowToken4.toString());
                                gameSquares[x][y].add(yellowToken4);
                                repaint();
                            } else if (moveIndexyellow4 <= 43) {
                                x = yellowPathHome[moveIndexyellow4 - 40].getX();
                                y = yellowPathHome[moveIndexyellow4 - 40].getY();
                                yellowToken4.setPos(yellowPathHome[moveIndexyellow4]);
                                gameSquares[x][y].add(yellowToken4);
                                repaint();
                            }
                            else if(moveIndexyellow4 >= 43)
                            {
                                moveIndexyellow4 = moveIndexyellow4 - roll;
                                if(moveIndexyellow4 <=39)
                                {
                                    x = yellowpos[moveIndexyellow4 - 43].getX();
                                    y = yellowpos[moveIndexyellow4 - 43].getY();
                                    yellowToken4.setPos(yellowpos[moveIndexyellow4]);
                                    gameSquares[x][y].add(yellowToken4);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                                else if(moveIndexyellow4 >=40)
                                {
                                    x = yellowPathHome[moveIndexyellow4 - 43].getX();
                                    y = yellowPathHome[moveIndexyellow4 - 43].getY();
                                    yellowToken4.setPos(yellowPathHome[moveIndexyellow4]);
                                    gameSquares[x][y].add(yellowToken4);
                                    repaint();
                                    JOptionPane.showMessageDialog(null,"Sorry cant move!! Turn over");
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, "Can't move that piece!! Sorry turn over");
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, players[countPlayers] + "Can't move");
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
    Component moveBlue1FromHome()
    {
            blueToken1.setPos(bluepos[0]);

        return gameSquares[bluepos[0].getX()][bluepos[0].getY()].add(blueToken1);
    }
    Component moveBlue2FromHome()
    {
        blueToken2.setPos(bluepos[0]);

        return gameSquares[bluepos[0].getX()][bluepos[0].getY()].add(blueToken2);
    }
    Component moveBlue3FromHome()
    {
        blueToken3.setPos(bluepos[0]);

        return gameSquares[bluepos[0].getX()][bluepos[0].getY()].add(blueToken3);
    }
    Component moveBlue4FromHome()
    {
        blueToken4.setPos(bluepos[0]);

        return gameSquares[bluepos[0].getX()][bluepos[0].getY()].add(blueToken4);
    }
    Component movered1FromHome()
    {
        redToken1.setPos(redpos[0]);

        return gameSquares[redpos[0].getX()][redpos[0].getY()].add(redToken1);
    }
    Component movered2FromHome()
    {
        redToken2.setPos(redpos[0]);

        return gameSquares[redpos[0].getX()][redpos[0].getY()].add(redToken2);
    }
    Component movered3FromHome()
    {
        redToken3.setPos(redpos[0]);

        return gameSquares[redpos[0].getX()][redpos[0].getY()].add(redToken3);
    }
    Component movered4FromHome()
    {
        redToken4.setPos(redpos[0]);

        return gameSquares[redpos[0].getX()][redpos[0].getY()].add(redToken4);
    }
    Component movegreen1FromHome()
    {
        greenToken1.setPos(redpos[0]);

        return gameSquares[redpos[0].getX()][redpos[0].getY()].add(greenToken1);
    }
    Component movegreen2FromHome()
    {
        greenToken2.setPos(greenpos[0]);

        return gameSquares[greenpos[0].getX()][greenpos[0].getY()].add(greenToken2);
    }
    Component movegreen3FromHome()
    {
        greenToken3.setPos(greenpos[0]);

        return gameSquares[greenpos[0].getX()][greenpos[0].getY()].add(greenToken3);
    }
    Component movegreen4FromHome()
    {
        greenToken4.setPos(greenpos[0]);

        return gameSquares[greenpos[0].getX()][greenpos[0].getY()].add(greenToken4);
    }
    Component moveyellow1FromHome()
    {
        yellowToken1.setPos(yellowpos[0]);

        return gameSquares[yellowpos[0].getX()][yellowpos[0].getY()].add(yellowToken1);
    }
    Component moveyellow2FromHome()
    {
        yellowToken2.setPos(yellowpos[0]);

        return gameSquares[yellowpos[0].getX()][yellowpos[0].getY()].add(yellowToken2);
    }
    Component moveyellow3FromHome()
    {
        yellowToken3.setPos(yellowpos[0]);

        return gameSquares[yellowpos[0].getX()][yellowpos[0].getY()].add(yellowToken3);
    }
    Component moveyellow4FromHome()
    {
        yellowToken4.setPos(yellowpos[0]);

        return gameSquares[yellowpos[0].getX()][yellowpos[0].getY()].add(yellowToken4);
    }


}

