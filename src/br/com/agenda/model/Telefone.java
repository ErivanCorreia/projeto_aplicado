package br.com.agenda.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="numero")
	private String numero;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contato_id")
	private Contato contato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	public Telefone() {
	}
	

	public Telefone(String numero, Contato contato) {
		super();
		this.numero = numero;
		this.contato = contato;
	}
	
	public Telefone(String numero, Fornecedor fornecedor) {
		this.numero = numero;
		this.fornecedor = fornecedor;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
