/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.List;

import app.id.model.Animal;
import app.id.model.AnimalModel;

/**
 *
 * @author 
 */
public class main {

    public static void main (String [] args){
        
        AnimalModel anm= new AnimalModel();
       // ClienteModel cm= new ClienteModel();
        
        for(Animal a : anm.RecuperarTodos()){
            System.out.println(a.getNomeAni()); 
            
        }
        
       // Cliente  c =cm.recuperar("12");
          
        
         //  System.out.println(c.getCliCpf()+c.getNome());
        
        
        
       
        
        
    }
    
    
    
    
    
}
