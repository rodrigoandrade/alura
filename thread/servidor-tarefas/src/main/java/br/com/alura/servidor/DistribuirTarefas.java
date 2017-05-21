package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;

	public DistribuirTarefas(Socket socket, ServidorTarefas servidor) {
		this.socket = socket;
		this.servidor = servidor;
	}
	
	@Override
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
					saidaCliente.println("Confirma��o comando C1");
					break;
				case "C2":
					saidaCliente.println("Confirma��o comando C2");
					break;
				case "FIM":
					saidaCliente.print("Desligando o servidor");
					servidor.parar();
					break;
				default:
					saidaCliente.println("comando n�o encontrado");
				}
			}
			entradaCliente.close();
			Thread.sleep(20000);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
