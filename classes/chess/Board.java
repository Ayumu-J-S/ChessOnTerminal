package chess;

import java.io.PrintWriter;

/**
 * This class represents the board that the pieces are on.
 *
 * @author Ayumu Saito 
 */
public class Board {

    //Declare Piece array 
    protected Piece[][] pieces;

    //Declare boolean white and black
    //and one boolean varibale to keep track of whose turn it is
    private boolean white = true;
    private boolean black = false;
    protected boolean isWhiteTurn = true;

    /**
     * Constructor for the Board Object.
     */
    public Board() {
        //Initialize the size of Piece array
        pieces = new Piece[8][8];

        //Put Piece object on the starting location
        pieces[0][0] = new Rook(this, black, 0, 0);
        pieces[0][1] = new Knight(this, black, 0, 1);
        pieces[0][2] = new Bishop(this, black, 0, 2);
        pieces[0][3] = new Queen(this, black, 0, 3);
        pieces[0][4] = new King(this, black, 0, 4);
        pieces[0][5] = new Bishop(this, black, 0, 5);
        pieces[0][6] = new Knight(this, black, 0, 6);
        pieces[0][7] = new Rook(this, black, 0, 7);
        pieces[7][0] = new Rook(this, white, 7, 0);
        pieces[7][1] = new Knight(this, white, 7, 1);
        pieces[7][2] = new Bishop(this, white, 7, 2);
        pieces[7][3] = new Queen(this, white, 7, 3);
        pieces[7][4] = new King(this, white, 7, 4);
        pieces[7][5] = new Bishop(this, white, 5, 5);
        pieces[7][6] = new Knight(this, white, 7, 6);
        pieces[7][7] = new Rook(this, white, 7, 7);

        //Put black Pawns on the second line
        for (int i = 0; i < pieces[1].length; i++) {
            pieces[1][i] = new Pawn(this, black, 1, i);
        }

        //put white Pawns on the 7th line
        for (int i = 0; i < pieces[1].length; i++) {
            pieces[6][i] = new Pawn(this, white, 6, i);
        }
    }

    /**
     * getter method for the protected variable isWhiteTurn.
     *
     * @return true if it is white turn, false if black turn
     */
    public boolean getIsWhiteTurn() {
        return isWhiteTurn;
    }

    /**
     * method for displaying the board
     */
    public void display() {
        //declare and initialilze the row number  
        int rowNum = 1;

        System.out.println("");

        //display colum numbers and a line under them
        for (int i = 1; i <= pieces.length; i++) {
            System.out.print((i == 1) ? "    " + i : "   " + i);
        }
        System.out.println("");

        System.out.println("  ---------------------------------");

        //display the pieces 
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 1; j <= pieces[i].length + 1; j++) {
                if (j == 1) {
                    //display the row numbers
                    System.out.print(rowNum + " ");
                    rowNum++;
                } else {
                    System.out.print("|");
                    if (pieces[i][j - 2] == null) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" "
                                + pieces[i][j - 2].getSymbol() + " ");
                    }
                }
            }
            System.out.println("|");
            System.out.println("  ---------------------------------");
        }
    }

    public void display(PrintWriter out) {
        //declare and initialilze the row number  
        int rowNum = 1;

        out.println("");

        //display colum numbers and a line under them
        for (int i = 1; i <= pieces.length; i++) {
            out.print((i == 1) ? "    " + i : "   " + i);
        }
        out.println("");

        out.println("  ---------------------------------");

        //display the pieces 
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 1; j <= pieces[i].length + 1; j++) {
                if (j == 1) {
                    //display the row numbers
                    out.print(rowNum + " ");
                    rowNum++;
                } else {
                    out.print("|");
                    if (pieces[i][j - 2] == null) {
                        out.print("   ");
                    } else {
                        out.print(" "
                                + pieces[i][j - 2].getSymbol() + " ");
                    }
                }
            }
            out.println("|");
            out.println("  ---------------------------------");
        }

    }

    /**
     * Method to move a piece from one coordinate to another.
     *
     * @param x1 the current column coordinate of the piece
     * @param y1 the current row coordinate of the piece
     * @param x2 the column coordinate of the place user want to move piece to
     * @param y2 the raw coordinate of the place user want to move piece to
     * @throws chess.OffBoardException
     * @throws chess.NoPieceException
     * @throws chess.WrongTurnException
     * @throws chess.SelfCaptureException
     * @throws chess.InvalidMoveException
     */
    public void move(int x1, int y1, int x2, int y2) throws ChessException {
        //check if values are valid, and if so move the piece to new place
        //if not throw appropirate Exception
        if (x1 < 1 || x1 > 8 || x2 < 1 || x2 > 8 || y1 < 1 || y1 > 8
                || y2 < 1 || x2 > 8) {

            throw new OffBoardException("At least one coordinate was invalid");

        } else if (pieces[y1 - 1][x1 - 1] == null) {

            throw new NoPieceException("There is no piece at " + x1 + " " + y1);

        } else if (pieces[y1 - 1][x1 - 1].colour != isWhiteTurn) {

            throw new WrongTurnException((isWhiteTurn)
                    ? "It is not black's turn to move."
                    : "It is not white's turn to move.");

        } else if (pieces[y2 - 1][x2 - 1] != null
                && pieces[y1 - 1][x1 - 1].colour
                == pieces[y2 - 1][x2 - 1].colour) {

            throw new SelfCaptureException("There is already a "
                    + ((isWhiteTurn) ? "white" : " black")
                    + " piece there.");

        } else {
            pieces[y1 - 1][x1 - 1].move(y2 - 1, x2 - 1);
            if (this.isWhiteTurn == true) {
                isWhiteTurn = false;
            } else {
                isWhiteTurn = true;
            }
        }
    }
}
