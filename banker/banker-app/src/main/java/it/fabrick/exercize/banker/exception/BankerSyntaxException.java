/**
 * 
 */
package it.fabrick.exercize.banker.exception;

/**
 * @author emiliano.bossi
 */
public class BankerSyntaxException extends BankerException {

    /**
     * 
     */
    private static final long serialVersionUID = 2954992770207609694L;

    /**
     * @param message
     * @param cause
     */
    public BankerSyntaxException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public BankerSyntaxException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public BankerSyntaxException(Throwable cause) {
        super(cause);
    }

}
