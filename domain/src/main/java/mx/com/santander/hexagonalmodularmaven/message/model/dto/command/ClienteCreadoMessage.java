package mx.com.santander.hexagonalmodularmaven.message.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteCreadoMessage {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
}
