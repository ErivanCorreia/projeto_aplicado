<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>

<body>
		
		<div align="center">
			
			<form action="ContatoServlet">
				<hr>
					<labe>Nome*:</labe><br/>
					<input type="text" name="nome" id="nome" placeholder="Nome" required/><br/>
					
					<label>CPF*:</label> <br/>
					<input type="text" name="cpf" id="cpf" placeholder="CPF" required/><br/><br/>
					
					
					<label>Emails</label><br/>
					<input type="text" name="email1" id="email" placeholder="Email(obrigatório)" required/><br/>
					<input type="text" name="email2" id="email" placeholder="Email(opcional)"/><br/><br/>
					
					
					<label>Telefones</label><br/>
					<input type="text" name="numero1" id="numero1" placeholder="Número de telefone(obrigatório)" required/><br/>
					<input type="text" name="numero2" id="numero2" placeholder="Número de telefone(opcional)"/><br/>
					
						
					<input type="submit" value="Enviar" />
				<hr>
				
				<br/>
				<a href="home.jsp">Menu</a>
			</form>
		
		</div>
		
</body>
</html>