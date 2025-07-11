package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = ProductoVendidoMapper.class)
@Component
public interface VentaDomToEntityMapper {

    // @Mapping(source="id", target="id")
    // @Mapping(source="clienteId", target="clienteId")
    // @Mapping(source="productosVendidos", target="productosVendidos")
    // @Mapping(source="precioTotal", target="precioTotal")
    // @Mapping(source="fechaCompra", target="fechaCompra")
    // VentaEntity toEntity(Venta dominio);

    //  @AfterMapping
    // default void setVentaEnProductos(@MappingTarget VentaEntity ventaEntity) {
    //     if (ventaEntity.getProductosVendidos() != null) {
    //         ventaEntity.getProductosVendidos().forEach(pv -> pv.setVenta(ventaEntity));
    //     }
    // }

}
