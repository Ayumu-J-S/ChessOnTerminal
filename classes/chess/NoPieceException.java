package chess;

/**
 * This is the exception class for when the user chooses coordinates which no
 * piece is on.
 *
 * @author Ayumu Saito 
 */
public class NoPieceException extends ChessException {

    /**
     * Primary constructor for NoPieceException.
     */
    public NoPieceException() {
        super("NoPieceException");
    }

    /**
     * Constructor that takes String as error message.
     *
     * @param message error message
     */
    public NoPieceException(String message) {
        super(message);
    }
}
