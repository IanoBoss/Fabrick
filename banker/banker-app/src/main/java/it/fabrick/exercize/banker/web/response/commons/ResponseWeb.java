/**
 * 
 */
package it.fabrick.exercize.banker.web.response.commons;

import it.fabrick.exercize.banker.web.response.ResponseCode;

/**
 * @author emiliano.bossi
 */
public abstract class ResponseWeb extends CommonResponse {

    /**
     * @param code
     */
    public ResponseWeb(ResponseCode code) {
        super.setCode(code.getValue());
        super.setDescription(code.getDescription());
    }
}
