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

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		
		HttpSession session = req.getSession();
		
		Usuario user =  (Usuario) session.getAttribute("usuarioLogado");
		
		if(user == null){
			
			dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logoutInvalido.jsp");
		
			dispatcher.forward(req, resp);
			
			return;
		}
		
		
		
		session.removeAttribute("usuarioLogado");

		
		dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.jsp");


		dispatcher.forward(req, resp);

		

	}
}
