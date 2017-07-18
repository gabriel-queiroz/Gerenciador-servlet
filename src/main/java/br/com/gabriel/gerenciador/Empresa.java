package br.com.gabriel.gerenciador;

public class Empresa {

	private long id = 0l;
	private String nome;

	public Empresa(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(long id) {
		this.id = id;
		
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
