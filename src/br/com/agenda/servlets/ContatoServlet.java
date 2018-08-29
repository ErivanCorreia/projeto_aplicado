package br.com.agenda.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.model.Contato;
import br.com.agenda.regras.ContatoRN;

/**
 * Servlet implementation class ContatoServlet
 */
@WebServlet("/ContatoServlet")
public class ContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ContatoRN service;
       
    public ContatoServlet() {
    	
    	this.service = new ContatoRN();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato();
		
		
		String nome = request.getParameter("nome");
		contato.setNome(nome);
		
		this.service.addContato(contato);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>> CONTATO " + contato.getNome()+ "SALVO COM SUCESSO !");
		
	}

}
