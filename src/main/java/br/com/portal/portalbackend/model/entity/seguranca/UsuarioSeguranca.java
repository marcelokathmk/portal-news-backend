package br.com.portal.portalbackend.model.entity.seguranca;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.portal.portalbackend.model.entity.adm.Perfil;

public class UsuarioSeguranca implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String usuario;
	
	private String senha;
	
	private Boolean ativo;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioSeguranca() {
	}
	
	public UsuarioSeguranca(Long id, String usuario, String senha, Boolean ativo, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.ativo = ativo;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.ativo;
	}
	
	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}
	
	public Long getId() {
		return this.id;
	}
}