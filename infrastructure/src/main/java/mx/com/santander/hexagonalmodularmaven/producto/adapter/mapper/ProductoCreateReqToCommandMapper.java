package mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.rest.controller.dto.ProductoCreateRequest;

@Mapper(componentModel = "spring")
@Component
public interface ProductoCreateReqToCommandMapper {

    @Mapping(source="nombre", target="nombre")
    @Mapping(source="precio", target="precio")
    @Mapping(source="stock", target="stock")
    ProductoCreateCommand command(ProductoCreateRequest request);
}
