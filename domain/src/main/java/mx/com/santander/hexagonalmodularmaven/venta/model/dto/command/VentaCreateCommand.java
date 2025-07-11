package mx.com.santander.hexagonalmodularmaven.venta.model.dto.command;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaCreateCommand {

    private Long idCliente;
    private List<ProductoVendidoCommand> productosVendidos;

}
