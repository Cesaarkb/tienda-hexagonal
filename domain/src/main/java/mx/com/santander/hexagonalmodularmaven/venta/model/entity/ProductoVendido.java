package mx.com.santander.hexagonalmodularmaven.venta.model.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductoVendido {

    private Long productoId;
    private String nombre;
    private BigDecimal precioUnitario;
    private int cantidad;
    private Venta venta;

    //CONSTRUCTOR CON TODOS LOS PARAMETROS
    public ProductoVendido(Long productoId, String nombre, BigDecimal precioUnitario, int cantidad, Venta venta){
        this.productoId = productoId;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.venta = venta;
    }

    //CONSTRUCTOR SIN EL PARAMETRO DE VENTA
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
