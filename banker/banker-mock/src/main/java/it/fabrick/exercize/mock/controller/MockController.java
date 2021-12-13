/**
 * 
 */
package it.fabrick.exercize.mock.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author emiliano.bossi
 */
@RestController
@RequestMapping("/apis")
public class MockController {

    @GetMapping("/gbs-banking-account-cash-v4.0/{accountId}")
    public ResponseEntity<String> balance(@PathVariable Long accountId) {
        return ResponseEntity.ok("2000.00");
    }

    @PostMapping("/gbs-banking-payments-moneyTransfers-v4.0")
    public ResponseEntity<Map<String, String>> wireTransfer(@RequestBody(required = true) Map<String, Object> req) {
        HashMap<String, String> result = new HashMap<>();
        result.put("code", "API000");
        result.put("description", "Errore tecnico  La condizione BP049 non e' prevista per il conto id 14537780");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/gbs-banking-account-cash-v4.0")
    public ResponseEntity<Collection<Map<String, Object>>> transactions(@RequestBody(required = true) Map<String, String> req) {
        final Collection<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        IntStream.range(0, 10).forEach(i -> {
            HashMap<String, Object> result = new HashMap<>();
            result.put("codice", String.format("TEST%d", i));
            result.put("descrizione", String.format("Test risultato n.%d", i));
            result.put("riga", i);
            result.put("data", Calendar.getInstance().getTime());
            results.add(result);
        });
        return ResponseEntity.ok(results);
    }
}
