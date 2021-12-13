/**
 * 
 */
package it.fabrick.exercize.banker.exception;

/**
 * @author emiliano.bossi
 */
public abstract class BankerException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -6750181870769275477L;

    /**
     * @param message
     */
    public BankerException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public BankerException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public BankerException(String message, Throwable cause) {
        super(message, cause);
    }

}
