package br.com.ifgoias.app;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifgoias.content.Automovel;
import br.com.ifgoias.content.Marca;
import br.com.ifgoias.content.Modelo;


public class Main {

	public static void main(String[] args) throws ParseException {
		EntityManagerFactory entity = Persistence.createEntityManagerFactory("auto");
		EntityManager em = entity.createEntityManager();
		
		em.getTransaction().begin();
		
		Marca marca1 = new Marca(1,"Ford");
		
		Modelo model1 =  new Modelo(1, "New Fiesta",111, 1);
		
		Automovel auto1 = new Automovel(1,2014,2015,"1.5 HATCH",(float) 34.500,48500,1);
		
		marca1.addMarca(marca1);
		model1.addAutomovel(auto1);
		auto1.addModelo(model1);
		
		em.persist(marca1);
		em.persist(model1);
		em.persist(auto1);
		
		em.getTransaction().commit();
		
		em.close();
		entity.close();
		
	}

}
