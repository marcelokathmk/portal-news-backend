package br.com.portal.portalbackend.model.entity.adm.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.portal.portalbackend.model.entity.adm.Menu;
import br.com.portal.portalbackend.model.entity.adm.dto.MenuDTO;

public class MenuConverter {

	public static List<MenuDTO> entityToDTO(List<Menu> menus){
		List<MenuDTO> menusDTO = new ArrayList<MenuDTO>(menus.size());
		for	(Menu menu: menus) {
			menusDTO.add(entityToDTO(menu));
		}
		return menusDTO;
	}
	
	public static MenuDTO entityToDTO(Menu menu) {
		MenuDTO dto = new MenuDTO();
		BeanUtils.copyProperties(menu, dto);
		return dto;
	}
}
