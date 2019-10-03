/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.id.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author
 */
@Entity
@Table(name = "canil")
public class Canil implements Serializable {

	@Id
	@Column(name = "id_canil", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idCanil;
	@Column(length = 20, nullable = false)

	private String codCanil;
	@Column(length = 60, nullable = false)
	private String nome;

	@Embedded
	private Endereço endereço;

	// muitos canis para muitos colaboradores
	@ManyToMany(mappedBy = "listaCanis")
	private List<Colaborador> listaColaboradores;

	ArrayList<Canil> listacanil;

	public Canil() {

		listacanil = new ArrayList();

	}

	public Canil(int idCanil, String codCanil, String nome, Endereço endereço) {
		this.idCanil = idCanil;
		this.codCanil = codCanil;
		this.nome = nome;
		this.endereço = endereço;

		listacanil = new ArrayList();

	}

	public int getIdCanil() {
		return idCanil;
	}

	public void setIdCanil(int idCanil) {
		this.idCanil = idCanil;
	}

	public String getCodCanil() {
		return codCanil;
	}

	public void setCodCanil(String codCanil) {
		this.codCanil = codCanil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereço getEndereço() {
		return endereço;
	}

	public void setEndereço(Endereço endereço) {
		this.endereço = endereço;
	}

	public List<Colaborador> getListaColaboradores() {
		return listaColaboradores;
	}

	public void setListaColaboradores(List<Colaborador> listaColaboradores) {
		this.listaColaboradores = listaColaboradores;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Canil other = (Canil) obj;
		if (this.idCanil != other.idCanil) {
			return false;
		}
		if (!Objects.equals(this.codCanil, other.codCanil)) {
			return false;
		}
		if (!Objects.equals(this.nome, other.nome)) {
			return false;
		}
		if (!Objects.equals(this.endereço, other.endereço)) {
			return false;
		}
		if (!Objects.equals(this.listaColaboradores, other.listaColaboradores)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 29 * hash + this.idCanil;
		hash = 29 * hash + Objects.hashCode(this.codCanil);
		hash = 29 * hash + Objects.hashCode(this.nome);
		hash = 29 * hash + Objects.hashCode(this.endereço);
		hash = 29 * hash + Objects.hashCode(this.listaColaboradores);
		return hash;
	}

	public String toString() {
		return "Canil{" + "idCanil=" + idCanil + ", codCanil=" + codCanil + ", nome=" + nome + ", endere\u00e7o="
				+ endereço + ", listaColaboradores=" + listaColaboradores + '}';
	}

	public boolean cadastroCanil(Canil canil) {
		if(listacanil.add(canil)){
			return true;
		}else{
			return false;
			}
	}

	public void removeCanil(int idCanil) {
		for (Canil canil : listacanil) {
			if (canil.getIdCanil() == idCanil) {

				listacanil.remove(canil);

			}
		}
	}

	public void alterarCanil(Canil canil) {
		for(Canil canil1 : listacanil) {
			if (canil1.getCodCanil() == canil.getCodCanil()){

				listacanil.remove(canil);
				listacanil.add(canil1);
			}
		}
	}

}