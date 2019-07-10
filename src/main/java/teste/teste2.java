/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import app.id.model.Canil;
import app.id.model.Cliente;
import app.id.model.Colaborador;
import app.id.model.ColaboradorModel;
import app.id.model.Endereço;
import app.id.repositorioJpa.ColaboradorHibernateDAOtest;

/**
 *
 * @author 
 */
public class teste2 {

	static Connection con;

	public static void main(String [] args) throws SQLException{

		ColaboradorModel colm = new ColaboradorModel();
		Endereço end= new Endereço ( "palmeiras","rua ", 4,"pe"); 

		// ja possui dois canis cadastrado
		// passo o id deles
		Canil can= new Canil();
		can.setIdcanil(6);
		Canil can2= new Canil();
		can2.setIdcanil(7);

		//coloco em uma lista de canis
		List<Canil>canis= new ArrayList();
		canis.add(can);
		canis.add(can2);

		// criu um colaborador e coloco ele cadastrado nos
		//dois canis
		try{
			Colaborador col = new Colaborador ();
		
		col.setCpf("id_cpf");
		col.setLogin("login"); 
		col.setSenha("senha");
		col.setNomeCol("nome_col");
		col.setEndereço(end);
		col.setListaCanis(canis);

		colm.cadastrarColaborador(col);
		con.commit();

    } catch (Exception e) {

        con.rollback();

        JOptionPane.showMessageDialog(null, e.getMessage());

    }




	}




}
