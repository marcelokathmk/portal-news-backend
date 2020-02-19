package br.com.portal.portalbackend.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.portal.portalbackend.services.DatabaseService;

@Configuration
@Profile("test")
public class ConfiguracaoTeste {

	@Autowired
	private DatabaseService databaseService;
	
	@Bean
	public boolean instantiateDataBase() {
		databaseService.instantiateDataBase();
		return true;
	}
}
