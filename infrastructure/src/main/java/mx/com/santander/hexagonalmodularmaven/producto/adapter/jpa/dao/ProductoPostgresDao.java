package mx.com.santander.hexagonalmodularmaven.producto.adapter.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.jpa.ProductoSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoEntityToDomainMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.dao.ProductoDao;
import mx.com.santander.hexagonalmodularmaven.producto.rest.advice.ProductoNotFoundException;

@Repository
@RequiredArgsConstructor
public class ProductoPostgresDao implements ProductoDao{

    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;
    private final ProductoEntityToDomainMapper productoEntityDomainMapper;
    
    @Override
    public Producto getbyId(Long id) {
        ProductoEntity entity = productoSpringJpaAdapterRepository
        .findById(id)
        .orElseThrow(ProductoNotFoundException::new);

        return productoEntityDomainMapper.toDomain(entity);
    }

	@Override
	public List<Producto> getAll() {
		List<ProductoEntity> productosEntity =  productoSpringJpaAdapterRepository.findAll();
		List<Producto> productosDom = productosEntity.stream()
				.map(productoEntityDomainMapper::toDomain)
				.toList();
		return productosDom;
	}

    

}
