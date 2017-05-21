package br.com.alura.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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
	private BlockingQueue<String> filaComandos;
	
	public ServidorTarefas() throws IOException {
		System.out.println("--- Iniciando servidor ---");
		this.servidor = new ServerSocket(12345);
		this.threadPool = Executors.newCachedThreadPool();
		//this.estaRodando = true;
		estaRodando = new AtomicBoolean(true);
		filaComandos = new ArrayBlockingQueue<>(2);
		iniciarConsumidores();
	}
	
	private void iniciarConsumidores() {
		int qtdeConsumidores = 2;
		for (int i = 0; i < qtdeConsumidores; i++) {
			TarefaConsumir tarefa = new TarefaConsumir(filaComandos);
			this.threadPool.execute(tarefa);
		}
	}

	public void rodar() throws IOException {
		while(this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando novo cliente na porta " + socket.getPort());
				
				// na classe ServidorTarefas
				// no método rodar()
				DistribuirTarefas distribuidor = new DistribuirTarefas(threadPool, filaComandos, socket, this);
				
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

}
