package mx.com.santander.hexagonalmodularmaven.venta.port.repository;

import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;

public interface VentaRepository {

    Venta saveVenta(Venta venta);

}
