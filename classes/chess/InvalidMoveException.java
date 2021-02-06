package chess;

/**
 * This is the exception class for when the piece tries to move to the invalid
 * coordinates.
 *
 * @author Ayumu Saito
 */
public class InvalidMoveException extends ChessException {

    /**
     * Primary Constructor for InvalidMoveException.
     */
    public InvalidMoveException() {
        super("InvalidMoveException");
    }

    /**
     * Constructor that takes String as error message.
     *
     * @param message error message
     */
    public InvalidMoveException(String message) {
        super(message);
    }
}
