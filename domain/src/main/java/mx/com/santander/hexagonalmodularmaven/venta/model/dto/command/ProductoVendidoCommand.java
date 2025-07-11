package mx.com.santander.hexagonalmodularmaven.venta.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoVendidoCommand {

    private Long idProducto;
    private Integer cantidad;

}
