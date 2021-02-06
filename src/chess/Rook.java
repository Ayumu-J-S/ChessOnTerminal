package chess;

/**
 * This class is the extention from the Piece class, which acts as Rook on chess
 * Board.
 *
 * @author Ayumu Saito
 */
public class Rook extends Piece {

    /**
     * Constructor for the Rook object.
     *
     * @param b Board that this piece is on
     * @param colour true for white, false for black
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     */
    public Rook(Board b, boolean colour, int vertical, int horizontal) {
        super(b, colour, vertical, horizontal);
    }

    /**
     * Checks if the move is valid for this piece. It can move any number of
     * rows or alternatively any number of columns in any direction as long as
     * there are no pieces in it's path.
     *
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     * @return true if the move if valid, false if not
     */
    @Override
    public boolean isValidMove(int vertical, int horizontal) {
        //create variables
        boolean isValid = false;
        int hDistance = Math.abs(super.horizontal - horizontal);
        int vDistance = Math.abs(super.vertical - vertical);

        //checks if the input is valid
        if (vDistance == 0 && hDistance == 1) {
            isValid = true;
        } else if (vDistance == 1 && hDistance == 0) {
            isValid = true;
        } else if (vDistance == 0 && hDistance < 8) {
            if (super.horizontal < horizontal) {
                
                /*if the there is no pieces in the way, set isValid true and
                  if there is a piece, set isValid false and break out of the
                  loop*/
                for (int i = super.horizontal + 1; i < horizontal;
                        i++) {
                    if (b.pieces[vertical][i] != null) {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }

            } else if (super.horizontal > horizontal) {
                
                /*if the there is no pieces in the way, set isValid true and
                  if there is a piece, set isValid false and break out of the
                  loop*/
                for (int i = super.horizontal - 1; i > horizontal;
                        i--) {
                    if (b.pieces[vertical][i] != null) {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }
            }
            
        } else if (hDistance == 0 && vDistance < 8) {

            if (super.vertical < vertical) {
                
                /*if the there is no pieces in the way, set isValid true and
                  if there is a piece, set isValid false and break out of the
                  loop*/
                for (int i = super.vertical + 1; i < vertical;
                        i++) {
                    if (b.pieces[i][horizontal] != null) {
                        isValid = false;
                        break;
                    } else {
                        isValid = true;
                    }
                }
            } else if (super.vertical > vertical) {
                
                /*if the there is no pieces in the way, set isValid true and
                  if there is a piece, set isValid false and break out of the
                  loop*/
                for (int i = super.vertical - 1; i > vertical;
                        i--) {
                    if (b.pieces[i][horizontal] != null) {
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
            return 'R';
        } else {
            return 'r';
        }
    }
}
