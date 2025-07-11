package mx.com.santander.hexagonalmodularmaven.venta.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.venta.ProductoIdNotFoundException;
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
        .map(cdm -> {
            Producto producto = productoDao.getbyId(cdm.getId());
            if (producto == null) {
                throw new ProductoIdNotFoundException(cdm.getId());
            }

            return new ProductoVendido(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                cdm.getCantidad()
            );
        })
        .collect(Collectors.toList());

    Venta venta = new Venta(command.getIdCliente(), productosVendidos);
    return ventaRepository.saveVenta(venta);
        
    
    }
}
