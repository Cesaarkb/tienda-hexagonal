package mx.com.santander.hexagonalmodularmaven.cliente.model;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(){
        super("Email registrado con anterioridad");
    }

}
