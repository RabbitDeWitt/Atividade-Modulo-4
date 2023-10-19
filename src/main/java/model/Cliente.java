package model;

import java.util.Date;

public class Cliente {
	private int id;
	private String nome, numPassaporte, telefone;
	private Date dataNasc;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, Date dataNasc, String telefone ,String numPassaporte) {
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.numPassaporte = numPassaporte;
	}
	
	public Cliente(int id, String nome, Date dataNasc, String telefone, String numPassaporte){
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.numPassaporte = numPassaporte;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNumPassaporte() {
		return numPassaporte;
	}

	public void setNumPassaporte(String numPassaporte) {
		this.numPassaporte = numPassaporte;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		System.out.println("Data de Nasc: "+this.dataNasc);
		System.out.println("Telefone: "+this.telefone);
		System.out.println("Num. do Passaporte: "+this.numPassaporte);
		System.out.println("=====================================");
	}
}
