/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.id.model;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import app.id.model.dao.ClienteDAO;
import app.id.model.dao.InterfaceDao;
import app.id.repositorioJpa.ClienteHibernateDAOtest;

/**
 *
 * @author 
 */
public class ClienteModel {
   
     ClienteDAO<Cliente> dao = ClienteHibernateDAOtest.getInstance();
    
  public void cadastrarCliente(Cliente cliente) {
      
      if(ClienteHibernateDAOtest.getInstance().recuperar(cliente.getCliCpf())== null){
            
        dao.inserir(cliente);
      
      }else {
         	 
        }
       
  } 
   public void alterarCliente(Cliente cliente) {
        if ( ClienteHibernateDAOtest.getInstance().recuperar(cliente.getCliCpf())!= null) {
          
            ClienteHibernateDAOtest.getInstance().alterar(cliente);
        }
    }

    public void removerCliente(Integer  idCli) {
      
       
        if (idCli != null){
        ClienteHibernateDAOtest.getInstance().deletar(idCli);
        }
    
    }

    public Cliente recuperar(String cliCpf) {
        
        if ( cliCpf == null) {
            return null;
        }
        
        return (Cliente)(ClienteHibernateDAOtest.getInstance().recuperar(cliCpf)); 
    }

    public List<Cliente> RecuperarTodos() {
        return ClienteHibernateDAOtest.getInstance().listarTodos();
    }
    
    /////////////////////////////////////
    
    public void cadastroCli(Cliente cliente){
    	
    	
    }
    
 

}
