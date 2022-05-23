package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteOrdenacao {

    public static void main(String[] args) {

        Conta cc1 = new ContaCorrente(22, 33);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        
        for (Conta conta : lista) {
			System.out.println(conta);
		}
        
        Comparadora comparador = new Comparadora();
        
        lista.sort(comparador);

        Collections.sort(lista, new Comparadora());
        
        System.out.println("************");
        
        for (Conta conta : lista) {
			System.out.println(conta);
		}
        
        System.out.println("************");
        
        Collections.rotate(lista, 3);

        for (Conta conta : lista) {
			System.out.println(conta);
		}
    }

}

class Comparadora implements Comparator<Conta>{

	@Override
	public int compare(Conta c1, Conta c2) {

		return Integer.compare(c1.getNumero(), c2.getNumero());
//		
//		if(c1.getNumero() < c2.getNumero()) {
//			return -1;
//		} else if (c1.getNumero() == c2.getNumero()) { 
//			return 0;
//		} else {
//			return 1;
//		}
	}
}	

