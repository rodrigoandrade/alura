package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool;

	public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
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
					ComandoC2 c2 = new ComandoC2(saidaCliente);
					this.threadPool.execute(c2);
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

	/*@Override
	public void run() {
		System.out.println("Distribuindo tarefas para " + socket);
		try {
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			while(entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println(comando);
			}
			entradaCliente.close();
			Thread.sleep(20000);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

}
