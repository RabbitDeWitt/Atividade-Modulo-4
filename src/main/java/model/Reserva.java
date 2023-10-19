package model;

import java.util.Date;

public class Reserva {
	private int id;
	private Date dataPartida, dataRetorno;
	private Cliente cliente;
	private Destino destino;
	private Pacote pacote;
	private float valorTotal;
	
	public Reserva() {
		
	}
	
	
	public Reserva(Date dataPartida, Date dataRetorno, Cliente cliente, Destino destino, Pacote pacote) {
		this.dataPartida = dataPartida;
		this.dataRetorno = dataRetorno;
		this.cliente = cliente;
		this.destino = destino;
		this.pacote = pacote;
		this.valorTotal = destino.getValor() + pacote.getValor();
	}
	
	public Reserva(int id, Date dataPartida, Date dataRetorno, Cliente cliente, Destino destino, Pacote pacote) {
		this.id = id;
		this.dataPartida = dataPartida;
		this.dataRetorno = dataRetorno;
		this.cliente = cliente;
		this.destino = destino;
		this.pacote = pacote;
		this.valorTotal = destino.getValor() + pacote.getValor();
	}

	public Reserva(int id, Date dataPartida, Date dataRetorno, Cliente cliente, Destino destino, Pacote pacote, float valorTotal) {
		this.id = id;
		this.dataPartida = dataPartida;
		this.dataRetorno = dataRetorno;
		this.cliente = cliente;
		this.destino = destino;
		this.pacote = pacote;
		this.valorTotal = valorTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public void mostrar() {
		System.out.println("=====================================");
		System.out.println("ID: "+this.id);
		System.out.println("Cliente: "+this.cliente.getNome());
		System.out.println("Destino: "+this.destino.getNome());
		System.out.println("Partida: "+this.dataPartida);
		System.out.println("Retorno: "+this.dataRetorno);
		System.out.println("Pacote: "+this.pacote.getNome());
		System.out.printf("Valor Total: R$%.2f %n",this.valorTotal);
		System.out.println("=====================================");
	}
}
