package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWS implements Callable<String> {

private PrintStream saida;
	
	public ComandoC2ChamaWS(PrintStream saida) {
		this.saida = saida;
	}
	
	public String call() throws Exception {
		System.out.println("Executando comando C2 - WS");
		
		saida.println("processando comando C2");
		
		//Thread.sleep(25000);

		int numero = new Random().nextInt(100) + 1;
		
		System.out.println("Servidor finalizou comando C2 - WS: " + numero);
		return Integer.toString(numero);
	}

}
