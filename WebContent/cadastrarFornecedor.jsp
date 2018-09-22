<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Cadastrar Fornecedor</title>
</head>

<body>
		
		<div align="center">
			
			<form action="FornecedorServlet">
				<hr>
					<labe>Nome*:</labe><br/>
					<input type="text" name="nome" id="nome" placeholder="Nome" required/><br/>
					
					<label>CNPJ*:</label> <br/>
					<input type="text" name="cnpj" id="cnpj" placeholder="CNPJ" required/><br/><br/>
					
					<label>Telefones</label><br/>
					<input type="text" name="numero1" id="numero1" placeholder="Telefone(obrigatório)" required/><br/>
					<input type="text" name="numero2" id="numero2" placeholder="Telefone(opcional)"/><br/>
					
					<label>Emails</label><br/>
					<input type="text" name="email1" id="email1" placeholder="Email(obrigatório)" required/><br/>
					<input type="text" name="email2" id="email2" placeholder="Email(opcional)"/><br/>
						
					<input type="submit" value="Enviar" />
				<hr>
				
				<br/>
				<a href="home.jsp">Menu</a>
			</form>
		
		</div>
		
</body>
</html>