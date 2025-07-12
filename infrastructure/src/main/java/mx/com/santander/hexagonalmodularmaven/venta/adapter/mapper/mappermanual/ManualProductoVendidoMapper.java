package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.mappermanual;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.ProductoVendidoEntity;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.ProductoVendidoCommand;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.ProductoVendido;
import mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto.ProductoVendidoRequest;

@Component
@RequiredArgsConstructor
public class ManualProductoVendidoMapper {
    private final VentaEntityToDomain ventaEntityToDomain;

    public List<ProductoVendidoCommand> toCommand(List<ProductoVendidoRequest> request){
        return request.stream().map(
            req -> new ProductoVendidoCommand(
                req.getIdProducto(),
                req.getCantidad())
        ).toList();
    }

    public List<ProductoVendido> toDomain(List<ProductoVendidoEntity> entity){
        
        return entity.stream().map(
            ent -> new ProductoVendido(
                ent.getProductoId(),
                ent.getNombre(),
                ent.getPrecioUnitario(),
                ent.getCantidad(),
                ventaEntityToDomain.entityToDomain(ent.getVenta())
                )
        ).toList();
    }

    public List<ProductoVendidoEntity> toEntity(List<ProductoVendido> domain, VentaEntity ventaEntity){
         return domain.stream().map(dom -> {
        ProductoVendidoEntity entity = new ProductoVendidoEntity();
        entity.setProductoId(dom.getProductoId());
        entity.setNombre(dom.getNombre());
        entity.setPrecioUnitario(dom.getPrecioUnitario());
        entity.setCantidad(dom.getCantidad());
        entity.setVenta(ventaEntity);
        entity.setId(null);
        return entity;
    }).toList();


        // return domain.stream().map(
        //     dom -> new ProductoVendidoEntity(
        //         dom.getProductoId(),
        //         dom.getNombre(),
        //         dom.getPrecioUnitario(),
        //         dom.getCantidad())
        // ).toList();
    }

}
