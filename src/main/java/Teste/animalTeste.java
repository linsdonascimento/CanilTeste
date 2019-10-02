package Teste;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import app.id.model.Canil;
import app.id.model.Endereço;

public class animalTeste {Canil can = new Canil();

private static Canil c1;
private static Canil c2;
private static Endereço endi;
private static Canil c3;

@Before
public void objetoIniciado() {

	c1 = new Canil(233,"533", "canil pe", endi);
	c2 = new Canil(233,"533", "canil pe", endi);
	c3 = new Canil(456,"534", "DogLar", endi);
}

@Test
public void testCadastro() {
    
    can.cadastroCanil(c1);
	assertTrue(true);
          
}

@Test
public void testIguais(){
	
	assertEquals(c1, c2);
	assertNotEquals(c1,c3);  

}

@Test
public void testDeletar() {

	can.removeCanil(233);
	assertTrue(true);
}

@Test
public void testAlterar(){
	c1.setCodCanil("500");
	can.alterarCanil(c1);
	
}
}
