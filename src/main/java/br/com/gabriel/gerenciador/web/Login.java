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
import br.com.gabriel.gerenciador.dao.UsuarioDAO;


public class Login implements Tarefa {



	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		RequestDispatcher dispatcher;

		HttpSession session = req.getSession();

		Usuario user  = (Usuario) session.getAttribute("usuarioLogado");

		if(user != null){

			return "/WEB-INF/paginas/loginJaRealizado.jsp";
		}

		String email = req.getParameter("email");

		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (usuario == null) {

			return
					"/WEB-INF/paginas/loginInvalido.jsp";	
		} 

		session.setAttribute("usuarioLogado", usuario);

		return
				"/WEB-INF/paginas/loginRealizado.jsp";


	}
}
