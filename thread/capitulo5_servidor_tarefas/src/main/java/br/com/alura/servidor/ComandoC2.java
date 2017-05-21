package br.com.alura.servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

private PrintStream saida;
	
	public ComandoC2(PrintStream saida) {
		this.saida = saida;
	}
	
	public void run() {
		System.out.println("Executando comando C2");
		try {
			//faz algo bem demorado
			Thread.sleep(2000);
			//throw new RuntimeException("Exception no comando c2");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		//devolvendo resposta para o cliente
		//saida.println("Comando C2 executado com sucesso");
	}

}
