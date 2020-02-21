package br.com.portal.portalbackend.model.entity.adm.dto;

import java.util.Set;

import br.com.portal.portalbackend.model.entity.adm.Perfil;

public class UsuarioDTO {

	private Long id;
	
	private String usuario;
	
	private Boolean ativo;
	
	private Set<Perfil> perfis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
}
