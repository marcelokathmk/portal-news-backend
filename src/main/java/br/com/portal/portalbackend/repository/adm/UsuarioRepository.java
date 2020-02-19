package br.com.portal.portalbackend.repository.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.portal.portalbackend.model.entity.adm.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Transactional(readOnly = true)
	public Usuario findByUsuario(String usuario);
}
