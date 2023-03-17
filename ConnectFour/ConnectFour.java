package ConnectFour;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ConnectFour extends JFrame {

    private int size; // Board size
    private int playerOrder = 0; // First player 1 will play the game
    private int numberOfPlayer; // Player number
    private static int livingCellNumber = 0; // Number of living cells

    private final JFrame frame; // Frame
    private final JPanel panel; // Panel
    private final JButton[][] buttons; // Buttons
    private Cell gameBoard[][]; // Game Board
    private final GridLayout grid; // GridLayout

    ImageIcon empty = new ImageIcon("Images/emptycell.png");
    ImageIcon player1 = new ImageIcon("Images/player1.png");
    ImageIcon player2 = new ImageIcon("Images/player2.png");



    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
    }

    public ConnectFour() {
        frame = new JFrame("Connect Four Game");
        panel = new JPanel();

        playerNumberAndBoardSize(); // Get the game parameters
        dynamicAllocation(); // Create 2D dynamic Cell array

        buttons = new JButton[getBoardSize()][getBoardSize()]; // Button als Array
        grid = new GridLayout(getBoardSize(), getBoardSize()); // Erzeugt Gridlayout
        panel.setLayout(grid);

        // Initialization board
        initialBoard();

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }


    public void setBoardSize(int newSize) {
        size = newSize;
    }

    public int getBoardSize() {
        return size;
    }

    public static int numberOfLivingCells() {
        return livingCellNumber;
    }

    /**
     * Get the player number and board size from the user
     */
    public void playerNumberAndBoardSize() {
        // User inputs from input dialogs
        String playerNumber = JOptionPane.showInputDialog("Spieler Anzahl (1 oder 2)");
        String boardSize = JOptionPane.showInputDialog("Spielfeldgröße (mind. 4) ");

       
        numberOfPlayer = Integer.parseInt(playerNumber); //Anzahl der Spieler

        int sizeOfBoard = Integer.parseInt(boardSize);      //Größe des Feldes

        if (sizeOfBoard < 4) {
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Spielfeld muss größer sein als 4 !!!",
                    "Spiel Feld Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        setBoardSize(sizeOfBoard); 
    }

    
    public void dynamicAllocation() {   //Spielfeld als 2d Array
        gameBoard = new Cell[getBoardSize()][getBoardSize()];
        for (int i = 0; i < getBoardSize(); i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                gameBoard[i][j] = new Cell();
            }
        }
    }

    /**
     * Add buttons to game board
     */
    public void addButtonsToBoard() {
        for (int i = 0; i < getBoardSize(); ++i) {
            for (int j = 0; j < getBoardSize(); ++j) {
                buttons[i][j] = new JButton(empty); // Empty button

                if (numberOfPlayer == 1) // Computer vs Spieler 
                {
                    buttons[i][j].addActionListener(new listenButtonOnePlayer());
                }

                if (numberOfPlayer == 2) // Spieler vs Spieler
                {
                    buttons[i][j].addActionListener(new listenButtonTwoPlayers());
                }

                panel.add(buttons[i][j]); // Add buttons to panel
            }
        }
    }

    /**
     * Initial all cells to empty
     */
    public void initialBoard() {
        for (int i = getBoardSize() - 2; i >= 0; --i) {
            for (int j = getBoardSize() - 1; j >= 0; --j) {
                gameBoard[i][j].setCellState(-99);
            }
        }
        addButtonsToBoard(); // Add buttons and listener
    }

    /**
     * Game winning state
     * If the four cell is same, user 1 will win the game
     * 
     * @param winner integer If the player 1 is equal to 1, otherwise 2
     */
    public void winnerPlayer(int winner) {
        for (int i = 0; i < getBoardSize(); ++i) {
            for (int j = 0; j < getBoardSize(); ++j) {

                if (gameBoard[i][j].getCellState() == winner) {     
                    if (i + 3 < getBoardSize()) {       //Ob Zellen überhaupt da sind
                        if (gameBoard[i + 1][j].getCellState() == winner && gameBoard[i + 2][j].getCellState() == winner
                                && gameBoard[i + 3][j].getCellState() == winner) {  //Von oben nach unten
                            if (winner == 1)        //1 bedeutet Spieler 1
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }

                    if (j + 3 < getBoardSize()) {     // Ob Zellen überhaupt da sind   
                        if (gameBoard[i][j + 1].getCellState() == winner && gameBoard[i][j + 2].getCellState() == winner
                                && gameBoard[i][j + 3].getCellState() == winner) {      //Von Links nach Rechts
                            if (winner == 1)
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }

                    if (i < getBoardSize() - 3 && j < getBoardSize() - 3) {         // Ob Zellen überhaupt da sind
                        if (gameBoard[i + 1][j + 1].getCellState() == winner
                                && gameBoard[i + 2][j + 2].getCellState() == winner
                                && gameBoard[i + 3][j + 3].getCellState() == winner) {      //Diagonale Links nach Rechts
                            if (winner == 1)
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }

                    if (i < getBoardSize() - 3 && j - 3 >= 0) {      // Ob Zellen überhaupt da sind  
                        if (gameBoard[i + 1][j - 1].getCellState() == winner
                                && gameBoard[i + 2][j - 2].getCellState() == winner
                                && gameBoard[i + 3][j - 3].getCellState() == winner) {      //Diagonale Rechts nach Links
                            if (winner == 1)
                                showResult(1);
                            else
                                showResult(2);
                        }
                    }
                }
            }
        }
    } 


    public void showResult(int winnerPlayer) {
        JFrame frameShowResult = new JFrame();      //Neuer Gewinnerframe
        if (winnerPlayer == 1) {
            JOptionPane.showMessageDialog(frameShowResult,
                    "\nGewinner : Spieler 1\n\nDas neue Spiel Startet.\n\n",
                    "Spiel Benden",
                    JOptionPane.INFORMATION_MESSAGE);
            startAgain();
        } else {
            JOptionPane.showMessageDialog(frameShowResult,
                    "\nGewinner : Spieler 2\n\nDas neue Spiel Startet.\n\n",
                    "Spiel Benden",
                    JOptionPane.INFORMATION_MESSAGE);
            startAgain();
        }
    }


    public void startAgain() {
        for (int i = 0; i < getBoardSize(); ++i) {
            for (int j = 0; j < getBoardSize(); ++j) {
                gameBoard[i][j].setCellState(-99); // Initial Value
                buttons[i][j].setIcon(empty); // Put the empty cell icon
            }
        }

        frame.setVisible(false); // Unvisible previous game board
        ConnectFour newGame = new ConnectFour(); // New Game Object
    }

    /**
     *
     * Action listener to game button
     * Computer vs Player 1
     */
    private class listenButtonOnePlayer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                for (int i = getBoardSize() - 1; i >= 0; --i) // Check the buttons up to down position
                {
                    for (int j = 0; j <= getBoardSize() - 1; ++j) {
                        // Get the button component that was clicked
                        if (buttons[i][j] == e.getSource()) {

                            if (0 == playerOrder % 2) // Player 1 operations
                            {
                                for (int k = 0; k <= getBoardSize(); ++i) {
                                    // Player 1 Operations
                                    // Fill the board from down to up
                                    if (gameBoard[i - k][j].getCellState() == 0) {
                                        buttons[i - k][j].setIcon(player1); // Change button icon
                                        gameBoard[i - k][j].setAllPosition('X', i); // Set cell parameters
                                        gameBoard[i - k][j].setCellState(1); // Set cell state
                                        ++livingCellNumber; // Increase living cell number
                                        winnerPlayer(1); // Check game winning state
                                        break;
                                    }
                                }

                                setUpperCellToEmpty(i, j); // Set the upper cells to empty cell to listen button
                                System.out.println("... Player 1 played ... ");
                                ++playerOrder; // Change player order from player 1 to computer
                                break;
                            }

                            // Computer Operations
                            // Basic idea is filling the cells left to right

                            if (1 == playerOrder % 2) {
                                moveComputer(i);
                                System.out.println("... Computer played ... ");
                                ++playerOrder; // Change player order from computer to player 1
                                break;
                            } else {
                                warningMessage();
                            }
                        } // END EVENT SOURCE
                    } // END SECOND FOR LOOP
                } // END FIRST FOR LOOP

            } // END TRY
            catch (Exception ex) {
                warningMessage();
            }
        } // END ACTION PERFORMED

    } // END listenButtonOnePlayer CLASS

    public void warningMessage() {
        JFrame frameWarning = new JFrame();
        JOptionPane.showMessageDialog(frameWarning,
                "Invalid Movement !!\nThe cell is not empty.", "Warning",
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Set the upper cells to empty cell to listen button
     * 
     * @param rowPos    integer row position to board
     * @param columnPos integer column position to board
     */
    public void setUpperCellToEmpty(int rowPos, int columnPos) {
        try {
            gameBoard[rowPos - 1][columnPos].setCellState(0);
        } catch (Exception ex) {
        }
    }

    /**
     * Computer's logic fills cells from left to right
     * 
     * @param rowPosition Cell row position
     */
    public void moveComputer(int rowPosition) {
        int l, m;
        boolean flag = false;

        for (l = getBoardSize() - 1; (l >= 0) && !flag; --l) {
            for (m = 0; (m < getBoardSize()) && !flag; ++m) {
                if (gameBoard[l][m].getCellState() == 0) {
                    buttons[l][m].setIcon(player2); // Set new button icon
                    gameBoard[l][m].setAllPosition('O', rowPosition); // Set cell parameters
                    gameBoard[l][m].setCellState(2); // Set cell state
                    ++livingCellNumber;
                    winnerPlayer(2); // Check the computer winning state
                    flag = true;
                    setUpperCellToEmpty(l, m);
                }
            }
        }
    }

    /**
     * Action listener to game button
     * Player 1 vs Player 2
     */
    private class listenButtonTwoPlayers implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int eventFlag = 0;
                int flagPlayerOrder = 0;

                for (int i = getBoardSize() - 1; i >= 0; --i) {
                    for (int j = 0; j <= getBoardSize() - 1; ++j) {
                        if (eventFlag == 0 && buttons[i][j] == e.getSource()) // Get the button component that was
                                                                              // clicked
                        {
                            if (flagPlayerOrder == 0 && playerOrder % 2 == 0) {
                                // Player 1 Operations
                                // Fill the board from down to up
                                for (int k = 0; k <= getBoardSize(); ++i) {
                                    if (gameBoard[i - k][j].getCellState() == 0 && playerOrder % 2 == 0) {
                                        buttons[i - k][j].setIcon(player1); // Set new icon to player 1
                                        gameBoard[i - k][j].setAllPosition('X', i); // Set cell parameters
                                        gameBoard[i - k][j].setCellState(1);
                                        ++livingCellNumber; // Increase living cell number
                                        winnerPlayer(1); // Check player 1 winning state
                                        flagPlayerOrder = 1;
                                        eventFlag = 1;
                                        break;
                                    }
                                }

                                setUpperCellToEmpty(i, j); // Set upper cell to empty
                                System.out.println("... Player 1 played ... ");
                                ++playerOrder; // Change order from player 1 to player 2
                                break;
                            }

                            // Player 2 operations
                            if (flagPlayerOrder == 0 && playerOrder % 2 == 1) {
                                for (int k = 0; k <= getBoardSize(); ++i) {
                                    if (gameBoard[i - k][j].getCellState() == 0 && playerOrder % 2 == 1) {
                                        buttons[i - k][j].setIcon(player2); // Set new icon to player 2
                                        gameBoard[i - k][j].setAllPosition('O', i); // Set cell parameters
                                        gameBoard[i - k][j].setCellState(2); // Set cell state
                                        ++livingCellNumber;
                                        winnerPlayer(2);
                                        flagPlayerOrder = 1;
                                        eventFlag = 1;
                                        break;
                                    }
                                }
                                setUpperCellToEmpty(i, j);
                                System.out.println("... Player 2 played ... ");
                                ++playerOrder;
                                break;
                            }
                        } // END EVENT SOURCE
                    } // END SECOND FOR LOOP
                } // END FIRST FOR LOOP
            } catch (Exception ex) {
                warningMessage();
            }

        } // END ACTIONPERFORMED
    } // END listenButtonTwoPlayers CLASS
} // END CONNECTFOUR CLASS
