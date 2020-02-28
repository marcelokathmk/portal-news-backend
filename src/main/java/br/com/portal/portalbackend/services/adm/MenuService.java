package br.com.portal.portalbackend.services.adm;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Menu;
import br.com.portal.portalbackend.repository.adm.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository repository;
	
	public List<Menu> buscarMenusDoUsuario(Long moduloId, List<Long> perfis){
		List<Menu> menus = repository.findByModuloIdAndPerfilIdIn(moduloId, perfis);
		if	(menus == null || menus.isEmpty()) {
			throw new EntityNotFoundException("Não foi possível obter os menus do usuário.");
		}
		return menus;
	}
}
