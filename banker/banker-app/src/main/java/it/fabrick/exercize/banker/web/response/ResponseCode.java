/**
 * 
 */
package it.fabrick.exercize.banker.web.response;

/**
 * @author emiliano.bossi
 */
public enum ResponseCode {

    OK("00", "Success"), //
    NO_RESULT("01", "No results"), //
    INERNAL_ERROR("02", "Execution error"), //
    UNCAUGHT_ERROR("03", "Error before execution"), //
    VALIDATION_ERROR("O4", "Not vali input data");

    private final String value;
    private final String description;

    /**
     * @param value
     */
    private ResponseCode(String value, String description) {
        this.value = value;
        this.description = description;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
