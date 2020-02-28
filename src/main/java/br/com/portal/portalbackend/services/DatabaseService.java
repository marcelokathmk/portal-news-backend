package br.com.portal.portalbackend.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Menu;
import br.com.portal.portalbackend.model.entity.adm.Modulo;
import br.com.portal.portalbackend.model.entity.adm.Perfil;
import br.com.portal.portalbackend.model.entity.adm.Usuario;
import br.com.portal.portalbackend.model.entity.adm.enums.Icones;
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
		Modulo moduloAdm = new Modulo();
		moduloAdm.setDescricao("Módulo Administrativo");
		
		Modulo moduloPortal = new Modulo();
		moduloPortal.setDescricao("Módulo Portal");
		
		moduloRepository.saveAll(Arrays.asList(moduloAdm, moduloPortal));
		
		Perfil perfil = new Perfil("Admin", true);
		Perfil perfilWeb = new Perfil("Web", true);
		perfilRepository.saveAll(Arrays.asList(perfil, perfilWeb));
		
		Menu menu1 = new Menu();
		menu1.setDescricao("Usuários");
		menu1.setModulo(moduloAdm);
		menu1.setPerfil(perfil);
		menu1.setUrl("/dashboardadm/usuarios");
		menu1.setIcone(Icones.ACCOUNT_CIRCLE);
		
		Menu menu2 = new Menu();
		menu2.setDescricao("Perfis");
		menu2.setModulo(moduloAdm);
		menu2.setPerfil(perfil);
		menu2.setUrl("/dashboardadm/perfis");
		menu2.setIcone(Icones.SUPERVISED_USER_CIRCLE);
		
		Menu menu3 = new Menu();
		menu3.setDescricao("Posts");
		menu3.setModulo(moduloAdm);
		menu3.setPerfil(perfilWeb);
		menu3.setUrl("/dashboardadm/posts");
		menu3.setIcone(Icones.ALL_INBOX);
		
		menuRepository.saveAll(Arrays.asList(menu1, menu2, menu3));
		
		Usuario usuario = new Usuario("marcelokath", peEncoder.encode("123"), true);
		usuario.getPerfis().add(perfil);
		usuario.getPerfis().add(perfilWeb);
		usuarioRepository.save(usuario);
	}
}