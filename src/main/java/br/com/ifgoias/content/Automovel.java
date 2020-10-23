package br.com.ifgoias.content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Automovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idAuto;
	
	private Integer anoFabricacao;
	private Integer anoModelo;
	private String observacoes;
	private Float preco;
	private Integer kilometragem;
	private Integer modelo_id;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Modelo> modelo = new ArrayList<Modelo>();
	
	public List<Modelo> getModelo() {
		return modelo;
	}
	
	public void addModelo(Modelo m) {
		this.modelo.add(m);
		m.getAutomovel().add(this);
	}

	public void removeModelo(Modelo m) {
		this.modelo.remove(m);
		m.getAutomovel().remove(this);
	}
	
	public Automovel(Integer idAuto, Integer anoFabricacao, 
			Integer anoModelo  ,String observacoes, Float preco
			, Integer kilometragem,Integer modelo_id) {
		super();
		this.idAuto = idAuto;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.observacoes = observacoes;
		this.preco = preco;
		this.kilometragem = kilometragem;
		this.modelo_id = modelo_id;
	}

	public Integer getId() {
		return idAuto;
	}

	public void setAnoFabricacao(Integer ano) {
		this.anoFabricacao = ano;
	}
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoModelo(Integer ano) {
		this.anoModelo = ano;
	}
	public Integer getAnoModelo() {
		return anoModelo;
	}
	
	public void setObservacoes(String obs) {
		this.observacoes = obs;
	}
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public Float getPreco() {
		return preco;
	}
	
	public void setModeloId(Integer model_id) {
		this.modelo_id = model_id;
	}
	public Integer getModelId() {
		return modelo_id;
	}

	@Override
	public String toString() {
		return "Automovel [idAutomovel =" + idAuto + ", anoFabricação=" + anoFabricacao + ", anoModelo=" + anoModelo + ", observaçoes=" + observacoes +", preço=" + preco +" KM = "+ kilometragem +" ]";
	}
	
	
}
