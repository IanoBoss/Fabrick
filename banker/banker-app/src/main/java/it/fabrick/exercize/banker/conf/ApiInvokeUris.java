/**
 * 
 */
package it.fabrick.exercize.banker.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author emiliano.bossi
 */
@ConfigurationProperties("conf.api.invoker")
public class ApiInvokeUris {

    private String serverUrl;
    private String uriBalance;
    private String uriWireTransfer;
    private String uriTransactions;

    /**
     * @return the serverUrl
     */
    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * @param serverUrl the serverUrl to set
     */
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    /**
     * @return the uriBalance
     */
    public String getUriBalance() {
        return uriBalance;
    }

    /**
     * @param uriBalance the uriBalance to set
     */
    public void setUriBalance(String uriBalance) {
        this.uriBalance = uriBalance;
    }

    /**
     * @return the uriWireTransfer
     */
    public String getUriWireTransfer() {
        return uriWireTransfer;
    }

    /**
     * @param uriWireTransfer the uriWireTransfer to set
     */
    public void setUriWireTransfer(String uriWireTransfer) {
        this.uriWireTransfer = uriWireTransfer;
    }

    /**
     * @return the uriTransactions
     */
    public String getUriTransactions() {
        return uriTransactions;
    }

    /**
     * @param uriTransactions the uriTransactions to set
     */
    public void setUriTransactions(String uriTransactions) {
        this.uriTransactions = uriTransactions;
    }
}
