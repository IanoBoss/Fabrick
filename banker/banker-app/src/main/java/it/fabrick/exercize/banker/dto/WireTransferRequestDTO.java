/**
 * 
 */
package it.fabrick.exercize.banker.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import it.fabrick.exercize.banker.enumeration.CurrencyType;

/**
 * @author emiliano.bossi
 */
public class WireTransferRequestDTO extends AccountIdDTO {

    @NotEmpty(message = "intestatario conto obbligatorio")
    private String       receiverName;
    private String       description;
    @NotNull(message = "Tipo di valuta obbligatoria")
    private CurrencyType currency;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Cifra da trasferire obbligatoria")
    @DecimalMin("1.00")
    private BigDecimal   ammount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date         executionDate;

    /**
     * @return the receiverName
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName the receiverName to set
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    /**
     * @return the currency
     */
    public CurrencyType getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    /**
     * @return the ammount
     */
    public BigDecimal getAmmount() {
        return ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    /**
     * @return the executionDate
     */
    public Date getExecutionDate() {
        return executionDate;
    }

    /**
     * @param executionDate the executionDate to set
     */
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

}
