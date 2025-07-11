package mx.com.santander.hexagonalmodularmaven.cliente.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.cliente.model.dto.command.ClienteCreateCommand;
import mx.com.santander.hexagonalmodularmaven.cliente.rest.controller.dto.ClienteCreateRequest;

@Mapper(componentModel = "spring")
@Component
public interface ClienteCreateReqToCommandMapper {

    @Mapping(source="nombre", target="nombre")
    @Mapping(source="apellido", target="apellido")
    @Mapping(source="email", target="email")
    @Mapping(source="direccion", target="direccion")
    ClienteCreateCommand toCreateCommand(ClienteCreateRequest request);
}
