package chess;

/**
 * This class is the extention from the Piece class, which acts as Queen on
 * chess Board.
 *
 * @author Ayumu Saito
 */
public class Queen extends Piece {

    /**
     * Constructor for the Queen object.
     *
     * @param b Board that this piece is on
     * @param colour true for white, false for black
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     */
    public Queen(Board b, boolean colour, int vertical, int horizontal) {
        super(b, colour, vertical, horizontal);
    }

    /**
     * Checks if the move is valid for this piece. It can make any valid move a
     * Rook can or any valid move a Bishop can.
     *
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     * @return true if the move if valid, false if not
     */
    @Override
    public boolean isValidMove(int vertical, int horizontal) {
        
        /*create Bishop object and the Rook object containg the exact same 
        information as the current Queen object*/
        Bishop b = new Bishop(super.b, super.colour, super.vertical,
                super.horizontal);
        Rook r = new Rook(super.b, super.colour, super.vertical,
                super.horizontal);

        //checks if the move is the valid move of either Bishop or Rook
        if (r.isValidMove(vertical, horizontal)
                || b.isValidMove(vertical, horizontal)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Getter method for the Symbol of this piece.
     *
     * @return uppercase symbol if colour boolean is true, lowercase if not.
     */
    @Override
    public char getSymbol() {
        if (super.colour == true) {
            return 'Q';
        } else {
            return 'q';
        }
    }
}
