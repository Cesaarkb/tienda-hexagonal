package mx.com.santander.hexagonalmodularmaven.cliente.adapter.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.santander.hexagonalmodularmaven.cliente.adapter.entity.ClienteEntity;

public interface ClienteSpringJpaAdapterRepository extends JpaRepository<ClienteEntity, Long>{
 Optional<ClienteEntity> findByEmail(String email); 
}
