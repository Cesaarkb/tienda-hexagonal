package mx.com.santander.hexagonalmodularmaven.producto.rest.advice;

public class ProductoNotFoundException extends RuntimeException{
    public ProductoNotFoundException(){
        super("Producto no encontrado");
    }

}
