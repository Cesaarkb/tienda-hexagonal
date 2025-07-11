package mx.com.santander.hexagonalmodularmaven.venta.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.venta.model.dto.ProductoVendidoDto;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.VentaDto;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.ProductoVendido;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;

@Component
public class ManualDomToDtoMapper {

        public VentaDto toDto(Venta venta){
        return new VentaDto(
            venta.getId(),
            venta.getClienteId(),
            prodVenDomtoDto(venta.getProductosVendidos()),
            venta.getPrecioTotal(),
            venta.getFechaCompra()
        );
    }

        public List<ProductoVendidoDto> prodVenDomtoDto(List<ProductoVendido> domain){
        return domain.stream().map(
        dom -> new ProductoVendidoDto(
            dom.getProductoId(),
            dom.getNombre(),
            dom.getCantidad(),
            dom.getPrecioUnitario())
        ).toList();
    }


}
