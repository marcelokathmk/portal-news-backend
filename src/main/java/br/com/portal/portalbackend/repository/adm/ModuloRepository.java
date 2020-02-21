package br.com.portal.portalbackend.repository.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portal.portalbackend.model.entity.adm.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{

}
