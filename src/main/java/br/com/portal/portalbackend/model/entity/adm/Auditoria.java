package br.com.portal.portalbackend.model.entity.adm;

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

	public Date getDataCriacaoRegistro() {
		return dataCriacaoRegistro;
	}

	public void setDataCriacaoRegistro(Date dataCriacaoRegistro) {
		this.dataCriacaoRegistro = dataCriacaoRegistro;
	}

	public Date getDataAlteracaoRegistro() {
		return dataAlteracaoRegistro;
	}

	public void setDataAlteracaoRegistro(Date dataAlteracaoRegistro) {
		this.dataAlteracaoRegistro = dataAlteracaoRegistro;
	}

	public Date getDataExclusaoRegistro() {
		return dataExclusaoRegistro;
	}

	public void setDataExclusaoRegistro(Date dataExclusaoRegistro) {
		this.dataExclusaoRegistro = dataExclusaoRegistro;
	}
}
