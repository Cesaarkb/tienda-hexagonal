package mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

@Mapper(componentModel = "spring")
@Component
public interface ProductoDomToEntityMapper {

    @Mapping(source="id", target="id")
    @Mapping(source="nombre", target="nombre")
    @Mapping(source="precio", target="precio")
    @Mapping(source="stock", target="stock")
    ProductoEntity toEntity(Producto domain);
}
