package br.com.portal.portalbackend.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.portal.portalbackend.model.entity.adm.Categoria;
import br.com.portal.portalbackend.model.entity.adm.Tag;
import br.com.portal.portalbackend.model.entity.adm.UsuarioAuditoria;

@Entity
@Table(name = "post")
public class Post extends UsuarioAuditoria {

	@Id
	@GeneratedValue
	@Column(name = "id_post")
	private Long id;
	
	@Column(name = "ds_titulo", nullable = false)
	private String titulo;
	
	@Column(name = "ds_subtitulo", nullable = false)
	private String subtitulo;
	
	@Column(name = "ds_texto", nullable = false)
	private String texto;
	
	@Column(name = "is_comentario", nullable = false)
	private Boolean comentarioAtivo = false;
	
	@Column(name = "is_compartilhamento")
	private Boolean compartilhamentoAtivo = false;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "post_tag", 
			  	joinColumns = @JoinColumn(name = "id_post"), 
			  	inverseJoinColumns = @JoinColumn(name = "id_tag")) 
	private Set<Tag> tags;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getComentarioAtivo() {
		return comentarioAtivo;
	}

	public void setComentarioAtivo(Boolean comentarioAtivo) {
		this.comentarioAtivo = comentarioAtivo;
	}

	public Boolean getCompartilhamentoAtivo() {
		return compartilhamentoAtivo;
	}

	public void setCompartilhamentoAtivo(Boolean compartilhamentoAtivo) {
		this.compartilhamentoAtivo = compartilhamentoAtivo;
	}
}
