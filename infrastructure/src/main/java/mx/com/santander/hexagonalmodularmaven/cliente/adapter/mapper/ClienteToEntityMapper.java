package mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;
import mx.com.santander.hexagonalmodularmaven.cliente.model.entity.Cliente;

@Mapper(componentModel = "spring")
@Component
public interface ClienteToEntityMapper {

    @Mapping(source="id", target="id")
    @Mapping(source="nombre", target="nombre")
    @Mapping(source="apellido", target="apellido")
    @Mapping(source="email", target="email")
    @Mapping(source="direccion", target="direccion")
    ClienteEntity toEntity(Cliente domain);


}
