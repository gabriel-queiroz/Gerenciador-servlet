
package br.com.gabriel.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class controller extends HttpServlet {


	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		RequestDispatcher dispactcher;

		String tarefa = req.getParameter("tarefa");


		if(tarefa == null){

			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}

		tarefa = "br.com.gabriel.gerenciador.web." + tarefa;

		try{

			Class<?> tipo =	Class.forName(tarefa);

			Tarefa instTarefa = (Tarefa) tipo.newInstance();

			String pagina =  instTarefa.executa(req, res);

			dispactcher = req.getRequestDispatcher(pagina);

			dispactcher.forward(req, res);

		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){

			e.printStackTrace();

		}
	}
}



