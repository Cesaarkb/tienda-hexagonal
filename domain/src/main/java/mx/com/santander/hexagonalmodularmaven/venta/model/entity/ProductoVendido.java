package mx.com.santander.hexagonalmodularmaven.venta.model.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductoVendido {

    private Long id;
    private String nombre;
    private BigDecimal precioUnitario;
    private int cantidad;

    
    public BigDecimal calcularSubtotal() {
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

}
