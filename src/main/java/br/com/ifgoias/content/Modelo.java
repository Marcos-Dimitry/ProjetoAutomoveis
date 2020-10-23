package br.com.ifgoias.content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Modelo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idModelo;
	
	@Column (name = "descricao", nullable = false)
	private String descricao;
	
	@Column (name="potencia", nullable = false)
	private Integer potencia;
	
	@Column (name="potencia", nullable = false)
	private Integer marca_id;
	
	@ManyToMany 
	@JoinTable( name="modelo",
				joinColumns = @JoinColumn(name="idModelo"),
				inverseJoinColumns = @JoinColumn(name="idAutomovel"))
	private List<Automovel> automovel = new ArrayList<Automovel>();
	
	public List<Automovel> getAutomovel() {
		return automovel;
	}

	public void addAutomovel(Automovel a) {
		this.automovel.add(a);
		a.getModelo().add(this);
	}

	public void removeAutomovel(Automovel a) {
		this.automovel.remove(a);
		a.getModelo().remove(this);
	}

	public Modelo(Integer idModelo, String descricao, Integer potencia, Integer marca_id) {
		this.idModelo = idModelo;
		this.descricao = descricao;
		this.potencia = potencia;
		this.marca_id = marca_id;
	}

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer setPotencia() {
		return potencia;
	}

	public void getPotencia(Integer potencia) {
		this.potencia = potencia;
	}
	
	public Integer getMarca_Id() {
		return marca_id;
	}

	public void setMarca_Id(Integer marca) {
		this.marca_id = marca;
	}

	@Override
	public String toString() {
		return "Modelo [idModelo=" + idModelo + ", descrição=" + descricao + ", potência=" + potencia + ", marca_id=" + marca_id + "]";
	}
	
	
}
