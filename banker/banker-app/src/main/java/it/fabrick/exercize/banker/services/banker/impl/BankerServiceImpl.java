/**
 * 
 */
package it.fabrick.exercize.banker.services.banker.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import it.fabrick.exercize.banker.conf.ApiInvokeUris;
import it.fabrick.exercize.banker.conf.FAuthProperties;
import it.fabrick.exercize.banker.dto.TransactionsRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferResponseDTO;
import it.fabrick.exercize.banker.services.banker.BankerService;
import it.fabrick.exercize.banker.services.client.RestClientHelper;
import it.fabrick.exercize.banker.services.client.request.RequestEntityBuilder;

/**
 * @author emiliano.bossi
 */
@Component
@EnableConfigurationProperties({ FAuthProperties.class, ApiInvokeUris.class })
public class BankerServiceImpl implements BankerService {

    private final Logger     logger = LoggerFactory.getLogger(BankerServiceImpl.class);
    private RestClientHelper clientHelper;
    private FAuthProperties  authProperties;
    private ApiInvokeUris    apiInvokeUris;

    /**
     * @param clientHelper
     * @param authProperties
     * @param apiInvokeUris
     */
    public BankerServiceImpl(RestClientHelper clientHelper, FAuthProperties authProperties, ApiInvokeUris apiInvokeUris) {
        this.clientHelper = clientHelper;
        this.authProperties = authProperties;
        this.apiInvokeUris = apiInvokeUris;
    }

    @Override
    public Optional<String> balance(Long accountId) {
        HttpHeaders headers = commonHeaders();
        RequestEntityBuilder builder = new RequestEntityBuilder(apiInvokeUris.getServerUrl(), apiInvokeUris.getUriBalance(), headers, Arrays.asList(accountId));
        ResponseEntity<String> respBalance = clientHelper.get(builder, String.class);
        logger.debug("balance invoked");
        return ((respBalance.hasBody()) ? Optional.of(respBalance.getBody()) : Optional.empty());
    }

    @Override
    public Optional<WireTransferResponseDTO> wireTransfer(WireTransferRequestDTO dto) {
        HttpHeaders headers = commonHeaders();
        RequestEntityBuilder builder = new RequestEntityBuilder(apiInvokeUris.getServerUrl(), apiInvokeUris.getUriWireTransfer(), dto, headers);
        ResponseEntity<WireTransferResponseDTO> respTransfer = clientHelper.post(builder, WireTransferResponseDTO.class);
        logger.debug("transfer invoked");
        return ((respTransfer.hasBody()) ? Optional.of(respTransfer.getBody()) : Optional.empty());
    }

    @Override
    public Optional<Collection<Map<String, Object>>> transactions(TransactionsRequestDTO dto) {
        HttpHeaders headers = commonHeaders();
        RequestEntityBuilder builder = new RequestEntityBuilder(apiInvokeUris.getServerUrl(), apiInvokeUris.getUriTransactions(), dto, headers);
        ResponseEntity<Collection<Map<String, Object>>> respTransactions = clientHelper.post(builder, new ParameterizedTypeReference<Collection<Map<String, Object>>>() {
        });
        logger.debug("transactions invoked");
        return ((respTransactions.hasBody()) ? Optional.of(respTransactions.getBody()) : Optional.empty());
    }

    /**
     * @return
     */
    private HttpHeaders commonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Auth-Schema", authProperties.getSchema());
        headers.set("Api-Key", authProperties.getApiKey());
        return headers;
    }
}
