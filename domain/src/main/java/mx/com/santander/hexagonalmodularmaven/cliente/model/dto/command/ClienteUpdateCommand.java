package mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteUpdateCommand {
	
	private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

}
