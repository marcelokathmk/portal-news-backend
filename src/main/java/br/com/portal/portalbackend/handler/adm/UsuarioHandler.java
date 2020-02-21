package br.com.portal.portalbackend.handler.adm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.portalbackend.model.entity.adm.Usuario;
import br.com.portal.portalbackend.model.entity.adm.converter.UsuarioConverter;
import br.com.portal.portalbackend.model.entity.adm.dto.UsuarioDTO;
import br.com.portal.portalbackend.model.entity.seguranca.UsuarioSeguranca;
import br.com.portal.portalbackend.seguranca.UsuarioAutenticado;
import br.com.portal.portalbackend.services.adm.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioHandler {

	@Autowired
	private UsuarioService service;
	
	@GetMapping(value="/usuarioLogado")
	public ResponseEntity<UsuarioDTO> getUsuarioLogado(){
		UsuarioSeguranca usuarioAutenticado = UsuarioAutenticado.getUsuarioAutenticado();
		if	(usuarioAutenticado != null) {
			Usuario usuario = service.getUsuarioPorIdentificador(usuarioAutenticado.getId());
			return ResponseEntity.ok().body(UsuarioConverter.entityToDTO(usuario));
		}
		return ResponseEntity.noContent().build();
	}
}
