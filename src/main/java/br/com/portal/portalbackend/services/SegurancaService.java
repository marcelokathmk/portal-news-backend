package br.com.portal.portalbackend.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Usuario;
import br.com.portal.portalbackend.model.entity.seguranca.UsuarioSeguranca;
import br.com.portal.portalbackend.repository.adm.UsuarioRepository;

@Service
public class SegurancaService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsuario(username);
		if	(usuario == null) {
			throw new EntityNotFoundException("Usuário "+ username + " não localizado");
		}else if	(!usuario.getAtivo()) {
			throw new EntityNotFoundException("Usuário "+ username + " não está ativo");
		}
		
		return new UsuarioSeguranca(usuario.getId(), usuario.getUsuario(), usuario.getSenha(), usuario.getAtivo(), usuario.getPerfis());
	}
}