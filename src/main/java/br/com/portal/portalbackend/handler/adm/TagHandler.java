package br.com.portal.portalbackend.handler.adm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.portalbackend.model.entity.adm.Tag;
import br.com.portal.portalbackend.model.entity.adm.converter.TagConverter;
import br.com.portal.portalbackend.model.entity.adm.dto.TagDTO;
import br.com.portal.portalbackend.services.adm.TagService;

@RestController
@RequestMapping(value = "/tag")
public class TagHandler {

	@Autowired
	private TagService service;
	
	@GetMapping
	public ResponseEntity<List<TagDTO>> buscarTags(){
		List<Tag> tags = service.obterTags();
		if	(tags != null && !tags.isEmpty()) {
			return ResponseEntity.ok().body(TagConverter.fromEntityToDTO(tags));
		}
		return ResponseEntity.noContent().build();
	}
}