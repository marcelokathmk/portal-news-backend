package br.com.portal.portalbackend.model.entity.adm.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.portal.portalbackend.model.entity.adm.Categoria;
import br.com.portal.portalbackend.model.entity.adm.dto.CategoriaDTO;

public class CategoriaConverter {

	public static CategoriaDTO fromEntityToDTO(Categoria categoria) {
		CategoriaDTO dto = new CategoriaDTO();
		BeanUtils.copyProperties(categoria, dto);
		return dto;
	}
	
	public static List<CategoriaDTO> fromEntityToDto(List<Categoria> categorias){
		List<CategoriaDTO> dtos = new ArrayList<CategoriaDTO>(categorias.size());
		for	(Categoria categoria: categorias) {
			dtos.add(fromEntityToDTO(categoria));
		}
		return dtos;
	}
}
