package br.com.portal.portalbackend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Auditoria{

	@Id
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "ds_usuario")
	private String usuario;
	
	@Column(name = "ds_senha")
	private String senha;
	
	@Column(name = "is_ativo")
	private Boolean ativo;
	
}
