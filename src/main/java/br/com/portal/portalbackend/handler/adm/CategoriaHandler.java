package br.com.portal.portalbackend.handler.adm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.portalbackend.model.entity.adm.Categoria;
import br.com.portal.portalbackend.model.entity.adm.converter.CategoriaConverter;
import br.com.portal.portalbackend.model.entity.adm.dto.CategoriaDTO;
import br.com.portal.portalbackend.services.adm.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaHandler {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> obterCategorias(){
		List<Categoria> categorias = service.obterCategorias();
		if	(categorias != null && !categorias.isEmpty()) {
			return ResponseEntity.ok().body(CategoriaConverter.fromEntityToDto(categorias));
		}
		return ResponseEntity.noContent().build();
	}
}
