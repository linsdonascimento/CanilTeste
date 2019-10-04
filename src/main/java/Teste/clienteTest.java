package Teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Teste.repositorio.ClienteRepo;
import app.id.model.Cliente;
import app.id.model.Endereço;

public class clienteTest {
	
	Cliente cli = new Cliente();
	
	private Cliente c1;
	private Cliente c2;
	private Endereço endi;  
	private Cliente c3;

	private static ClienteRepo dao;
	private static int idClienteInserido;

	@BeforeClass
	public static void init(){
		dao = new ClienteRepo();
	}
	
	@Before
	public void setUp() throws Exception {
		endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
		c1 = new Cliente("155","Lins","@1gmail","s11nha",endi);
		c2 = new Cliente("155","Lins","@1gmail","s11nha",endi);  
		c3= new  Cliente("156","LinsAlterado alterado","@1gmail","s11nha",endi);  
	}

	@Test
	public void testCadastroCli() {
		Cliente ci = dao.inserir(c1);
		idClienteInserido = ci.getIdCli();
		assertNotNull(ci.getCliCpf());
		assertEquals(1, dao.total());
	}
	
	@Test
	public void testIguais(){
		
		assertEquals(c1, c2);
		assertNotEquals(c1,c3);  

	}
	
	@Test
	public void testDeletar() {
		dao.deletar(idClienteInserido);
		assertEquals(0,dao.total());
	}
	
	@Test
	public void testAlterar(){
		c1.setCliCpf("200");
		cli.alterarCli(c1);
	}
	
}
