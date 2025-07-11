package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductoVendidoMapper {

    // @Mapping(target = "venta", ignore = true)
    // @Mapping(target = "id", ignore = true)
    // @Mapping(source="productoId", target="productoId")
    // @Mapping(source="nombre", target="nombre")
    // @Mapping(source="precioUnitario", target="precioUnitario")
    // @Mapping(source="cantidad", target="cantidad")
    // ProductoVendidoEntity toEntity(ProductoVendido domain);

    // List<ProductoVendidoEntity> toEntityList(List<ProductoVendido> domainList);

}
