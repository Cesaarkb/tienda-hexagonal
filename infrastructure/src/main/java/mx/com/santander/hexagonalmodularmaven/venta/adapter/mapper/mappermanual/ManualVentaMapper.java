package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.mappermanual;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.VentaCreateCommand;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;
import mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto.VentaCreateRequest;

@RequiredArgsConstructor
@Component
public class ManualVentaMapper {

    private final ManualProductoVendidoMapper manualProductoVendidoMapper;

    public VentaCreateCommand toCommand(VentaCreateRequest request){
        return new VentaCreateCommand(
            request.getIdCliente(),
            manualProductoVendidoMapper.toCommand(request.getProductosVendidos())
            
        );
    }

    public VentaEntity domToEntity(Venta domain){
        return new VentaEntity(
        domain.getId(),
        manualProductoVendidoMapper.toEntity(domain.getProductosVendidos()), 
        domain.getClienteId(), 
        domain.getPrecioTotal(), 
        domain.getFechaCompra());
    }

    public Venta entityToDomain(VentaEntity entity){
        return new Venta(
            entity.getClienteId(),
            manualProductoVendidoMapper.toDomain(entity.getProductosVendidos()));
    }

}
