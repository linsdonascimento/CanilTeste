package teste;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import app.id.model.Cliente;
import app.id.model.ClienteModel;
import app.id.model.Endereço;
import app.id.model.HibernateUtil;
import app.id.model.dao.ClienteDAO;

/**
 *
 * @author
 */
public class testeCliente {
	

	EntityManager em = HibernateUtil.getEntityManager();

	ClienteModel cm= new ClienteModel();

	private static Cliente c1;
	private static Cliente c2;
	private static Endereço endi;  
	private static Cliente c3;

	
	public void objetoIniciado(){

		endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
		c1 = new Cliente("155","Lins","@1gmail","s11nha",endi);
		c2 = new Cliente("155","Lins","@1gmail","s11nha",endi);  
		c3= new  Cliente("156","LinsAlterado alterado","@1gmail","s11nha",endi);  
	}
	
	@Before
	public void antes() {
		System.out.println("Teste iniciado !");
	}
	@Test
	public void inserir() {

		cm.cadastrarCliente(c1);
		assertTrue(true);
	}

	public void deletar(Integer idCli) {

		//certa
		em=HibernateUtil.getEntityManager();

		Cliente cli = em.find(Cliente.class,idCli);

		try{

			em.getTransaction().begin();
			em.remove(cli);
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
		c1.setIdCli(64);
		cm.alterarCliente(c1);
		assertTrue(true);
	}

	

	@Test
	public void iguais(){
		em.persist(cm);
		em.getTransaction().commit();
		assertEquals(c1, c2);
		assertNotEquals(c1, c3);  

	}

	
	@After
	public void depois() {
		System.out.println("Teste finalizado !");
	}


}
