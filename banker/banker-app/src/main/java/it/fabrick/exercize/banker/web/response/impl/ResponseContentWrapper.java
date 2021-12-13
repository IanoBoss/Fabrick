/**
 * 
 */
package it.fabrick.exercize.banker.web.response.impl;

import it.fabrick.exercize.banker.web.response.ResponseCode;
import it.fabrick.exercize.banker.web.response.commons.ResponseWeb;

/**
 * @author emiliano.bossi
 */
public class ResponseContentWrapper<T> extends ResponseWeb {

    private T content;

    public ResponseContentWrapper(ResponseCode code) {
        super(code);
    }

    public ResponseContentWrapper(ResponseCode code, T content) {
        super(code);
        this.content = content;
    }

    /**
     * @return the content
     */
    public T getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(T content) {
        this.content = content;
    }
}
