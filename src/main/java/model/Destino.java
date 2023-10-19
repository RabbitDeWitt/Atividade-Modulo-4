package model;

public class Destino {
	private int id;
	private String nome, estado, pais;
	private float valor;
	
	public Destino() {
		
	}
	
	public Destino(String nome, String estado, String pais, float valor) {
		this.nome = nome;
		this.estado = estado;
		this.pais = pais;
		this.valor = valor;
	}
	
	public Destino(int id, String nome, String estado, String pais, float valor){
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.valor = valor;
		this.pais = pais;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void mostrar() {
		System.out.println("=====================================");
		System.out.println("ID: "+this.id);
		System.out.println("Nome: "+this.nome);
		System.out.println("Pais: "+this.pais);
		System.out.println("Estado: "+this.estado);
		System.out.printf("Valor: R$%.2f %n",this.valor);
		System.out.println("=====================================");
	}
}
