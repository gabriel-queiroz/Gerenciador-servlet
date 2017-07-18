 	package br.com.gabriel.gerenciador.web;
	
	import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.gabriel.gerenciador.Usuario;
	
	
	@WebFilter(urlPatterns="/*")
	public class FiltroDeAuditoria implements Filter {
	
		@Override
		public void destroy() {
		}
	
		@Override
		public void doFilter(ServletRequest resquest, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
	
			// transformando a serveltresquest em httpservlet resquest
	
			HttpServletRequest req = (HttpServletRequest) resquest;
	
			String url = req.getRequestURI();
	
			String usuario;
	
			usuario = getUsuario(req);
			
			System.out.println(usuario);
	
			chain.doFilter(resquest, response);
		}
	
		private String getUsuario(HttpServletRequest req) {
			
			HttpSession session = req.getSession();
			
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			
			if(usuario == null){
				
				return "<Deslogado>";
			}
			
			return usuario.getEmail();
		}
	
		@Override
		public void init(FilterConfig arg0) throws ServletException {
	
	
		}
	
	}
