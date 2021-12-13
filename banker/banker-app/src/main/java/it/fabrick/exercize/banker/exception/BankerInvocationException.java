/**
 * 
 */
package it.fabrick.exercize.banker.exception;

/**
 * @author emiliano.bossi
 */
public class BankerInvocationException extends BankerException {

    /**
     * 
     */
    private static final long serialVersionUID = 9060407220647206420L;

    /**
     * @param message
     */
    public BankerInvocationException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public BankerInvocationException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public BankerInvocationException(String message, Throwable cause) {
        super(message, cause);
    }

}
