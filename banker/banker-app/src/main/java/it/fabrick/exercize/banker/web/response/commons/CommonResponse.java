/**
 * 
 */
package it.fabrick.exercize.banker.web.response.commons;

/**
 * @author emiliano.bossi
 */
public abstract class CommonResponse {
    
    private String code;
    private String description;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
