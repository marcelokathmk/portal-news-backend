package br.com.portal.portalbackend.services.adm;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Usuario;
import br.com.portal.portalbackend.repository.adm.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario getUsuarioPorIdentificador(Long id) {
		Optional<Usuario> optional = repository.findById(id);
		if	(optional.isPresent()) {
			return optional.get();
		}
		throw new EntityNotFoundException("Usuário não encontrado");
	}
}
