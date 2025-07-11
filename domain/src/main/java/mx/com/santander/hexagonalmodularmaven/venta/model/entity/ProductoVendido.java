package mx.com.santander.hexagonalmodularmaven.venta.model.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductoVendido {

    private Long productoId;
    private String nombre;
    private BigDecimal precioUnitario;
    private int cantidad;
    private Venta venta;

    public ProductoVendido(Long productoId, String nombre, BigDecimal precioUnitario, int cantidad, Venta venta){
        this.productoId = productoId;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.venta = venta;
    }

        public ProductoVendido(Long productoId, String nombre, BigDecimal precioUnitario, int cantidad){
        this.productoId = productoId;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    
    public BigDecimal calcularSubtotal() {
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

}
