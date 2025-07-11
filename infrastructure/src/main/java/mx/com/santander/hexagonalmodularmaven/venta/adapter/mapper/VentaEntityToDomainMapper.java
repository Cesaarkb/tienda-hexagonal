package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;

@Mapper(componentModel = "spring")
@Component
public interface VentaEntityToDomainMapper {

    @Mapping(source="id", target="id")
    @Mapping(source="clienteId", target="clienteId")
    @Mapping(source="productosVendidos", target="productosVendidos")
    @Mapping(source="precioTotal", target="precioTotal")
    @Mapping(source="fechaCompra", target="fechaCompra")
    Venta Todomain(VentaEntity entity);

}
