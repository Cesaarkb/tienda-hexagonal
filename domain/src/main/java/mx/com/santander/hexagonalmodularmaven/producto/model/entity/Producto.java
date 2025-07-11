package mx.com.santander.hexagonalmodularmaven.producto.model.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.producto.StockInsuficienteException;

@Getter
@Setter
@NoArgsConstructor
public class Producto {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private int stock;


    public Producto(String nombre, BigDecimal precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void disminuirStock(int cantidad){
     if(stock-cantidad < 0){
        throw new StockInsuficienteException();
     }

     this.stock-=cantidad;
    }

}
