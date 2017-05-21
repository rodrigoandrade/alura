package br.com.caelum.lista;

public class TarefaAdicionarELemento implements Runnable {

	private Lista lista;
	//private Lista lista;
	private int numeroDoThread;
	
	public TarefaAdicionarELemento(Lista lista, int numeroDoThread) {
		this.lista = lista;
		this.numeroDoThread = numeroDoThread;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.adicionaElementos("Thread " + numeroDoThread + " - " + i);
		}
	}

}
