package mx.com.santander.hexagonalmodularmaven.producto.port.repository;

import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

public interface ProductoRepository {

    Producto saveProducto(Producto producto);

}
