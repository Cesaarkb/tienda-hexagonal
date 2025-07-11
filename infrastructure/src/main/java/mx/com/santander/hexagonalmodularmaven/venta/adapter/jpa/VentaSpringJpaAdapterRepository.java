package mx.com.santander.hexagonalmodularmaven.venta.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.venta.adapter.entity.VentaEntity;

@Repository
public interface VentaSpringJpaAdapterRepository extends JpaRepository<VentaEntity, Long>{

}
