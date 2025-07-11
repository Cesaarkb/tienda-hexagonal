package mx.com.santander.hexagonalmodularmaven.producto.adapter.jpa.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.entity.ProductoEntity;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.jpa.ProductoSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoDomToEntityMapper;
import mx.com.santander.hexagonalmodularmaven.producto.adapter.mapper.ProductoEntityToDomainMapper;
import mx.com.santander.hexagonalmodularmaven.producto.model.entity.Producto;
import mx.com.santander.hexagonalmodularmaven.producto.port.repository.ProductoRepository;

@Repository
@RequiredArgsConstructor
public class ProductoPostgresRepository implements ProductoRepository{

    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;
    private final ProductoDomToEntityMapper productoDomToEntityMapper;
    private final ProductoEntityToDomainMapper productoEntityToDomainMapper;
    
    @Override
    public Producto saveProducto(Producto producto) {
        ProductoEntity entity = productoDomToEntityMapper.toEntity(producto);
        productoSpringJpaAdapterRepository.save(entity);
        return productoEntityToDomainMapper.toDomain(entity);
    }

}
