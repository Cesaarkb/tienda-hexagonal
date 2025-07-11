package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.ProductoVendidoEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.ProductoVendido;

@Mapper(componentModel = "spring")
@Component
public interface ProductoVendidoMapper {

     @Mapping(target = "venta", ignore = true)
    ProductoVendidoEntity toEntity(ProductoVendido domain);

    List<ProductoVendidoEntity> toEntityList(List<ProductoVendido> domainList);

}
