package chess;

/**
 * This class is the extention from the Piece class, which acts as Bishop on
 * chess Board.
 *
 * @author Ayumu Saito
 */
public class Bishop extends Piece {

    /**
     * Constructor for the Bishop object.
     *
     * @param b Board that this piece is on
     * @param colour true for white, false for black
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     */
    public Bishop(Board b, boolean colour, int vertical, int horizontal) {
        super(b, colour, vertical, horizontal);
    }

    /**
     * Checks if the move is valid for this piece. It can move any number of
     * squares in any diagonal direction as long as there are no pieces in it's
     * path.
     *
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     * @return true if the move if valid, false if not
     */
    @Override
    public boolean isValidMove(int vertical, int horizontal) {
        //declare variables
        boolean isValid = false;
        int hDistance = Math.abs(super.horizontal - horizontal);
        int vDistance = Math.abs(super.vertical - vertical);

        //checks if the coordinates are valid
        if (vDistance == 1 && hDistance == 1) {
            isValid = true;
        } else if (vDistance == hDistance) {
            if (super.horizontal < horizontal && super.vertical < vertical) {

                /*checks if any pieces are in the way. if it is, set isValid 
                  false and break out of the loop, if no set it true*/
                for (int i = 1; i < hDistance; i++) {
                    if (b.pieces[super.vertical + i][super.horizontal + i]
                            != null) {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }

            } else if (super.horizontal < horizontal
                    && super.vertical > vertical) {

                /*checks if any pieces are in the way. if it is, set isValid 
                  false and break out of the loop, if no set it true*/
                for (int i = 1; i < hDistance; i++) {
                    if (b.pieces[super.vertical - i][super.horizontal + i]
                            != null) {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }

            } else if (super.horizontal > horizontal
                    && super.vertical > vertical) {

                /*checks if any pieces are in the way. if it is, set isValid 
                  false and break out of the loop, if no set it true*/
                for (int i = 1; i < hDistance; i++) {
                    if (b.pieces[super.vertical - i][super.horizontal - i]
                            != null) {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }

            } else if (super.horizontal > horizontal
                    && super.vertical < vertical) {

                /*checks if any pieces are in the way. if it is, set isValid 
                  false and break out of the loop, if no set it true*/
                for (int i = 1; i < hDistance; i++) {
                    if (b.pieces[super.vertical + i][super.horizontal - i]
                            != null) {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }
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
            return 'B';
        } else {
            return 'b';
        }
    }
}
