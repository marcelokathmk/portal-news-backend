package br.com.portal.portalbackend.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Menu;
import br.com.portal.portalbackend.model.entity.adm.Modulo;
import br.com.portal.portalbackend.model.entity.adm.Perfil;
import br.com.portal.portalbackend.model.entity.adm.Usuario;
import br.com.portal.portalbackend.repository.adm.MenuRepository;
import br.com.portal.portalbackend.repository.adm.ModuloRepository;
import br.com.portal.portalbackend.repository.adm.PerfilRepository;
import br.com.portal.portalbackend.repository.adm.UsuarioRepository;

@Service
public class DatabaseService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private ModuloRepository moduloRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private BCryptPasswordEncoder peEncoder;
	
	public void instantiateDataBase() {
		Perfil perfil = new Perfil("Admin", true);
		perfilRepository.save(perfil);
		
		Modulo moduloAdm = new Modulo();
		moduloAdm.setDescricao("Módulo Administrativo");
		
		Modulo moduloPortal = new Modulo();
		moduloPortal.setDescricao("Módulo Portal");
		
		moduloRepository.saveAll(Arrays.asList(moduloAdm, moduloPortal));
		
		Menu menu1 = new Menu();
		menu1.setDescricao("Usuários");
		menu1.setModulo(moduloAdm);
		menu1.setPerfil(perfil);
		
		Menu menu2 = new Menu();
		menu2.setDescricao("Perfis");
		menu2.setModulo(moduloAdm);
		menu2.setPerfil(perfil);
		
		menuRepository.saveAll(Arrays.asList(menu1, menu2));
		
		Usuario usuario = new Usuario("marcelokath", peEncoder.encode("123"), true);
		usuario.getPerfis().add(perfil);
		usuarioRepository.save(usuario);
	}
}