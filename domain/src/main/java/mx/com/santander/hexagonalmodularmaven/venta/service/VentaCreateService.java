package mx.com.santander.hexagonalmodularmaven.venta.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;
import mx.com.santander.hexagonalmodularmaven.venta.model.dto.command.VentaCreateCommand;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.ProductoVendido;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;
import mx.com.santander.hexagonalmodularmaven.venta.port.repository.VentaRepository;

@RequiredArgsConstructor
public class VentaCreateService {

	private final VentaRepository ventaRepository;
	private final ProductoRepository productoRepository;
	private final ProductoDao productoDao;

	public Venta execute(VentaCreateCommand command) {

		Venta venta = new Venta(command.getIdCliente(), new ArrayList<>());

		List<ProductoVendido> productoVendidoDomain = command.getProductosVendidos().stream()
				.map(prodVenDom -> {
			Producto producto = productoDao.getbyId(prodVenDom.getIdProducto());
			producto.disminuirStock(prodVenDom.getCantidad());
			productoRepository.updateProducto(producto);
			ProductoVendido productoVendido = new ProductoVendido(prodVenDom.getIdProducto(), 
					producto.getNombre(),
					producto.getPrecio(), prodVenDom.getCantidad(), venta);
			return productoVendido;
		}).toList();
		
		venta.setProductosVendidos(productoVendidoDomain);
		
		BigDecimal precioTotal = venta.getProductosVendidos().stream()
				.map(ProductoVendido::calcularSubtotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		venta.setPrecioTotal(precioTotal);

		return ventaRepository.saveVenta(venta);
	}
}
