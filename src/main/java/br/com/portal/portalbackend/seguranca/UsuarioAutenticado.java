package br.com.portal.portalbackend.seguranca;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.portal.portalbackend.model.entity.seguranca.UsuarioSeguranca;

public class UsuarioAutenticado {

	public static UsuarioSeguranca getUsuarioAutenticado() {
		try {
			return (UsuarioSeguranca) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
