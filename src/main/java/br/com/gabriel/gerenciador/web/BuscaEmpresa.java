package br.com.gabriel.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.Empresa;
import br.com.gabriel.gerenciador.dao.EmpresaDAO;



public class BuscaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String filtro = req.getParameter("nome");	

		Collection<Empresa> empresas =   new EmpresaDAO().buscaPorSimilaridade(filtro);

		req.setAttribute("empresas",empresas);

		return "/WEB-INF/paginas/buscaEmpresa.jsp" ;

		
	}


}
