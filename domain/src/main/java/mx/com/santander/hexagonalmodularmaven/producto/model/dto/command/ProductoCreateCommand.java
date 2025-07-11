package mx.com.santander.hexagonalmodularmaven.producto.model.dto.command;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCreateCommand {

    private String nombre;
    private BigDecimal precio;
    private int stock;

}
