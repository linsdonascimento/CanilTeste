/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import app.id.model.Animal;
import app.id.model.AnimalModel;
import app.id.model.Canil;
import app.id.model.Cliente;
import app.id.repositorioJpa.AnimalHibernateDAO;

/**
 *
 * @author 
 */
public class testeani {
    
    public static void main(String [] args){
        
       
        AnimalModel am= new AnimalModel ();
        
        Canil can= new Canil();
            can.setIdcanil(6);
               
        
       // Cliente client = new Cliente();
        //client.setIdCli(3);
        
        Animal ani = new Animal("14","ercules",5,"Médio", "Pastor","dog","02/07/2018","02/07/2018",null,can); 
			
        
        
       
          am.cadastrarAnimal(ani);
        // ani.setIdAnimal(10);
         //am.alterarAnimal(ani);
        
    }
    
    
}
