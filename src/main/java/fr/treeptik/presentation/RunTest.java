package fr.treeptik.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.treeptik.config.FactoryConfig;
import fr.treeptik.pojo.Numero;
import fr.treeptik.pojo.Personne;
import fr.treeptik.service.interf.NumeroService;
import fr.treeptik.service.interf.PersonneService;

public class RunTest {

	public static void main(String[] args) {
		
		System.out.println("///Tests de Annuaire avec spring /////");
		
		//INITIALISTION - SPRING - BEGIN
		ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(FactoryConfig.class);
		
		System.out.println("Liste de BEAN cree :");
		for (String string : appContext.getBeanDefinitionNames()) {
			System.out.println(string);
			
		}
		//INITIALISTION - SPRING - END
		//USE - SPRING - BEGIN
		Personne p1 = new Personne("Moalesbourses", "David", new Date());
		Personne p2 = new Personne("Hal900", "Dave", new Date());
		Personne p3 = new Personne("Lesartichaud", "James", new Date());
		Numero n1 = new Numero("001", "tel");
		Numero n2 = new Numero("002", "tel");
		Numero n3 = new Numero("003", "tel");
		Numero n4 = new Numero("004", "tel");
		List<Numero> listP1 = new ArrayList<>();
		listP1.add(n1);
		List<Numero> listP2 = new ArrayList<>();
		listP2.add(n2);
		List<Numero> listP3 = new ArrayList<>();
		listP3.add(n4);
		listP3.add(n3);
		p1.setNumero(listP1);
		p2.setNumero(listP2);
		p3.setNumero(listP3);
		Map<String, Object> testMap = new HashMap<>();
		testMap.put("nom", "Hal900");
		
//		PersonneService personneService =appContext.getBean(PersonneService.class);
		
		//ADD
//		if (p1 != null) {
//			p1 = personneService.add(p1);
//			p2 = personneService.add(p2);
//			p3 = personneService.add(p3);
//			
//		}
//		//UPDATE
//		p1.setNom("DAAVID");
//		p1 = personneService.update(p1);
		//REMOVE
		
//		personneService.remove(p2);
		
		//FIND
		//Maps
//		List<Personne> lpf = personneService.find(testMap); 
//		for (Personne personne : lpf) {
//			System.out.println(personne.toString());
//		}
		//find byID
		
//		Personne p0 = personneService.findById(1);
//		System.out.println(p0.toString());
//		personneService.remove(p0);
		
		
		//findall()
//		lpf = personneService.findAll();
//		for (Personne personne : lpf) {
//			System.out.println(personne.toString());
//		}
		//
//		lpf = personneService.findByFName("James");
//		
//		for (Personne personne : lpf) {
//			System.out.println(personne.toString());
//		}
		
		
		
		//USE SPRING - END
		//CLOSURE - SPRING 
		appContext.close();

	}

}
