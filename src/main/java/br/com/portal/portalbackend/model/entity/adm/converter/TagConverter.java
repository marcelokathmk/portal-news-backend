package br.com.portal.portalbackend.model.entity.adm.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.portal.portalbackend.model.entity.adm.Tag;
import br.com.portal.portalbackend.model.entity.adm.dto.TagDTO;

public class TagConverter {

	public static TagDTO fromEntityToDTO(Tag tag) {
		TagDTO dto = new TagDTO();
		BeanUtils.copyProperties(tag, dto);
		return dto;
	}
	
	public static List<TagDTO> fromEntityToDTO(List<Tag> tags){
		List<TagDTO> dtos = new ArrayList<TagDTO>(tags.size());
		for	(Tag tag: tags) {
			dtos.add(fromEntityToDTO(tag));
		}
		return dtos;
	}
}
