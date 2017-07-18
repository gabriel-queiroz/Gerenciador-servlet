package br.com.gabriel.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.Empresa;
import br.com.gabriel.gerenciador.dao.EmpresaDAO;


@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest resq, HttpServletResponse resp) throws ServletException, IOException {
	
		String filtro = resq.getParameter("nome");	

		Collection<Empresa> empresas =   new EmpresaDAO().buscaPorSimilaridade(filtro);

		resq.setAttribute("empresas",empresas);

		RequestDispatcher dispatcher = resq.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");

		dispatcher.forward(resq, resp);

	}


}
