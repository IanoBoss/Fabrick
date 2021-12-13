/**
 * 
 */
package it.fabrick.exercize.banker.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.fabrick.exercize.banker.BankerApplicationTests;
import it.fabrick.exercize.banker.dto.TransactionsRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferResponseDTO;
import it.fabrick.exercize.banker.enumeration.CurrencyType;
import it.fabrick.exercize.banker.web.response.ResponseCode;
import it.fabrick.exercize.banker.web.response.impl.ResponseContentWrapper;
import it.fabrick.exercize.banker.web.response.impl.ResponseError;
import it.fabrick.exercize.banker.web.rest.BankerController;

/**
 * @author emiliano.bossi
 */
public class BankerControllerTester extends BankerApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(BankerControllerTester.class);

    @Test
    void testBalance() {
        try {
            ResponseEntity<ResponseContentWrapper<String>> balance = testGet(concatMultiUris(BankerController.URI_BANKER_MAIN, BankerController.URI_BALANCE),  new ParameterizedTypeReference<ResponseContentWrapper<String>>() {}, accountId.toString());
            
            assertTrue(balance.hasBody());
            assertNotNull(balance.getBody());
            assertEquals("2000.00", balance.getBody().getContent());
            assertEquals(ResponseCode.OK.getValue(), balance.getBody().getCode());
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            fail();
        }
    }

    @Test
    void testTransfer() {
        try {
            ResponseEntity<ResponseContentWrapper<WireTransferResponseDTO>> transferResp = testPost(concatMultiUris(BankerController.URI_BANKER_MAIN, BankerController.URI_WIRE_TRANSFER), generateTransferDTO(), new ParameterizedTypeReference<ResponseContentWrapper<WireTransferResponseDTO>>(){});
            assertTrue(transferResp.hasBody());
            assertNotNull(transferResp.getBody());
            assertEquals(ResponseCode.OK.getValue(), transferResp.getBody().getCode());
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            fail();
        }
    }

    @Test
    void testTransferError() {
        try {
            ResponseEntity<ResponseError> transferResp = testPost(concatMultiUris(BankerController.URI_BANKER_MAIN, BankerController.URI_WIRE_TRANSFER), new WireTransferRequestDTO(), ResponseError.class);
            assertTrue(transferResp.hasBody());
            assertNotNull(transferResp.getBody());
            assertEquals(ResponseCode.VALIDATION_ERROR.getValue(), transferResp.getBody().getCode());
            assertEquals(HttpStatus.BAD_REQUEST, transferResp.getStatusCode());
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            fail();
        }
    }

    @Test
    void testTransactions() {
        try {
            ResponseEntity<ResponseContentWrapper<Collection<Map<String, Object>>>> transferResp = testPost(concatMultiUris(BankerController.URI_BANKER_MAIN, BankerController.URI_TRANSACTIONS), generateTransactionsRequestDTO(), new ParameterizedTypeReference<ResponseContentWrapper<Collection<Map<String, Object>>>>() {
            });
            assertTrue(transferResp.hasBody());
            assertNotNull(transferResp.getBody());
            assertEquals(ResponseCode.OK.getValue(), transferResp.getBody().getCode());
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            fail();
        }
    }

    @Test
    void testTransactionsError() {
        try {
            ResponseEntity<ResponseError> transferResp = testPost(concatMultiUris(BankerController.URI_BANKER_MAIN, BankerController.URI_TRANSACTIONS), new TransactionsRequestDTO(), ResponseError.class);
            assertTrue(transferResp.hasBody());
            assertNotNull(transferResp.getBody());
            assertEquals(ResponseCode.VALIDATION_ERROR.getValue(), transferResp.getBody().getCode());
            assertEquals(HttpStatus.BAD_REQUEST, transferResp.getStatusCode());
        } catch (Throwable t) {
            logger.error(t.getMessage(), t);
            fail();
        }
    }

    /**
     * 
     */
    private WireTransferRequestDTO generateTransferDTO() {
        WireTransferRequestDTO dto = new WireTransferRequestDTO();
        dto.setAccountId(accountId);
        dto.setAmmount(new BigDecimal(1.000));
        dto.setCurrency(CurrencyType.EUR);
        dto.setDescription("Test bonifico");
        dto.setReceiverName("Beta Tester");
        return dto;
    }

    /**
     * @throws ParseException
     */
    private TransactionsRequestDTO generateTransactionsRequestDTO() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        TransactionsRequestDTO dto = new TransactionsRequestDTO();
        dto.setAccountId(accountId);
        dto.setFromAccountingDate(sdf.parse("2021-11-01"));
        dto.setToAccountingDate(sdf.parse("2021-11-30"));
        return dto;
    }
}
