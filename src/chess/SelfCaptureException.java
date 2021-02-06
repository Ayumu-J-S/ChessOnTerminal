package chess;

/**
 * This is the exception class for when the user try to replace a piece with a
 * piece that has the same colour of that piece.
 *
 * @author Ayumu Saito (A00436125)
 */
public class SelfCaptureException extends ChessException {

    /**
     * Primary constructor for SelfCaptureException.
     */
    public SelfCaptureException() {
        super("SelfCaptureException");
    }

    /**
     * Constructor that takes a String as error message.
     *
     * @param message error message
     */
    public SelfCaptureException(String message) {
        super(message);
    }
}
