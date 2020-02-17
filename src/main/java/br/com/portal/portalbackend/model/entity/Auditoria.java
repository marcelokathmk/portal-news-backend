package br.com.portal.portalbackend.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditoria {

	@Column(name = "dt_criacao")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacaoRegistro;
	
	@Column(name = "dt_alteracao")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracaoRegistro;
	
	@Column(name = "dt_exclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExclusaoRegistro;
}
