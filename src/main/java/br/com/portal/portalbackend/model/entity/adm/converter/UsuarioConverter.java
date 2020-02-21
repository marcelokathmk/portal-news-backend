package br.com.portal.portalbackend.model.entity.adm.converter;

import org.springframework.beans.BeanUtils;

import br.com.portal.portalbackend.model.entity.adm.Usuario;
import br.com.portal.portalbackend.model.entity.adm.dto.UsuarioDTO;

public class UsuarioConverter {

	public static UsuarioDTO entityToDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		BeanUtils.copyProperties(usuario, dto);
		return dto;
	}
}
