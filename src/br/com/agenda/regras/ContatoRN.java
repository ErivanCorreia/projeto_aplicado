/**
 * 
 */
package br.com.agenda.regras;

import java.util.List;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.model.Contato;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class ContatoRN {

	private ContatoDao contatoDao;
	
	public ContatoRN() {
		this.contatoDao = new ContatoDao();
	}
	
	public Contato getById(Long idContato) {
		return this.contatoDao.getbyId(idContato);
	}
	
	public void addContato(Contato contato) {
		this.contatoDao.add(contato);
	}
	
	public List<Contato> list(){
		return this.list();
	}
	
	public void update(Contato contato) {
		this.contatoDao.update(contato);
	}
	
	public void remover(Long idContato) {
		this.contatoDao.remover(idContato);
	}
	
}
