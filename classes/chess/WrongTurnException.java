package chess;

/**
 * This is the exception class for when the user try to move a piece that is the
 * opposite colour of the current turn.
 *
 * @author Ayumu Saito
 */
public class WrongTurnException extends ChessException {

    /**
     * Primary constructor for WrongTurnException.
     */
    public WrongTurnException() {
        super("WrongTurnException");
    }

    /**
     * Constructor that takes a String as error message.
     *
     * @param message error message
     */
    public WrongTurnException(String message) {
        super(message);
    }
}
