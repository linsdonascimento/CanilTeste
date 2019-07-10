/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import org.junit.jupiter.api.Assertions;
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
public class ClienteHibernateDAOIT {
	

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
		em.getTransaction().begin();
	}
	@Test
	public void inserir() {

		cm.cadastrarCliente(c1);
		//client.setEndereço(endi); 
	}

	public void deletar(Integer idCli) {

		//certa
		em=HibernateUtil.getEntityManager();

		Cliente cli = em.find(Cliente.class,idCli);

		try{

			em.getTransaction().begin();
			em.remove(cli);
			em.getTransaction().commit();

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
	}

	@Test
	public void recuperar(String  cliCpf){

		cm.recuperar(cliCpf);
	}

	@Test
	public void iguais(){
		em.persist(cm);
		em.getTransaction().commit();
		assertEquals(c1, c2);
		assertNotEquals(c1, c3);  

	}

	@Test
	public void recupetarTodos(){


		for(Cliente c : cm.RecuperarTodos()){
			System.out.println(c.getNome()); 

		}

	}
	@After
	public void depois() {
		// mng.getTransaction().rollback();
		em.close();
	}


}
