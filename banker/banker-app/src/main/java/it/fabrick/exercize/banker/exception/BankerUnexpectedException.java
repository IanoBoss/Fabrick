/**
 * 
 */
package it.fabrick.exercize.banker.exception;

/**
 * @author emiliano.bossi
 */
public class BankerUnexpectedException extends BankerException {

    /**
     * 
     */
    private static final long serialVersionUID = -5394812759074381252L;

    /**
     * @param message
     */
    public BankerUnexpectedException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public BankerUnexpectedException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public BankerUnexpectedException(String message, Throwable cause) {
        super(message, cause);
    }

}
