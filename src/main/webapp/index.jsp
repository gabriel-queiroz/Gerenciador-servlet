<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${not empty usuarioLogado}"> <br>
		Logado como : ${usuarioLogado.email} <br>
	</c:if>
	
	
	<c:if test="${ empty usuarioLogado }">
	
		Nenhum Usuário logado!!
	
	</c:if>
	
	
	<form action="login" method="post">
	
		Email:  <input type="email" name="email"/> <br>
		<br>
		Senha:  <input type="password" name="senha"> <br>
				<input type="submit" value="logar">
	</form>

	<h1>começou !!!!</h1>
	<a href="busca.jsp" >buscar Empresa</a>
	
	<br>
	
	<a href="novaEmpresa.jsp" > Cadastrar Empresa</a>
	
	
	<br>
	
	<form action="logout" method="post">
	
	<input type="submit" value="deslogar">
	
	</form>
	
</body>
</html>