package br.com.agenda.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.model.Contato;
import br.com.agenda.model.Email;
import br.com.agenda.model.Fornecedor;
import br.com.agenda.model.Telefone;
import br.com.agenda.regras.ContatoRN;
import br.com.agenda.regras.FornecedorRN;

@WebServlet("/ContatoServlet")
public class ContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ContatoRN contatoService;
	private FornecedorRN fornecedorRN;
       
    public ContatoServlet() {
    	this.contatoService = new ContatoRN();
    	this.fornecedorRN = new FornecedorRN();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato();
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String numero1 = request.getParameter("numero1");
		String numero2 = request.getParameter("numero2");
		
		contato.setNome(nome);
		contato.setCpf(cpf);
		
		//Impedindo que o segundo email entre no banco vazio
		if(email2 == null || email2 == "" || email2 == " ") {
			contato.getEmails().add(new Email(email1, contato));
		}else {
			contato.getEmails().addAll(Arrays.asList(new Email(email1, contato), 
									   new Email(email2, contato)));
		}
		
		//Impedindo que o segundo número entre no banco vazio
		if(numero2 == null || numero2 == "" || numero2 == " " ) {
			contato.getTelefones().add(new Telefone(numero1, contato));
		}else {
			contato.getTelefones().addAll(Arrays.asList(new Telefone(numero1, contato), 
					  new Telefone(numero2, contato)));
		}
		
		Fornecedor fornecedor = this.fornecedorRN.getById(1L);
		
		fornecedor.getContatos().add(contato);
		this.fornecedorRN.update(fornecedor);
		
		
		contato.getFornecedores().add(fornecedor);
		
		
		//salvando contato
		this.contatoService.addContato(contato);
		
		System.out.println(">>>>>>>>>> CONTATO " + contato.getNome()+ " SALVO COM SUCESSO !");
		

		response.sendRedirect("home.jsp");
	}

}
