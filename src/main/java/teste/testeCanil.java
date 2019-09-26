package teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import javax.persistence.EntityManager;

import app.id.model.Canil;
import app.id.model.CanilModel;
import app.id.model.Cliente;
import app.id.model.Colaborador;
import app.id.model.Endereço;
import app.id.model.HibernateUtil;
import app.id.repositorioJpa.CanilHibernateDAOtest;

public class testeCanil {
	
	EntityManager em = HibernateUtil.getEntityManager();


	CanilModel cm = new CanilModel();
	
	private static Canil c1;
	private static Canil c2;
	private static Endereço endi;  
	private List<Colaborador> listaColaboradores;
	private static Canil c3;
	
	public void objetoIniciado(){

		endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
		c1 = new  Canil("ede", "brbrb", endi, listaColaboradores);
		c2 = new  Canil("43ede", "brb4t4grb", endi, listaColaboradores);
		c2 = new  Canil("43ede", "brb4t4grb", endi, listaColaboradores);
	}
	
	@Before
	public void antes() {
		System.out.println("Teste iniciado !");
	}
	@Test
	public void inserir() {

		cm.cadastrarCanil(c1);
		assertTrue(true);
	}

	public void deletar(String codCanil) {

		//certa
		em=HibernateUtil.getEntityManager();
		Canil ca = em.find(Canil.class,codCanil);

		try{

			em.getTransaction().begin();
			em.remove(ca);
			em.getTransaction().commit();
			assertTrue(true);

		}finally{

			em.close();
		}        
	}
	
	@Test
	public void alterar(){

		em.merge(cm);
		em.getTransaction().commit();
		c1.setCodCanil("43ede");
		cm.alterarCanil(c1);
		assertTrue(true);
	}

	

	@Test
	public void iguais(){
		em.persist(cm);
		em.getTransaction().commit();
		assertEquals(c2, c3);
		assertNotEquals(c1, c3);  

	}


	@After
	public void depois() {
		System.out.println("Teste finalizado !");
	}
}