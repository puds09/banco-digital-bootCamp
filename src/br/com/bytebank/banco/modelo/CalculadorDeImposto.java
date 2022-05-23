package br.com.bytebank.banco.modelo;


public class CalculadorDeImposto {

	private double totalImposto;

	public void registro(Tributavel t) {
		double valor = t.getValorImposto();
		totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
}
