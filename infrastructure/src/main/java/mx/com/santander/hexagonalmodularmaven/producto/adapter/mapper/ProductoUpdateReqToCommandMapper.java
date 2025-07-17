package mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.producto.model.dto.command.ProductoUpdateCommand;
import mx.com.santander.hexagonalmodularmaven.producto.rest.controller.dto.ProductoUpdateRequest;

@Mapper(componentModel = "spring")
@Component
public interface ProductoUpdateReqToCommandMapper {
    @Mapping(source="nombre", target="nombre")
    @Mapping(source="precio", target="precio")
    @Mapping(source="stock", target="stock")
    ProductoUpdateCommand command(ProductoUpdateRequest request);

}
