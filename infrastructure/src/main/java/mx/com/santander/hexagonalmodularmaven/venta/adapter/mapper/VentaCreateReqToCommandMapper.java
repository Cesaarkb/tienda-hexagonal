package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface VentaCreateReqToCommandMapper {

    // @Mapping(source="idCliente", target="idCliente")
    // @Mapping(source="productosVendidos", target="productosVendidos")
    // VentaCreateCommand toCommand(VentaCreateRequest request);

}
