package chess;

/**
 * This is the exception class for when user choose coordinates that is off the
 * board.
 *
 * @author Ayumu Saito
 */
public class OffBoardException extends ChessException {

    /**
     * Primary constructor for the OffBoardException.
     */
    public OffBoardException() {
        super("OffBoardExcepiton");
    }

    /**
     * Constructor that takes String for the error message.
     *
     * @param message error message
     */
    public OffBoardException(String message) {
        super(message);
    }
}
