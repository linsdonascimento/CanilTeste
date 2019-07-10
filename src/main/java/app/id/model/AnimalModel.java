/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.id.model;

import java.util.List;

import app.id.model.dao.AnimalDAO;
import app.id.model.dao.InterfaceDao;
import app.id.repositorioJpa.AnimalHibernateDAOtest;

/**
 *
 * @author 
 */
public class AnimalModel {
	
   AnimalDAO<Animal> dao = AnimalHibernateDAOtest.getInstance();
    

    
    public void cadastrarAnimal(Animal animal) {
		if (AnimalHibernateDAOtest.getInstance().recuperar(animal.getCodAnimal()) == null) {
		
                    dao.inserir(animal);
		}
                   
                

	}

	public void alterarAnimal(Animal animal) {
	        if ( AnimalHibernateDAOtest.getInstance().recuperar(animal.getCodAnimal())!= null) {
	            AnimalHibernateDAOtest.getInstance().alterar(animal);
	        }
	    }

	public Animal removerAnimal(Integer idAnimal) {
   
		
		if (idAnimal != null) {
			 AnimalHibernateDAOtest.getInstance().deletar(idAnimal);

		} 
		return null;
	}

	public Animal recuperar(String codAnimal) {

		if (codAnimal == null) {
			return null;
		}

		return (Animal) AnimalHibernateDAOtest.getInstance().recuperar(codAnimal);
	}

	public List<Animal> RecuperarTodos() {
		return AnimalHibernateDAOtest.getInstance().listarTodos();
	}
        public List<Animal>RecuperarOrfaos(){
            
            return AnimalHibernateDAOtest.getInstance().animaisOrfao();
        }

}
