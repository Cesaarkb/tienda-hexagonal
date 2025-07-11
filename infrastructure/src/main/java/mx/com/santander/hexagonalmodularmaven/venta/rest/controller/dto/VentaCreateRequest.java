package mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaCreateRequest {

    @NotNull(message="Se debe ingresar un Id de cliente")
    @Positive(message="El Id tiene que ser mayor a 0")
    private Long idCliente;
    @Valid
    @NotEmpty(message = "La lista no puede estar vacía")
    private List<@Valid ProductoVendidoRequest> productosVendidos;


}
