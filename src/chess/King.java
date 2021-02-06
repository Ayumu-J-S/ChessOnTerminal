package chess;

/**
 * This class is the extention from the Piece class, which acts as King on chess
 * Board.
 *
 * @author Ayumu Saito 
 */
public class King extends Piece {

    /**
     * Constructor for the King object.
     *
     * @param b Board that this piece is on
     * @param colour true for white, false for black
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     */
    public King(Board b, boolean colour, int vertical, int horizontal) {
        super(b, colour, vertical, horizontal);
    }

    /**
     * Checks if the move is valid for this piece. It can move one square in any
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

        //checks if the parameters are valid
        if (Math.abs(super.vertical - vertical) <= 1) {
            if (Math.abs(super.horizontal - horizontal) <= 1) {
                isValid = true;
            }
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
            return 'K';
        } else {
            return 'k';
        }
    }
}
