/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import app.id.model.Animal;
import app.id.model.AnimalModel;
import app.id.model.Canil;
import app.id.model.Cliente;
import app.id.repositorioJpa.AnimalHibernateDAOtest;

/**
 *
 * @author 
 */
public class testeani {

	public static void main(String [] args) throws SQLException{

		Connection con = null;
		
		try{

			AnimalModel am= new AnimalModel ();
			Canil can= new Canil();
			Animal ani = new Animal("14","ercules",5,"Médio", "Pastor","dog","02/07/2018","02/07/2018",null,can); 
			can.setIdcanil(6);

			// transaction
			con.setAutoCommit(false);

			am.cadastrarAnimal(ani);

			con.commit();

		}catch(SQLException e){

			con.rollback();

		}finally{

			con.close();

		}

	}
}
