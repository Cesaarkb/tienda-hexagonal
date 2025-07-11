package mx.com.santander.hexagonalmodularmaven.producto;

public class StockInsuficienteException extends RuntimeException{
    public StockInsuficienteException(){
        super("El stock actual no es suficiente");
    }

}
