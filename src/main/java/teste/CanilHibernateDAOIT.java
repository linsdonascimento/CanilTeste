/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import app.id.model.Canil;
import app.id.model.CanilModel;
import app.id.model.Endereço;
import app.id.repositorioJpa.CanilHibernateDAO;


/**
 *
 * @author
 */
public class CanilHibernateDAOIT {
    
    CanilModel cn= new CanilModel();
    
  private static Canil c1;
  private static Canil c2;
  private static Endereço endi;  
  private static Canil c3;
   
  @BeforeAll
    public void objetoIniciado(){
          
        c1 = new Canil("533","canil pe",endi,null);
         c2 = new Canil("533","canil pe",endi,null);
         c3 = new Canil("534","DogLar",endi,null); 
    }
    
    
    
    
    @Test
    public void inserir() {
        
        cn.cadastrarCanil(c1);
               
                
    }
    
     @Test
    public void delete(){
         
        
         cn.removerCanil(6);
    }
    
     @Test
    public void alterar(){
        
      
        c1.setIdcanil(93);
        cn.alterarCanil(c1);
    }
    
     @Test
     public void recuperar(){
         
        cn.recuperar(null);
     }
    
     @Test
     public void iguais(){
         
        assertEquals(c1, c2);
        assertNotEquals(c1, c3);  
         
     }
     
     @Test
     public void recuperarTodos(){
         
        
        for(Canil c : cn.RecuperarTodos()){
            System.out.println(c.getNome()); 
            
        }
         
     }
     
    
}