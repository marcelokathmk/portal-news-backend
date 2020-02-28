package br.com.portal.portalbackend.repository.adm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portal.portalbackend.model.entity.adm.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

	public List<Menu> findByModuloIdAndPerfilIdIn(Long idModulo, List<Long> idPerfil);
}
