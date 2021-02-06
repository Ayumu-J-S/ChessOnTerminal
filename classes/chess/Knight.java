package chess;

/**
 * This class is the extention from the Piece class, which acts as Knight on
 * chess Board.
 *
 * @author Ayumu Saito 
 */
public class Knight extends Piece {

    /**
     * Constructor for the Knight object.
     *
     * @param b Board that this piece is on
     * @param colour true for white, false for black
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     */
    public Knight(Board b, boolean colour, int vertical, int horizontal) {
        super(b, colour, vertical, horizontal);
    }

    /**
     * Checks if the move is valid for this piece.Knight can move 1 column and 2
     * rows in any direction or alternatively 2 columns and 1 row in any
     * direction.
     *
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     * @return true if the move if valid, false if not
     */
    @Override
    public boolean isValidMove(int vertical, int horizontal) {
        //declare variable
        boolean isValid = false;

        //checks if the input is valid
        if (Math.abs(super.vertical - vertical) == 1
                && Math.abs(super.horizontal - horizontal) == 2)
                /*if vertical is 1 coordiante ahead or back and 
                  horizontal is two coordinate right or left */ {

            isValid = true;

        } else if (Math.abs(super.horizontal - horizontal) == 1
                && Math.abs(super.vertical - vertical) == 2) 
                /*if the vertical is 2 coordiantes ahead or back and
                   horizontal is one coordinate ahead or back*/ {

            isValid = true;

        }

        return isValid;

    }

    /**
     * Getter method for the Symbol of this piece.
     *
     * @return uppercase symbol if colour boolean is true, lowercase if not.
     */
    @Override
    public char getSymbol() {
        if (super.colour == true) {
            return 'N';
        } else {
            return 'n';
        }
    }
}
