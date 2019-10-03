package Teste;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import app.id.model.Animal;
import app.id.model.Canil;
import app.id.model.Cliente;
import app.id.model.Endereço;

public class animalTeste {
	
	
Animal animal = new Animal();

private Animal c1;
private Animal c2;
private Canil canil;
private Cliente cli;
private Animal c3;

@Before
public void objetoIniciado() {

	c1 = new Animal(233,"88888", "Hercules", 2,"Pequeno", "Vira Lata","Cão", "27/09/2019", "03/10/2019", cli, canil);
	c2 = new Animal(233,"88888", "Hercules", 2,"Pequeno", "Vira Lata","Cão", "27/09/2019", "03/10/2019", cli, canil);
	c3 = new Animal(563,"77152", "Sabrina", 3,"Pequeno", "Vira Lata","Cão", "28/08/2019", "12/09/2019", cli, canil);
}

@Test
public void testCadastro() {
    
	assertTrue(animal.cadastroAnimal(c1));
          
}

@Test
public void testIguais(){
	
	assertEquals(c1, c2);
	assertNotEquals(c1,c3);  

}

@Test
public void testDeletar() {

	animal.removeAnimal(233);
}

@Test
public void testAlterar(){
	c1.setCodAnimal("500");
	animal.alterarAnimal(c1);	
}
}
