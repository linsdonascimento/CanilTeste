/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.id.model;

import java.util.List;

import app.id.model.dao.ColaboradorDAO;
import app.id.model.dao.InterfaceDao;
import app.id.repositorioJpa.ColaboradorHibernateDAO;

/**
 *
 * @author
 */
public class ColaboradorModel {
	
    

	public void cadastrarColaborador(Colaborador colaborador) {
		if (ColaboradorHibernateDAO.getInstance().recuperar(colaborador.getCpf()) == null) {
			ColaboradorHibernateDAO.getInstance().inserir(colaborador);
		}

	}

	public void alterarColaborador(Colaborador colaborador) {
		if (ColaboradorHibernateDAO.getInstance().recuperar(colaborador.getCpf()) != null) {
			ColaboradorHibernateDAO.getInstance().alterar(colaborador);
		}
	}

	public Colaborador removerColaborador(Integer idCol) {

		if (idCol != null) {
			ColaboradorHibernateDAO.getInstance().deletar(idCol);

		}
		return null;
	}

	public Colaborador recuperar(String cpf) {

		if (cpf == null) {
			return null;
		}

		return (Colaborador) ColaboradorHibernateDAO.getInstance().recuperar(cpf);
	}

	public List<Colaborador> RecuperarTodos() {
		return ColaboradorHibernateDAO.getInstance().listarTodos();
	}

}

