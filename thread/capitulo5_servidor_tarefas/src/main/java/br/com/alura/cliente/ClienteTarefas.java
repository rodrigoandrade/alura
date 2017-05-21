package br.com.alura.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {

	public static void main(String[] args) throws Exception {
		final Socket socket = new Socket("localhost", 12345);
		System.out.println("Conex�o estabelecida.");
		
		Thread threadEnviaComando = new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("Pode enviar comandos!");
					PrintStream saida = new PrintStream(socket.getOutputStream());
					Scanner teclado = new Scanner(System.in);
					while(teclado.hasNextLine()) {
						String linha = teclado.nextLine();
						if (linha.trim().equals("")) {
							break;
						}
						saida.println(linha);
					}
					saida.close();
					teclado.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		Thread threadRecebeResposta = new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println("recebendo dados do servidor");
					Scanner respostaServidor = new Scanner(socket.getInputStream());
					while(respostaServidor.hasNextLine()) {
						String linha = respostaServidor.nextLine();
						System.out.println(linha);
					}
					respostaServidor.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		threadRecebeResposta.start();
		threadEnviaComando.start();
		
		System.out.println("Fechando socket do cliente");
		threadEnviaComando.join();
		
		socket.close();
	} 

}
