package br.com.agenda.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.model.Fornecedor;
import br.com.agenda.model.Telefone;
import br.com.agenda.regras.FornecedorRN;


@WebServlet("/FornecedorServlet")
public class FornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FornecedorRN fornecedorRN;
   
    public FornecedorServlet() {
        super();
       this.fornecedorRN = new FornecedorRN();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fornecedor fornecedor = new Fornecedor();
		
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String numero1 = request.getParameter("numero1");
		String numero2 = request.getParameter("numero2");
		
		fornecedor.setNome(nome);
		fornecedor.setCnpj(cnpj);
		
		// Impedindo que o segundo número entre no banco vazio
		if (numero2 == null || numero2 == "" || numero2 == " ") {
			fornecedor.getTelefones().add(new Telefone(numero1, fornecedor));
		} else {
			fornecedor.getTelefones()
					.addAll(Arrays.asList(new Telefone(numero1, fornecedor), new Telefone(numero2, fornecedor)));
		}
		
		
		this.fornecedorRN.addFornecedor(fornecedor);
		System.out.println(">>>>> fornecedor "+fornecedor.getNome()+" salvo com sucesso !!");
		
		response.sendRedirect("cadastrarFornecedor.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
