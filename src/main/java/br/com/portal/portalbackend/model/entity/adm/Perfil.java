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
@Table(name = "perfil")
public class Perfil extends Auditoria {

	@Id
	@GeneratedValue
	@Column(name = "id_perfil")
	private Long id;
	
	@Column(name = "ds_perfil", nullable = false)
	private String descricao;
	
	@Column(name = "is_ativo", nullable = false)
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(name = "perfil_permissao",
				joinColumns = @JoinColumn(name = "id_perfil"),
				inverseJoinColumns = @JoinColumn(name = "id_permissao"))
	private Set<Permissao> permissoes;

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}