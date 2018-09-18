package br.com.agenda.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cnpj;
	
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "fornecedor_contato",
		joinColumns = @JoinColumn(name = "id_fornecedor"),
		inverseJoinColumns = @JoinColumn(name = "id_contato")
			)
	private List<Contato> contatos;

	public Fornecedor() {
		this.telefones = new ArrayList<>();
		this.contatos = new ArrayList<>();
	}
	
	public Fornecedor(String nome, String cnpj) {
		super();
		this.nome = nome;	
		this.cnpj = cnpj;
		this.telefones = new ArrayList<>();
		this.contatos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	
}
