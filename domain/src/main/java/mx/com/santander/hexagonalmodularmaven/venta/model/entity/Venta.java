package mx.com.santander.hexagonalmodularmaven.venta.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venta {

    private Long id;
    private Long clienteId;
    private List<ProductoVendido> productosVendidos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;

    
       public Venta(Long clienteId, List<ProductoVendido> productosVendidos) {
        this.clienteId = clienteId;
        this.productosVendidos = productosVendidos;
        this.fechaCompra = LocalDateTime.now();
        this.precioTotal = calcularPrecioTotal();
    }

    private BigDecimal calcularPrecioTotal() {
        return productosVendidos.stream()
            .map(ProductoVendido::calcularSubtotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
