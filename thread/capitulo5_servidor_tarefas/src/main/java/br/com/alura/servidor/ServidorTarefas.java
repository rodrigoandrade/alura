package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {
	
	ThreadFactory defaultFactory = Executors.defaultThreadFactory();
	private ExecutorService threadPool;
	private ServerSocket servidor;
	//private boolean estaRodando;
	private AtomicBoolean estaRodando;
	
	public ServidorTarefas() throws IOException {
		System.out.println("--- Iniciando servidor ---");
		this.servidor = new ServerSocket(12345);
		this.threadPool = Executors.newFixedThreadPool(4, new FabricaDeThreads(defaultFactory));
		//this.estaRodando = true;
		estaRodando = new AtomicBoolean(true);
	}
	
	public void rodar() throws IOException {
		while(this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando novo cliente na porta " + socket.getPort());
				
				// na classe ServidorTarefas
				// no método rodar()
				DistribuirTarefas distribuidor = new DistribuirTarefas(threadPool, socket, this);
				
				//DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket, this);
				threadPool.execute(distribuidor);
			} catch (Exception e) {
				System.out.println("SocketException, Está rodando? " + this.estaRodando);
			}
		}
	}

	public void parar() throws IOException {
		//estaRodando = false;
		estaRodando.set(false);
		servidor.close();
		threadPool.shutdown();
	}
	
	public static void main(String[] args) throws IOException {
		ServidorTarefas servidor = new ServidorTarefas();
		servidor.rodar();
		servidor.parar();
	}
	
	
	/*public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("--- Iniciando servidor ----");
		ServerSocket servidor = new ServerSocket(12345);
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			threadPool.execute(distribuirTarefas);
			
			System.out.println("Foi interrompida: " + threadPool.isTerminated());
			
			//Thread threadCliente = new Thread(distribuirTarefas);
			//threadCliente.start();
		}
	}*/

}
