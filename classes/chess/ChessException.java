package chess;

/**
 * This class is Exception class that inherits from Exception. All the other
 * Exception in this package inherits from this class.
 *
 * @author Ayumu Saito
 */
public class ChessException extends Exception {

    /**
     * Primary Constructor for the ChessException.
     */
    public ChessException() {
        super("Error");
    }

    /**
     * Constructor that takes String for message.
     *
     * @param message error message
     */
    public ChessException(String message) {
        super(message);
    }
}
