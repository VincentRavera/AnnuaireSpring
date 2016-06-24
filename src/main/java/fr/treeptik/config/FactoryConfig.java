package fr.treeptik.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import fr.treeptik.dao.impl.NumeroDAOJPQL;
import fr.treeptik.dao.impl.PersonneDAOJPQL;
import fr.treeptik.dao.interf.NumeroDAO;
import fr.treeptik.dao.interf.PersonneDAO;
import fr.treeptik.service.impl.NumeroServiceImpl;
import fr.treeptik.service.impl.PersonneServiceImpl;
import fr.treeptik.service.interf.NumeroService;
import fr.treeptik.service.interf.PersonneService;

@Configuration
@PropertySource(value="classpath:/config.properties")
@ComponentScan(basePackages={"fr.treeptik.service.impl"})
@Import(value = {ServiceConfig.class})
public class FactoryConfig {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Bean
	public PersonneService personneService() {
		PersonneServiceImpl personneService = new PersonneServiceImpl();
		personneService.setNumeroDAO(numeroDAO());
		personneService.setPersonneDAO(personneDAO());		
		return personneService;
	}
	
	@Bean
	public NumeroService numeroService() {
		NumeroServiceImpl numeroServiceImpl = new NumeroServiceImpl();
		numeroServiceImpl.setServPersonne(personneService());
		numeroServiceImpl.setNumeroDAO(numeroDAO());
		return numeroServiceImpl;
	}
	
	@Bean
	public PersonneDAO personneDAO(){
		PersonneDAOJPQL personneDAOJPQL = new PersonneDAOJPQL();
		personneDAOJPQL.setEn(this.em);
		return personneDAOJPQL;
	}
	
	@Bean
	public NumeroDAO numeroDAO(){
		NumeroDAOJPQL numeroDAOJPQL = new NumeroDAOJPQL();
		numeroDAOJPQL.setEn(this.em);
		return numeroDAOJPQL;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
