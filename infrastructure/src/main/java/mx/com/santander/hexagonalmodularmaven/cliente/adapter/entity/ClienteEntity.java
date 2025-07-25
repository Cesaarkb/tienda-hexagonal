package mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nombre;
private String apellido;
private String email;
private String telefono;
private String direccion;

}
