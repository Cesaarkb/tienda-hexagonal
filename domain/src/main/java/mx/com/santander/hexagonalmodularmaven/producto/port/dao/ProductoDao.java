package mx.com.santander.hexagonalmodularmaven.producto.port.dao;

import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

public interface ProductoDao {

    Producto getbyId(Long id);

}
