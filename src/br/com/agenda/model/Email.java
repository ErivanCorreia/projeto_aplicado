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
@Table(name = "email")
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;

	public Email() {
	}
	
	public Email(String descricao, Contato contato) {
		super();
		this.descricao = descricao;
		this.contato = contato;
	}
	
	public Email(String descricao, Fornecedor fornecedor) {
		super();
		this.descricao = descricao;
		this.fornecedor = fornecedor;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
