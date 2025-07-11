package mx.com.santander.hexagonalmodularmaven.cliente.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    private Long id;
    private  String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

   public Cliente(String nombre, String apellido, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

}
