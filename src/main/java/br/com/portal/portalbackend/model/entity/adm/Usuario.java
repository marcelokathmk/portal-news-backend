package br.com.portal.portalbackend.model.entity.adm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Auditoria{

	@Id
	@GeneratedValue
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "ds_usuario", nullable = false)
	private String usuario;
	
	@Column(name = "ds_senha", nullable = false)
	private String senha;
	
	@Column(name = "is_ativo", nullable = false)
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(name = "usuario_perfil", 
			  	joinColumns = @JoinColumn(name = "id_usuario"), 
			  	inverseJoinColumns = @JoinColumn(name = "id_perfil")) 
	private Set<Perfil> perfis;

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}	
}