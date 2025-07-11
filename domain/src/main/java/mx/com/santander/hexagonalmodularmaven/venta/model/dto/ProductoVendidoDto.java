package mx.com.santander.hexagonalmodularmaven.venta.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoVendidoDto {

    private Long id;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precioUnitario;

}
