package mx.com.santander.hexagonalmodularmaven.venta;

public class ProductoIdNotFoundException extends RuntimeException{
    public ProductoIdNotFoundException(Long id){
        super("Producto con id: " + id + " no fue encontrado");
    }

}
