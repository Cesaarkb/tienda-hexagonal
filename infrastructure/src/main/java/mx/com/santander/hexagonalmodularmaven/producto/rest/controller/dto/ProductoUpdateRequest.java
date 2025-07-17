package mx.com.santander.hexagonalmodularmaven.producto.rest.controller.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoUpdateRequest {
	
    @NotBlank(message="El nombre no de estar vacio")
    private String nombre;
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", inclusive = true, message = "El precio debe ser mayor a cero")
    private BigDecimal precio;
    @Min(value=1, message="El stock debe ser de al menos 1 pieza")
    private int stock;


}
