package chess;

/**
 * This class is the parent class for all the pieces.
 *
 * @author Ayumu Saito 
 */
public abstract class Piece {

    //Declare variables
    protected boolean colour, hasBeenMoved;
    protected int vertical, horizontal;
    protected Board b;

    /**
     * Constructor for the Object that inherits from the piece class.
     *
     * @param b Board that the piece is currently on
     * @param colour true for white, false for black
     * @param vertical vertical coordinate of the piece
     * @param horizontal horizontal coordinate of the piece
     */
    public Piece(Board b, boolean colour, int vertical, int horizontal) {
        this.b = b;
        this.colour = colour;
        this.vertical = vertical;
        this.horizontal = horizontal;

        hasBeenMoved = false;
    }

    /**
     * Method for moving piece. If the move is valid, change the coordinates of
     * the piece to new coordinates. Coordinates that the pice was originally on
     * will be empty.
     *
     * @param vertical vertical coordinate of the place user want to move the
     * piece to
     * @param horizontal horizontal coordinate of the place user want to move
     * the pice to
     * @throws chess.InvalidMoveException
     */
    public void move(int vertical, int horizontal) throws InvalidMoveException {
        if (isValidMove(vertical, horizontal)) {
            b.pieces[vertical][horizontal] = this;
            b.pieces[this.vertical][this.horizontal] = null;
            this.vertical = vertical;
            this.horizontal = horizontal;

            hasBeenMoved = true;
        } else {
            throw new InvalidMoveException("A "
                    + this.getClass().getSimpleName()
                    + " can not be moved there.");
        }
    }

    /**
     * Abstract method for isValidMove.
     *
     * @param vertical vertical coordinate
     * @param horizontal horizontal coordinate
     * @return true if the move is valid, false if not
     */
    public abstract boolean isValidMove(int vertical, int horizontal);

    /**
     * Abstract method getSymbol.
     *
     * @return symbol of the piece
     */
    public abstract char getSymbol();

}
