package mx.com.santander.hexagonalmodularmaven.venta.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Venta {

    private Long id;
    private Long clienteId;
    private List<ProductoVendido> productosVendidos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;


        //CONSTRUCTOR PARA CREAR UNA VENTA
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
