package mx.com.santander.hexagonalmodularmaven.venta.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {

    private Long Id;
    private Long clienteId;
    private List<ProductoVendidoDto> productosVendidos;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;

}
