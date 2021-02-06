package chess;

/**
 * This class is the extention from the Piece class, which acts as Pawn on chess
 * Board.
 *
 * @author Ayumu Saito 
 */
public class Pawn extends Piece {

    /**
     * Constructor for the Pawn object. It can move 1 square in the forward
     * direction (the forward direction depends on the color). If the Pawn has
     * not been moved yet it can move 2 squares in the forward direction as long
     * as there are no pieces in it's path.
     *
     * @param b Board that this piece is on
     * @param colour true for white, false for black
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     */
    public Pawn(Board b, boolean colour, int vertical, int horizontal) {
        super(b, colour, vertical, horizontal);
    }

    /**
     * Checks if the move is valid for this piece.
     *
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     * @return true if the move if valid, false if not
     */
    @Override
    public boolean isValidMove(int vertical, int horizontal) {

        if (super.b.isWhiteTurn) /*if it is white turn*/ {

            if (super.hasBeenMoved) /*if it has been moved already*/ {

                if (b.pieces[vertical][horizontal] == null) /*if there is no
                piece at the coordinates*/ {

                    /*return true if the coordinate is one square ahead, 
                    false if not */
                    return vertical == super.vertical - 1
                            && horizontal == super.horizontal;

                } else if ((super.vertical - vertical == 1)
                        && Math.abs(super.horizontal - horizontal) == 1)/*if the 
                        piece is one diagonal ahead*/ {

                    //return true if there is a piece
                    return b.pieces[vertical][horizontal] != null;

                } else {
                    return false;
                }

            } else /*if it hasn't been moved*/ {

                //if the coordinates are one square ahead
                if (vertical == super.vertical - 1
                        && horizontal == super.horizontal) {

                    /*if there is no piece return true*/
                    return b.pieces[vertical][horizontal] == null;

                } else if ((super.vertical - vertical == 1)
                        && Math.abs(super.horizontal - horizontal) == 1) /*
                        if the coordinates are one diagonal ahead*/ {

                    //return true if there is a piece
                    return b.pieces[vertical][horizontal] != null;

                } else /* if the coordianates aren't one square ahead*/ {

                    if (b.pieces[vertical][horizontal] == null) /*if there 
                        is nopiece at the coordinates*/ {

                        /*return true if coordinates are 2 square ahead and 
                        there is no piece ahead of this piece, return false if 
                        not*/
                        return (vertical == super.vertical - 2
                                && horizontal == super.horizontal)
                                && (b.pieces[vertical + 1][horizontal] == null);

                    } else {
                        return false;
                    }

                }
            }
        } else { //if it is black turn

            if (super.hasBeenMoved)/*if it hasnt been moved*/ {

                if (b.pieces[vertical][horizontal] == null) /*if there is no
                piece at the coordinates*/ {

                    /*return true if the coordinate is one square ahead, 
                    false if not */
                    return vertical == super.vertical + 1
                            && horizontal == super.horizontal;

                } else if ((vertical - super.vertical == 1)
                        && Math.abs(super.horizontal - horizontal) == 1)/*if the 
                        piece is one diagonal ahead*/ {

                    //return true if there is a piece
                    return b.pieces[vertical][horizontal] != null;
                } else {
                    return false;
                }

            } else {  //if it hasn't been moved 

                //if the coordinates are one square ahead
                if (vertical == super.vertical + 1
                        && horizontal == super.horizontal) {

                    /*if there is no piece return true*/
                    return b.pieces[vertical][horizontal] == null;

                } else if ((vertical - super.vertical == 1)
                        && Math.abs(super.horizontal - horizontal) == 1) /*
                        if the coordinates are one diagonal ahead*/ {

                    //return true if there is a piece
                    return b.pieces[vertical][horizontal] != null;

                } else /* if the coordianates aren't one square ahead*/ {

                    if (b.pieces[vertical][horizontal] == null) /*if there 
                        is nopiece at the coordinates*/ {

                        /*return true if coordinates are 2 square ahead and 
                        there is no piece ahead of this piece, return false if 
                        not*/
                        return (vertical == super.vertical + 2
                                && horizontal == super.horizontal)
                                && (b.pieces[vertical - 1][horizontal] == null);

                    } else {
                        return false;
                    }

                }
            }
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
            return 'P';
        } else {
            return 'p';
        }
    }
}
