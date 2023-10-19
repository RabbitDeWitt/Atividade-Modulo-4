package model;

public class Pacote {
	private int id;
	private String nome;
	private float valor;
	
	public Pacote() {
		
	}
	
	public Pacote(String nome, float valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public Pacote(int id, String nome, float valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void mostrar() {
		System.out.println("=====================================");
		System.out.println("ID: "+this.id);
		System.out.println("Nome: "+this.nome);
		System.out.printf("Valor: R$%.2f %n",this.valor);
		System.out.println("=====================================");
	}
}
