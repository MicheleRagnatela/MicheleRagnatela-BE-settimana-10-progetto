package it.epicode.be.segreteria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.be.segreteria.model.Corso;
import it.epicode.be.segreteria.model.Segreteria;
import it.epicode.be.segreteria.model.Studente;


@Configuration
public class SegreteriaConfig {

	@Bean
	@Scope("prototype")
	public Studente studente() {
	return new Studente();
	}
	
	@Bean
	public Corso corso() {
		return new Corso();
	}
	
	@Bean
	public Segreteria segreteria() {
		return new Segreteria();
	}
	
}
