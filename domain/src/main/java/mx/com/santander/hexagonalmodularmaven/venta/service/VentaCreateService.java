package mx.com.santander.hexagonalmodularmaven.venta.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.VentaCreateCommand;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.ProductoVendido;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;
import mx.com.santander.hexagonalmodularmaven.venta.port.repository.VentaRepository;

@RequiredArgsConstructor
public class VentaCreateService {

    private final VentaRepository ventaRepository;
    private final ProductoDao productoDao;

    public Venta execute(VentaCreateCommand command){
        List<ProductoVendido> productosVendidos = command.getProductosVendidos().stream()
        .map(prodVend -> {
            Producto producto = productoDao.getbyId(prodVend.getIdProducto());
        return new ProductoVendido(
            prodVend.getIdProducto(),
            producto.getNombre(),
            producto.getPrecio(),
            prodVend.getCantidad());
    }).toList();
        Venta venta = new Venta(command.getIdCliente(), productosVendidos);
        return ventaRepository.saveVenta(venta);
    
    }
}
