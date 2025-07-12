package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.mappermanual;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.ProductoVendidoEntity;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.VentaCreateCommand;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;
import mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto.VentaCreateRequest;

@RequiredArgsConstructor
@Component
public class ManualVentaMapper {

    private final ManualProductoVendidoMapper manualProductoVendidoMapper;

    public VentaCreateCommand toCommand(VentaCreateRequest request) {
        return new VentaCreateCommand(
                request.getIdCliente(),
                manualProductoVendidoMapper.toCommand(request.getProductosVendidos())

        );
    }

    public VentaEntity domToEntity(Venta venta) {

        VentaEntity ventaEntity = new VentaEntity();
        ventaEntity.setClienteId(venta.getClienteId());
        ventaEntity.setFechaCompra(venta.getFechaCompra());
        ventaEntity.setPrecioTotal(venta.getPrecioTotal());

        List<ProductoVendidoEntity> productos = manualProductoVendidoMapper
        .toEntity(venta.getProductosVendidos(),
                ventaEntity);
        ventaEntity.setProductosVendidos(productos);

        return ventaEntity;

        // return new VentaEntity(
        // domain.getId(),
        // manualProductoVendidoMapper.toEntity(domain.getProductosVendidos()),
        // domain.getClienteId(),
        // domain.getPrecioTotal(),
        // domain.getFechaCompra());
    }

  

}
