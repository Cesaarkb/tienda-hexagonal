package mx.com.santander.hexagonalmodularmaven.cliente.rest.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateRequest {
    @NotBlank(message="El nombre no debe estar vacio")
    private String nombre;
    @NotBlank(message="El apellido no debe de estar vacio")
    private String apellido;
    @NotBlank(message="El email no debe estar vacio")
    @Email(message="debes ingresar un correo valido")
    private String email;
    @NotBlank(message="El telefono no debe estar vacio")
    private String telefono;
    @NotBlank(message="La dirección no debe ir vacia")
    private String direccion;

}
