package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.VentaCreateCommand;
import mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto.VentaCreateRequest;

@Mapper(componentModel = "spring")
@Component
public interface VentaCreateReqToCommandMapper {

    @Mapping(source="idCliente", target="idCliente")
    @Mapping(source="productosVendidos", target="productosVendidos")
    VentaCreateCommand toCommand(VentaCreateRequest request);

}
