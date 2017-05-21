package br.com.alura.servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

	private PrintStream saida;
	
	public ComandoC1(PrintStream saida) {
		this.saida = saida;
	}
	
	public void run() {
		System.out.println("Executando comando C1");
		try {
			//faz algo bem demorado
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		//devolvendo resposta para o cliente
		saida.println("Comando C1 executado com sucesso");
	}

}
