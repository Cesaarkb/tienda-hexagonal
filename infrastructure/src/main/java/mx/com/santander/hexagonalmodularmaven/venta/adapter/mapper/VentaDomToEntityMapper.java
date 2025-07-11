package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;

@Mapper(componentModel = "spring", uses = ProductoVendidoMapper.class)
@Component
public interface VentaDomToEntityMapper {

    @Mapping(source="id", target="id")
    @Mapping(source="clienteId", target="clienteId")
    @Mapping(source="productosVendidos", target="productosVendidos")
    @Mapping(source="precioTotal", target="precioTotal")
    @Mapping(source="fechaCompra", target="fechaCompra")
    VentaEntity toEntity(Venta dominio);

 @AfterMapping
    default void linkProductos(@MappingTarget VentaEntity ventaEntity) {
        if (ventaEntity.getProductosVendidos() != null) {
            ventaEntity.getProductosVendidos()
                .forEach(producto -> producto.setVenta(ventaEntity));
        }
    }

}
