package br.com.portal.portalbackend.model.entity.adm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag extends Auditoria{

	@Id
	@GeneratedValue
	@Column(name = "id_tag")
	private Long id;
	
	@Column(name = "ds_tag", nullable = false)
	private String descricao;
	
	@Column(name = "is_ativo", nullable = false)
	private Boolean ativo = true;
	
	public Tag() {
	}
	
	public Tag(String descricao) {
		this.descricao = descricao;
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
