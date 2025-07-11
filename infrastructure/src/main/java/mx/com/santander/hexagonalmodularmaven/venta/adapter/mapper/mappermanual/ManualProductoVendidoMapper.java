package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.mappermanual;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.ProductoVendidoEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.ProductoVendidoCommand;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.ProductoVendido;
import mx.com.santander.hexagonalmodularmaven.venta.rest.controller.dto.ProductoVendidoRequest;

@Component
public class ManualProductoVendidoMapper {

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
                ent.getId(),
                ent.getNombre(),
                ent.getPrecioUnitario(),
                ent.getCantidad())
        ).toList();
    }

    public List<ProductoVendidoEntity> toEntity(List<ProductoVendido> domain){
        return domain.stream().map(
            dom -> new ProductoVendidoEntity(
                dom.getProductoId(),
                dom.getNombre(),
                dom.getPrecioUnitario(),
                dom.getCantidad())
        ).toList();
    }

}
