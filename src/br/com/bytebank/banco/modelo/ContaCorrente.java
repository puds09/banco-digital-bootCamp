package br.com.bytebank.banco.modelo;



//new ContaCorrente()
public class ContaCorrente extends Conta implements Tributavel{

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteException{
		double valorASacar = valor + 0.20;
		super.saca(valorASacar);
	}

	@Override
	public double getValorImposto() {
		
		return super.saldo * 0.01;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ContaCorrente " + super.toString();
	}


}
