package br.com.ifgoias.content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marca implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idMarca;
	
	@Column (name = "nome", nullable = false)
	private String nome;
	
	private List<Marca> marca = new ArrayList<Marca>();
	
	public List<Marca> getMarca() {
		return marca;
	}

	public void addMarca(Marca a) {
		this.marca.add(a);
	}

	public void removeMarca(Marca a) {
		this.marca.remove(a);
	}

	public Marca(Integer idMarca, String nome) {
		this.idMarca = idMarca;
		this.nome = nome;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNomme() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", nome=" + nome + "]";
	}
	
	
}
