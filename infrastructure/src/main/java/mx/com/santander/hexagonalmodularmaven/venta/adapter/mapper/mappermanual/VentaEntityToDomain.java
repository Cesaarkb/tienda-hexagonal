package mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.mappermanual;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.ProductoVendidoEntity;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.ProductoVendido;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;

@RequiredArgsConstructor
@Component
public class VentaEntityToDomain {

      public Venta entityToDomain(VentaEntity entity) {
        List<ProductoVendido> productos = toDomainWithoutVenta(entity.getProductosVendidos());

        Venta venta = new Venta(
                entity.getId(),
                entity.getClienteId(),
                productos, // se asignan aquí
                entity.getPrecioTotal(),
                entity.getFechaCompra()
        );

        productos.forEach(prod -> prod.setVenta(venta));

        return venta;
    }

    private List<ProductoVendido> toDomainWithoutVenta(List<ProductoVendidoEntity> entities) {
        return entities.stream().map(
            ent -> new ProductoVendido(
                ent.getProductoId(),
                ent.getNombre(),
                ent.getPrecioUnitario(),
                ent.getCantidad(),
                null 
            )
        ).toList();
    }

}
