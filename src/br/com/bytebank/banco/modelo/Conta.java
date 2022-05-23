package br.com.bytebank.banco.modelo;

public abstract class Conta extends Object implements Comparable<Conta>{
	
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;

	
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		setAgencia(agencia);
		this.agencia = agencia;
		this.numero = numero;
	}
	

	public abstract void deposita(double valor);

	public void saca(double valor) throws SaldoInsuficienteException{
		if( this.saldo < valor ) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
		}
		this.saldo -= valor;
	}
	
	public void transfere (double valor, Conta destino) throws SaldoInsuficienteException{
		this.saca(valor);
		destino.deposita(valor);
	}
	
	public double getSaldo (){
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if (agencia <= 0) {
			System.out.println("nao pode valor menor ou igual a 0");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("nao pode valor menor ou igual a 0");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
	
	@Override
	public String toString() {

		return "Numero: " + this.getNumero() + ", Agencia: " + this.getAgencia() + "Saldo: " + this.saldo;
	}

	@Override
	public int compareTo(Conta outra) {
		return Double .compare(this.saldo, outra.saldo);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Conta outra = (Conta) obj;

		if(this.agencia == outra.agencia && this.numero == outra.numero) {
			return true;
		}
		return false;
	}
}
