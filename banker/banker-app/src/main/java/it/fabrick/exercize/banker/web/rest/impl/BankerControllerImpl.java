/**
 * 
 */
package it.fabrick.exercize.banker.web.rest.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import it.fabrick.exercize.banker.dto.TransactionsRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferResponseDTO;
import it.fabrick.exercize.banker.services.banker.BankerService;
import it.fabrick.exercize.banker.web.response.ResponseCode;
import it.fabrick.exercize.banker.web.response.impl.ResponseContentWrapper;
import it.fabrick.exercize.banker.web.rest.BankerController;

/**
 * @author emiliano.bossi
 */
@Component
public class BankerControllerImpl implements BankerController {

    private BankerService bankerService;

    /**
     * @param bankerService
     */
    @Autowired
    public BankerControllerImpl(BankerService bankerService) {
        this.bankerService = bankerService;
    }

    @Override
    public ResponseEntity<ResponseContentWrapper<String>> balance(Long accountId) {
        Optional<String> balance = bankerService.balance(accountId);
        ResponseContentWrapper<String> rcw = balance.map(result -> {
            return new ResponseContentWrapper<String>(ResponseCode.OK, result);
        }).orElse(new ResponseContentWrapper<String>(ResponseCode.NO_RESULT));
        return ResponseEntity.ok(rcw);
    }

    @Override
    public ResponseEntity<ResponseContentWrapper<WireTransferResponseDTO>> wireTransfer(WireTransferRequestDTO dto) {
        Optional<WireTransferResponseDTO> respDto = bankerService.wireTransfer(dto);
        ResponseContentWrapper<WireTransferResponseDTO> rcw = respDto.map(result -> {
            return new ResponseContentWrapper<WireTransferResponseDTO>(ResponseCode.OK, result);
        }).orElse(new ResponseContentWrapper<WireTransferResponseDTO>(ResponseCode.NO_RESULT));
        return ResponseEntity.ok(rcw);
    }

    @Override
    public ResponseEntity<ResponseContentWrapper<Collection<Map<String, Object>>>> transactions(TransactionsRequestDTO dto) {
        Optional<Collection<Map<String, Object>>> transactions = bankerService.transactions(dto);
        ResponseContentWrapper<Collection<Map<String, Object>>> rcw = transactions.map(results -> {
            if (!results.isEmpty())
                return new ResponseContentWrapper<Collection<Map<String, Object>>>(ResponseCode.OK, results);
            else
                return new ResponseContentWrapper<Collection<Map<String, Object>>>(ResponseCode.NO_RESULT);
        }).orElse(new ResponseContentWrapper<Collection<Map<String, Object>>>(ResponseCode.NO_RESULT));
        return ResponseEntity.ok(rcw);
    }
}
