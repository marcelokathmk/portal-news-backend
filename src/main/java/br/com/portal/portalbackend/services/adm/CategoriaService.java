package br.com.portal.portalbackend.services.adm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.portalbackend.model.entity.adm.Categoria;
import br.com.portal.portalbackend.repository.adm.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> obterCategorias(){
		return repository.findAll();
	}
}