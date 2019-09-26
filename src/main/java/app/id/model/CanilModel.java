/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.id.model;

import java.util.List;

import app.id.repositorioJpa.CanilHibernateDAOtest;

/**
 *
 * 
 */
public class CanilModel {
    
	public void cadastrarCanil(Canil canil) {
	
             
            if(CanilHibernateDAOtest.getInstance().recuperar(canil.getCodCanil())== null){
                  
                CanilHibernateDAOtest.getInstance().inserir(canil);
        
               
	     }
        }
	public void alterarCanil(Canil canil) {
            
            if (CanilHibernateDAOtest.getInstance().recuperar(canil.getCodCanil())!= null) {
                  CanilHibernateDAOtest.getInstance().alterar(canil);
            }	
         }	


	public void removerCanil(Integer idcanil){
   
            if(idcanil != null){
                CanilHibernateDAOtest.getInstance().deletar(idcanil);
            }
                   
	
	}

	public Canil recuperar(String codCanil) {

		if (codCanil == null) {
			return null;
		}

		return (Canil) CanilHibernateDAOtest.getInstance().recuperar(codCanil);
	}

	public List<Canil> RecuperarTodos() {
		return CanilHibernateDAOtest.getInstance().listarTodos();
	}
        
}
