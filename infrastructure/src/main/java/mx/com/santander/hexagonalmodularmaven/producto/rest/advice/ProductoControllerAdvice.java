package mx.com.santander.hexagonalmodularmaven.producto.rest.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ProductoControllerAdvice {

  @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<String> clienteNotFound(ProductoNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
