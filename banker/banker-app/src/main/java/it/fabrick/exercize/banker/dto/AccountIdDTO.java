/**
 * 
 */
package it.fabrick.exercize.banker.dto;

import javax.validation.constraints.NotNull;

/**
 * @author emiliano.bossi
 */
public abstract class AccountIdDTO {

    @NotNull(message = "identificativo account obbligatorio")
    private Long accountId;

    /**
     * @return the accountId
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
