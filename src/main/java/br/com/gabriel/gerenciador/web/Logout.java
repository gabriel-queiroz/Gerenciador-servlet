package br.com.gabriel.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabriel.gerenciador.Usuario;


public class Logout implements Tarefa{





	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		RequestDispatcher dispatcher;

		HttpSession session = req.getSession();

		Usuario user =  (Usuario) session.getAttribute("usuarioLogado");

		if(user == null){

			return 
					"/WEB-INF/paginas/logoutInvalido.jsp";

		}

		session.removeAttribute("usuarioLogado");


		return 	
				"/WEB-INF/paginas/logout.jsp";

	}
}
