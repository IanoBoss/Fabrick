/**
 * 
 */
package it.fabrick.exercize.banker.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author emiliano.bossi
 */
@ConfigurationProperties("fabrick.authentication")
public class FAuthProperties {

    private String baseUrl;
    private String schema;
    private String apiKey;
    private String idChiave;

    /**
     * @return the baseUrl
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @param baseUrl the baseUrl to set
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * @return the schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     * @param schema the schema to set
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * @return the apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * @param apiKey the apiKey to set
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * @return the idChiave
     */
    public String getIdChiave() {
        return idChiave;
    }

    /**
     * @param idChiave the idChiave to set
     */
    public void setIdChiave(String idChiave) {
        this.idChiave = idChiave;
    }
}
