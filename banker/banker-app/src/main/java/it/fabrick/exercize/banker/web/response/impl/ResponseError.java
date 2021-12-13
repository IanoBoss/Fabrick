/**
 * 
 */
package it.fabrick.exercize.banker.web.response.impl;

import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import it.fabrick.exercize.banker.util.BankerUtil;
import it.fabrick.exercize.banker.web.response.ResponseCode;
import it.fabrick.exercize.banker.web.response.commons.ResponseWeb;

/**
 * @author emiliano.bossi
 */
public class ResponseError extends ResponseWeb {

    private String origMsg;
    private String stack;

    /**
     * @param code
     */
    public ResponseError() {
        super(ResponseCode.INERNAL_ERROR);
    }

    /**
     * @param code
     */
    public ResponseError(ResponseCode code, Throwable t) {
        super(code);
        this.origMsg = t.getMessage();
        this.stack = BankerUtil.convertStackTrace(t);
    }

    /**
     * @param code
     */
    public ResponseError(ResponseCode code, MethodArgumentNotValidException ex) {
        super(code);
        this.origMsg = ex.getMessage();
        this.stack = ex.getBindingResult().getAllErrors().stream().map(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            return fieldName.concat(" : ").concat(errorMessage);
        }).collect(Collectors.joining("\n"));
    }

    /**
     * @return the origMsg
     */
    public String getOrigMsg() {
        return origMsg;
    }

    /**
     * @return the stack
     */
    public String getStack() {
        return stack;
    }

    /**
     * @param origMsg the origMsg to set
     */
    public void setOrigMsg(String origMsg) {
        this.origMsg = origMsg;
    }

    /**
     * @param stack the stack to set
     */
    public void setStack(String stack) {
        this.stack = stack;
    }

}
