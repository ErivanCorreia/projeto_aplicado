package br.com.agenda.regras;

import java.util.List;

import br.com.agenda.dao1.FornecedorDao;
import br.com.agenda.model.Fornecedor;

public class FornecedorRN {
	
	private FornecedorDao fornecedorDao;
	
	public FornecedorRN() {
		this.fornecedorDao = new FornecedorDao();
	}
	
	public Fornecedor getById(Long id) {
		return this.fornecedorDao.getById(id);
	}
	
	public List<Fornecedor> list(){
		return this.fornecedorDao.list();
	}
	
	public void addFornecedor(Fornecedor fornecedor) {
		this.fornecedorDao.add(fornecedor);
	}
	
	public void update(Fornecedor fornecedor) {
		this.fornecedorDao.update(fornecedor);
	}
	
	public void remove(Long id) {
		this.fornecedorDao.remove(id);
	}
	

}
