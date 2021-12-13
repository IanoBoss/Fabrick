/**
 * 
 */
package it.fabrick.exercize.banker.web.rest;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fabrick.exercize.banker.dto.TransactionsRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferResponseDTO;
import it.fabrick.exercize.banker.web.response.impl.ResponseContentWrapper;

/**
 * @author emiliano.bossi
 */
@RestController
@RequestMapping(BankerController.URI_BANKER_MAIN)
public interface BankerController {

    String URI_BANKER_MAIN   = "/banker";
    String URI_BALANCE       = "/balance";
    String URI_WIRE_TRANSFER = "/wire-transfer";
    String URI_TRANSACTIONS  = "/transactions";

    @GetMapping(URI_BALANCE + "/{accountId}")
    ResponseEntity<ResponseContentWrapper<String>> balance(@PathVariable("accountId") @Min(1) Long accountId);

    @PostMapping(URI_WIRE_TRANSFER)
    ResponseEntity<ResponseContentWrapper<WireTransferResponseDTO>> wireTransfer(@Valid @RequestBody(required = true) WireTransferRequestDTO dto);

    @PostMapping(URI_TRANSACTIONS)
    ResponseEntity<ResponseContentWrapper<Collection<Map<String, Object>>>> transactions(@Valid @RequestBody(required = true) TransactionsRequestDTO dto);
}
