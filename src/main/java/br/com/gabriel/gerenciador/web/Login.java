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

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		
		HttpSession session = req.getSession();
		
		Usuario user  = (Usuario) session.getAttribute("usuarioLogado");
		
		if(user != null){
			
			dispatcher = req.getRequestDispatcher(
									"/WEB-INF/paginas/loginJaRealizado.jsp");
			
			
			dispatcher.forward(req, resp);
			
			return;
		}
		
			String email = req.getParameter("email");

			String senha = req.getParameter("senha");
			
			Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		
		if (usuario == null) {

			dispatcher = req.getRequestDispatcher(
										"/WEB-INF/paginas/loginInvalido.jsp");

			dispatcher.forward(req, resp);

			return;
		} 

			 session.setAttribute("usuarioLogado", usuario);

			 dispatcher = req.getRequestDispatcher(
										"/WEB-INF/paginas/loginRealizado.jsp");

			 dispatcher.forward(req, resp);
		
	}
}
