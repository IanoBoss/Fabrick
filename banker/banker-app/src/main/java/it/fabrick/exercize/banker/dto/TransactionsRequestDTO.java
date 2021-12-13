/**
 * 
 */
package it.fabrick.exercize.banker.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author emiliano.bossi
 */
public class TransactionsRequestDTO extends AccountIdDTO {

    @NotNull(message = "indicare da quale data partire")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fromAccountingDate;
    @NotNull(message = "indicare entro quale data terminare")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date toAccountingDate;

    /**
     * @return the fromAccountingDate
     */
    public Date getFromAccountingDate() {
        return fromAccountingDate;
    }

    /**
     * @param fromAccountingDate the fromAccountingDate to set
     */
    public void setFromAccountingDate(Date fromAccountingDate) {
        this.fromAccountingDate = fromAccountingDate;
    }

    /**
     * @return the toAccountingDate
     */
    public Date getToAccountingDate() {
        return toAccountingDate;
    }

    /**
     * @param toAccountingDate the toAccountingDate to set
     */
    public void setToAccountingDate(Date toAccountingDate) {
        this.toAccountingDate = toAccountingDate;
    }
}
