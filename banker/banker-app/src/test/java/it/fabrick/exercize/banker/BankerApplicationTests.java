package it.fabrick.exercize.banker;

import java.net.URISyntaxException;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import it.fabrick.exercize.banker.services.client.request.RequestEntityBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public abstract class BankerApplicationTests {

    @Value("${def.account.id}")
    protected Long           accountId;
    private final Logger     logger = LoggerFactory.getLogger(BankerApplicationTests.class);
    @LocalServerPort
    private int              port;
    @Autowired
    private TestRestTemplate restTemplate;

    protected <T> ResponseEntity<T> testPost(String serviceUri, Object payload, Class<T> expectedClass) throws URISyntaxException {
        logger.debug("Testing POST");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri, payload);
        RequestEntity<?> postReq = builder.buildPostRequest();
        ResponseEntity<T> result = restTemplate.exchange(postReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected <T> ResponseEntity<T> testPost(String serviceUri, Object payload, ParameterizedTypeReference<T> expectedClass) throws URISyntaxException {
        logger.debug("Testing POST");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri, payload);
        RequestEntity<?> postReq = builder.buildPostRequest();
        ResponseEntity<T> result = restTemplate.exchange(postReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected <T> ResponseEntity<T> testGet(String serviceUri, Class<T> expectedClass) throws URISyntaxException {
        logger.debug("Testing GET");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri);
        RequestEntity<?> getReq = builder.buildGetRequest();
        ResponseEntity<T> result = restTemplate.exchange(getReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected <T> ResponseEntity<T> testGet(String serviceUri, ParameterizedTypeReference<T> expectedClass) throws URISyntaxException {
        logger.debug("Testing GET");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri);
        RequestEntity<?> getReq = builder.buildGetRequest();
        ResponseEntity<T> result = restTemplate.exchange(getReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected <T> ResponseEntity<T> testGet(String serviceUri, Class<T> expectedClass, Collection<Pair<String, String>> queryParams) throws URISyntaxException {
        logger.debug("Testing GET with query");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri, queryParams);
        RequestEntity<?> getReq = builder.buildGetRequest();
        ResponseEntity<T> result = restTemplate.exchange(getReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected <T> ResponseEntity<T> testGet(String serviceUri, ParameterizedTypeReference<T> expectedClass, Collection<Pair<String, String>> queryParams) throws URISyntaxException {
        logger.debug("Testing GET with query");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri, queryParams);
        RequestEntity<?> getReq = builder.buildGetRequest();
        ResponseEntity<T> result = restTemplate.exchange(getReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected <T> ResponseEntity<T> testGet(String serviceUri, Class<T> expectedClass, String... pathVars) throws URISyntaxException {
        logger.debug("Testing GET with paths");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri, Arrays.asList(pathVars));
        RequestEntity<?> getReq = builder.buildGetRequest();
        ResponseEntity<T> result = restTemplate.exchange(getReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected <T> ResponseEntity<T> testGet(String serviceUri, ParameterizedTypeReference<T> expectedClass, String... pathVars) throws URISyntaxException {
        logger.debug("Testing GET with paths");
        RequestEntityBuilder builder = new RequestEntityBuilder(resolveBaseAddress(), serviceUri, Arrays.asList(pathVars));
        RequestEntity<?> getReq = builder.buildGetRequest();
        ResponseEntity<T> result = restTemplate.exchange(getReq, expectedClass);
        logger.debug("exchange DONE!");
        return result;
    }

    protected String concatMultiUris(String... uris) {
        String uri = StringUtils.join(uris, "");
        logger.debug("calling URI: {}", uri);
        return uri;
    }

    /**
     * @return
     */
    private String resolveBaseAddress() {
        String baseAddress = String.format("http://localhost:%d/api", port);
        return baseAddress;
    }
}
