package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteSaca {

	public static void main(String[] args) {
		Conta conta = new ContaCorrente(123,  321);
		
		conta.deposita(200);
		try {
			conta.saca(210);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(conta.getSaldo());
	}
}
