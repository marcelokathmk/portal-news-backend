package br.com.portal.portalbackend.services.adm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Tag;
import br.com.portal.portalbackend.repository.adm.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository repository;
	
	public List<Tag> obterTags(){
		return repository.findAll(); 
	}
}
