package br.com.gabriel.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.Empresa;
import br.com.gabriel.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa  extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");

		Empresa empresa = new Empresa(nome);


		new EmpresaDAO().adiciona(empresa);

		PrintWriter out =  resp.getWriter();
		
		
		req.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher
									("/WEB-INF/paginas/novaEmpresa.jsp");
			
		dispatcher.forward(req, resp);
		
	}

}
