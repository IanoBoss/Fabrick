/**
 * 
 */
package it.fabrick.exercize.banker.services.client.impl;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import it.fabrick.exercize.banker.exception.BankerInvocationException;
import it.fabrick.exercize.banker.exception.BankerSyntaxException;
import it.fabrick.exercize.banker.services.client.RestClientHelper;
import it.fabrick.exercize.banker.services.client.request.RequestEntityBuilder;

/**
 * @author emiliano.bossi
 */
@Component
public class RestClientHelperImpl implements RestClientHelper {

    private final Logger logger = LoggerFactory.getLogger(RestClientHelperImpl.class);

    @Override
    public <T> ResponseEntity<T> post(RequestEntityBuilder builder, Class<T> expectedClassRes) {
        try {
            RequestEntity<?> re = builder.buildPostRequest();
            RestTemplate rt = new RestTemplate();
            ResponseEntity<T> response = rt.exchange(re, expectedClassRes);
            return response;
        } catch (URISyntaxException e) {
            logger.error(e.getMessage(), e);
            throw new BankerSyntaxException("URI syntax Error!", e);
        } catch (RestClientException e) {
            logger.error(e.getMessage(), e);
            throw new BankerInvocationException("Error calling Fabbrick API", e);
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            throw new BankerInvocationException("Unexpected Error!", t);
        }
    }

    @Override
    public <T> ResponseEntity<T> post(RequestEntityBuilder builder, ParameterizedTypeReference<T> expectedTypedClassRes) {
        try {
            RequestEntity<?> re = builder.buildPostRequest();
            RestTemplate rt = new RestTemplate();
            ResponseEntity<T> response = rt.exchange(re, expectedTypedClassRes);
            return response;
        } catch (URISyntaxException e) {
            logger.error(e.getMessage(), e);
            throw new BankerSyntaxException("URI syntax Error!", e);
        } catch (RestClientException e) {
            logger.error(e.getMessage(), e);
            throw new BankerInvocationException("Error calling Fabbrick API", e);
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            throw new BankerInvocationException("Unexpected Error!", t);
        }
    }

    @Override
    public <T> ResponseEntity<T> get(RequestEntityBuilder builder, Class<T> expectedClassRes) {
        try {
            RequestEntity<Void> re = builder.buildGetRequest();
            RestTemplate rt = new RestTemplate();
            ResponseEntity<T> response = rt.exchange(re, expectedClassRes);
            return response;
        } catch (URISyntaxException e) {
            logger.error(e.getMessage(), e);
            throw new BankerSyntaxException("URI syntax Error!", e);
        } catch (RestClientException e) {
            logger.error(e.getMessage(), e);
            throw new BankerInvocationException("Error calling Fabbrick API", e);
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            throw new BankerInvocationException("Unexpected Error!", t);
        }
    }


    @Override
    public <T> ResponseEntity<T> get(RequestEntityBuilder builder, ParameterizedTypeReference<T> expectedTypedClassRes) {
        try {
            RequestEntity<Void> re = builder.buildGetRequest();
            RestTemplate rt = new RestTemplate();
            ResponseEntity<T> response = rt.exchange(re, expectedTypedClassRes);
            return response;
        } catch (URISyntaxException e) {
            logger.error(e.getMessage(), e);
            throw new BankerSyntaxException("URI syntax Error!", e);
        } catch (RestClientException e) {
            logger.error(e.getMessage(), e);
            throw new BankerInvocationException("Error calling Fabbrick API", e);
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            throw new BankerInvocationException("Unexpected Error!", t);
        }
    }
}
