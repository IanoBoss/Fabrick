/**
 * 
 */
package it.fabrick.exercize.banker.services.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.fabrick.exercize.banker.services.client.request.RequestEntityBuilder;

/**
 * @author emiliano.bossi
 */
@Service
public interface RestClientHelper {

    <T> ResponseEntity<T> post(RequestEntityBuilder builder, Class<T> expectedClassRes);

    <T> ResponseEntity<T> post(RequestEntityBuilder builder, ParameterizedTypeReference<T> expectedTypedClassRes);

    <T> ResponseEntity<T> get(RequestEntityBuilder builder, Class<T> expectedClassRes);

    <T> ResponseEntity<T> get(RequestEntityBuilder builder, ParameterizedTypeReference<T> expectedTypedClassRes);


}
