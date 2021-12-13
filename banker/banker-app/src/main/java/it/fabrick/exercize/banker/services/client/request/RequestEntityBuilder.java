/**thVars
 * 
 */
package it.fabrick.exercize.banker.services.client.request;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import it.fabrick.exercize.banker.util.BankerUtil;

/**
 * @author emiliano.bossi
 */
public class RequestEntityBuilder {

    private final Logger                     logger = LoggerFactory.getLogger(RequestEntityBuilder.class);
    private String                           baseAddress;
    private String                           serviceUri;
    private List<Object>                     pathVars;
    private Collection<Pair<String, String>> queryParams;
    private Object                           payload;
    private Optional<HttpHeaders>            headers;

    /**
     * @param baseAddress
     * @param serviceUri
     * @param headers
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri, HttpHeaders headers) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.headers = Optional.of(headers);
    }

    /**
     * @param baseAddress
     * @param serviceUri
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.headers = Optional.empty();
    }

    /**
     * @param baseAddress
     * @param serviceUri
     * @param pathVars
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri, List<Object> pathVars) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.pathVars = pathVars;
        this.headers = Optional.empty();
    }

    /**
     * S // * @param baseAddress
     * 
     * @param serviceUri
     * @param queryParams
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri, Collection<Pair<String, String>> queryParams) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.queryParams = queryParams;
        this.headers = Optional.empty();
    }

    /**
     * @param baseAddress
     * @param serviceUri
     * @param payload
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri, Object payload) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.payload = payload;
        this.headers = Optional.empty();
    }

    /**
     * @param baseAddress
     * @param serviceUri
     * @param queryParams
     * @param headers
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri, HttpHeaders headers, Collection<Pair<String, String>> queryParams) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.queryParams = queryParams;
        this.headers = Optional.of(headers);
    }

    /**
     * @param baseAddress
     * @param serviceUri
     * @param payload
     * @param headers
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri, Object payload, HttpHeaders headers) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.payload = payload;
        this.headers = Optional.of(headers);
    }

    /**
     * @param baseAddress
     * @param serviceUri
     * @param pathVars
     */
    public RequestEntityBuilder(String baseAddress, String serviceUri, HttpHeaders headers, List<Object> pathVars) {
        this.baseAddress = baseAddress;
        this.serviceUri = serviceUri;
        this.pathVars = pathVars;
        this.headers = Optional.of(headers);
    }

    /**
     * @param baseAddress the baseAddress to List
     */
    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    /**
     * @param serviceUri the serviceUri to set
     */
    public void setServiceUri(String serviceUri) {
        this.serviceUri = serviceUri;
    }

    /**
     * @param pathVars the pathVars to set
     */
    public void setPathVars(List<Object> pathVars) {
        this.pathVars = pathVars;
    }

    /**
     * @param queryParams the queryParams to set
     */
    public void setQueryParams(Collection<Pair<String, String>> queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(HttpHeaders headers) {
        this.headers = Optional.of(headers);
    }

    public RequestEntity<?> buildPostRequest() throws URISyntaxException {
        URI endpoint = BankerUtil.buildURI(baseAddress, serviceUri);
        logger.debug("invoking: {}", endpoint);
        RequestEntity<Object> re = (headers.isPresent()) ? new RequestEntity<Object>(payload, headers.get(), HttpMethod.POST, endpoint) : new RequestEntity<Object>(payload, HttpMethod.POST, endpoint);
        return re;
    }

    public RequestEntity<Void> buildGetRequest() throws URISyntaxException {
        URI endpoint;
        if (Objects.nonNull(queryParams))
            endpoint = BankerUtil.buildURI(baseAddress, serviceUri, queryParams);
        else if (Objects.nonNull(pathVars))
            endpoint = BankerUtil.buildURI(baseAddress, serviceUri, pathVars);
        else
            endpoint = BankerUtil.buildURI(baseAddress, serviceUri);
        logger.debug("invoking: {}", endpoint);
        RequestEntity<Void> re = (headers.isPresent()) ? new RequestEntity<Void>(headers.get(), HttpMethod.GET, endpoint) : new RequestEntity<Void>(HttpMethod.GET, endpoint);
        return re;
    }
}
