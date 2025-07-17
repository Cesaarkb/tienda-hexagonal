package mx.com.santander.hexagonalmodularmaven.producto.port.dao;

import java.util.List;

import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;

public interface ProductoDao {

    Producto getbyId(Long id);
    List<Producto> getAll();

}
