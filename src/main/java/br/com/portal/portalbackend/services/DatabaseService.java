package br.com.portal.portalbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Perfil;
import br.com.portal.portalbackend.model.entity.adm.Usuario;
import br.com.portal.portalbackend.repository.adm.PerfilRepository;
import br.com.portal.portalbackend.repository.adm.UsuarioRepository;

@Service
public class DatabaseService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private BCryptPasswordEncoder peEncoder;
	
	public void instantiateDataBase() {
		Perfil perfil = new Perfil("Admin", true);
		perfilRepository.save(perfil);
		
		Usuario usuario = new Usuario("marcelokath", peEncoder.encode("123"), true);
		usuario.getPerfis().add(perfil);
		usuarioRepository.save(usuario);
	}
}