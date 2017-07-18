package br.com.gabriel.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private final  Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		
		this.cookies = cookies;
		
	}

	public Cookie buscarUsuarioLogado() {

		if(cookies == null){

			return null;
		}

		for (Cookie cookie : cookies) {

			if(cookie.getName().equals("usuario.logado")){
				return cookie;
			}

		}
		return null;
	}






}
