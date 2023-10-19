package model;

public class Contato {
	private int id;
	private String nome, email, mensagem;

	public Contato() {
	}

	public Contato(String nome, String email, String mensagem) {
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
	}

	public Contato(int id, String nome, String email, String mensagem) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.mensagem = mensagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void mostrar() {
		System.out.println("=====================================");
		System.out.println("ID: "+this.id);
		System.out.println("Nome: "+this.nome);
		System.out.println("Email: "+this.email);
		System.out.println("Mensagem: "+this.mensagem);
		System.out.println("=====================================");
	}
}
