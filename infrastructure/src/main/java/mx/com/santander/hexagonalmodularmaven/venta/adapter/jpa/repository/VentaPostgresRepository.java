package mx.com.santander.hexagonalmodularmaven.venta.adapter.jpa.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.jpa.VentaSpringJpaAdapterRepository;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.VentaDomToEntityMapper;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.VentaEntityToDomainMapper;
import mx.com.santander.hexagonalmodularmaven.venta.adapter.mapper.mappermanual.ManualVentaMapper;
import mx.com.santander.hexagonalmodularmaven.venta.model.entity.Venta;
import mx.com.santander.hexagonalmodularmaven.venta.port.repository.VentaRepository;

@Repository
@RequiredArgsConstructor
public class VentaPostgresRepository implements VentaRepository{

    private final VentaSpringJpaAdapterRepository ventaSpringJpaAdapterRepository;
    private final VentaDomToEntityMapper ventaDomToEntityMapper;
    private final VentaEntityToDomainMapper ventaEntityToDomainMapper;
    private final ManualVentaMapper ventaManualMapper;    

    @Override
    public Venta saveVenta(Venta venta) {   
        VentaEntity entity = ventaManualMapper.domToEntity(venta);
        ventaSpringJpaAdapterRepository.save(entity);
        return ventaManualMapper.entityToDomain(entity);
    }

}
