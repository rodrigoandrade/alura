package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2AcessaBanco implements Callable<String> {

private PrintStream saida;
	
	public ComandoC2AcessaBanco(PrintStream saida) {
		this.saida = saida;
	}
	
	public String call() throws Exception {
		System.out.println("Executando comando C2 - Banco");
		
		saida.println("processando comando C2 - Banco");
		
		Thread.sleep(25000);

		int numero = new Random().nextInt(100) + 1;
		
		System.out.println("Servidor finalizou comando C2 - Banco: " + numero);
		return Integer.toString(numero);
	}

}
