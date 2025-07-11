package mx.com.santander.hexagonalmodularmaven.cliente.rest.advice;

public class ClienteNotFoundException extends RuntimeException{

    public ClienteNotFoundException(){
        super("El cliente no ha sido encontrado");
    }

}
