package br.com.portal.portalbackend.handler.adm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.portalbackend.model.entity.adm.Menu;
import br.com.portal.portalbackend.model.entity.adm.converter.MenuConverter;
import br.com.portal.portalbackend.model.entity.adm.dto.MenuDTO;
import br.com.portal.portalbackend.services.adm.MenuService;

@RestController
@RequestMapping(value = "/menu")
public class MenuHandler {

	@Autowired
	private MenuService service;
	
	@GetMapping()
	public ResponseEntity<List<MenuDTO>> buscarMenusUsuario(@RequestParam(name = "id_modulo") Long moduloId, @RequestParam(name = "id_perfil") List<Long> perfis){
		List<Menu> menus = service.buscarMenusDoUsuario(moduloId, perfis);
		if	(menus != null && !menus.isEmpty()) {
			return ResponseEntity.ok().body(MenuConverter.entityToDTO(menus));
		}
		return ResponseEntity.noContent().build();
	}
}
