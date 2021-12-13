/**
 * 
 */
package it.fabrick.exercize.banker.services.banker;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.fabrick.exercize.banker.dto.TransactionsRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferRequestDTO;
import it.fabrick.exercize.banker.dto.WireTransferResponseDTO;

/**
 * @author emiliano.bossi
 */
@Service
public interface BankerService {

    Optional<String> balance(Long accountId);

    Optional<WireTransferResponseDTO> wireTransfer(WireTransferRequestDTO dto);

    Optional<Collection<Map<String, Object>>> transactions(TransactionsRequestDTO dto);
}
