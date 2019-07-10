/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.id.model;

import java.util.List;

import app.id.model.dao.ColaboradorDAO;
import app.id.model.dao.InterfaceDao;
import app.id.repositorioJpa.ColaboradorHibernateDAOtest;

/**
 *
 * @author
 */
public class ColaboradorModel {
	
    

	public void cadastrarColaborador(Colaborador colaborador) {
		if (ColaboradorHibernateDAOtest.getInstance().recuperar(colaborador.getCpf()) == null) {
			ColaboradorHibernateDAOtest.getInstance().inserir(colaborador);
		}

	}

	public void alterarColaborador(Colaborador colaborador) {
		if (ColaboradorHibernateDAOtest.getInstance().recuperar(colaborador.getCpf()) != null) {
			ColaboradorHibernateDAOtest.getInstance().alterar(colaborador);
		}
	}

	public Colaborador removerColaborador(Integer idCol) {

		if (idCol != null) {
			ColaboradorHibernateDAOtest.getInstance().deletar(idCol);

		}
		return null;
	}

	public Colaborador recuperar(String cpf) {

		if (cpf == null) {
			return null;
		}

		return (Colaborador) ColaboradorHibernateDAOtest.getInstance().recuperar(cpf);
	}

	public List<Colaborador> RecuperarTodos() {
		return ColaboradorHibernateDAOtest.getInstance().listarTodos();
	}

}

