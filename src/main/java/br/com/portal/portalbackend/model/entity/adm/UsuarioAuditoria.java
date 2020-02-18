package br.com.portal.portalbackend.model.entity.adm;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class UsuarioAuditoria extends Auditoria {

	@ManyToOne
	@JoinColumn(name = "id_usuario_criacao")
	@CreatedBy
	private Usuario usuarioCriacaoRegistro;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_alteracao")
	@LastModifiedBy
	private Usuario usuarioAlteracaoRegistro;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_exclusao")
	private Usuario usuarioExclusaoRegistro;

	public Usuario getUsuarioCriacaoRegistro() {
		return usuarioCriacaoRegistro;
	}

	public void setUsuarioCriacaoRegistro(Usuario usuarioCriacaoRegistro) {
		this.usuarioCriacaoRegistro = usuarioCriacaoRegistro;
	}

	public Usuario getUsuarioAlteracaoRegistro() {
		return usuarioAlteracaoRegistro;
	}

	public void setUsuarioAlteracaoRegistro(Usuario usuarioAlteracaoRegistro) {
		this.usuarioAlteracaoRegistro = usuarioAlteracaoRegistro;
	}

	public Usuario getUsuarioExclusaoRegistro() {
		return usuarioExclusaoRegistro;
	}

	public void setUsuarioExclusaoRegistro(Usuario usuarioExclusaoRegistro) {
		this.usuarioExclusaoRegistro = usuarioExclusaoRegistro;
	}
}