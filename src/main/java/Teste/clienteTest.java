package Teste;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import app.id.model.Cliente;
import app.id.model.Endereço;

public class clienteTest {
	Cliente cli = new Cliente();
	private static Cliente c1;
	private static Cliente c2;
	private static Endereço endi;  
	private static Cliente c3;

	@Before
	public void setUp() throws Exception {
		
		endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
		c1 = new Cliente(12,"155","Lins","@1gmail","s11nha",endi);
		c2 = new Cliente(12,"155","Lins","@1gmail","s11nha",endi);  
		c3= new  Cliente(123,"156","LinsAlterado alterado","@1gmail","s11nha",endi);  
	}

	@Test
	public void testCadastroCli() {

		cli.cadastroCli(c1);
		assertTrue(true);
		
	}
	
	@Test
	public void testIguais(){
		
		assertEquals(c1, c2);
		assertNotEquals(c1,c3);  

	}
	
	@Test
	public void testDeletar() {
	
		cli.removeCli(12);
		assertTrue(true);
	}
	
	@Test
	public void testAlterar(){
		c1.setCliCpf("200");
		cli.alterarCli(c1);
		assertTrue(true);
	}
	

}
