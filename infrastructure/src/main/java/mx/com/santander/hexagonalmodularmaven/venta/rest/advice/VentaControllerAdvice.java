package mx.com.santander.hexagonalmodularmaven.venta.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.santander.hexagonalmodularmaven.venta.ProductoIdNotFoundException;

@ControllerAdvice
public class VentaControllerAdvice {

     @ExceptionHandler(ProductoIdNotFoundException.class)
    public ResponseEntity<String> clienteNotFound(ProductoIdNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
