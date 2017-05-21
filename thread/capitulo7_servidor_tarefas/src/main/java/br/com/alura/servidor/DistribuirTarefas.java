package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool;
	private BlockingQueue<String> filaComandos;

	public DistribuirTarefas(ExecutorService threadPool, BlockingQueue<String> filaComandos, Socket socket, ServidorTarefas servidor) {
		this.filaComandos = filaComandos;
		this.socket = socket;
		this.servidor = servidor;
		this.threadPool = threadPool;
	}
	
	public void run() {
		System.out.println("Distribuindo tarefas para " + socket);
		try {
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
			
			while(entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println("Comando recebido: " + comando);
				
				switch (comando) {
				case "C1":
					saidaCliente.println("Confirmação comando C1");
					ComandoC1 c1 = new ComandoC1(saidaCliente);
					this.threadPool.execute(c1);
					break;
				case "C2":
					saidaCliente.println("Confirmação comando C2");
					ComandoC2ChamaWS c2WS = new ComandoC2ChamaWS(saidaCliente);
					System.out.println("Valor ComandoC2ChamaWS GET: " + c2WS.call());
					
					ComandoC2AcessaBanco c2Banco = new ComandoC2AcessaBanco(saidaCliente);
					System.out.println("Valor ComandoC2AcessaBanco GET: " + c2WS.call());
					
					Future<String> resultadoWS = this.threadPool.submit(c2WS);
					Future<String> resultadoBanco = this.threadPool.submit(c2Banco);
					
					this.threadPool.submit(new JuntaResultadosFutureWSFutureBanco(resultadoWS, resultadoBanco, saidaCliente));
					
				case "C3":
					this.filaComandos.put(comando);
					saidaCliente.println("Comando C3 adicionado na pilha");
					servidor.parar();
					break;	
					
				case "FIM":
					saidaCliente.print("Desligando o servidor");
					servidor.parar();
					break;
				default:
					saidaCliente.println("comando não encontrado");
				}
			}
			entradaCliente.close();
			Thread.sleep(20000);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
