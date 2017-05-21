package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWSFutureBanco implements Callable<Void> {

	private Future<String> resultadoWS;
	private Future<String> resultadoBanco;
	private PrintStream saidaCliente;

	public JuntaResultadosFutureWSFutureBanco(Future<String> resultadoWS, Future<String> resultadoBanco,
			PrintStream saidaCliente) {
				this.resultadoWS = resultadoWS;
				this.resultadoBanco = resultadoBanco;
				this.saidaCliente = saidaCliente;

	}

	@Override
	public Void call() throws Exception {
		System.out.println("Aguardando resultados do Future WS e do Banco");
		
		try {
			String numeroMagico1 = resultadoWS.get(20, TimeUnit.SECONDS);
			String numeroMagico2 = resultadoBanco.get(20, TimeUnit.SECONDS);
		
			this.saidaCliente.println("Resultado comando C2 : " + numeroMagico1 + ", " + numeroMagico2);
		
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Timeout: Cancelando execução do comando C2");
			this.saidaCliente.println("Timeout na execução do comando C2");
			this.resultadoBanco.cancel(true);
			this.resultadoWS.cancel(true);
		}
		
		System.out.println("Finalizou JuntaResultadosFutureWSFutureBanco");
		return null;
	}

}
