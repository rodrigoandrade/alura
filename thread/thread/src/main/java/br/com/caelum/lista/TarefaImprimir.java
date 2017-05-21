package br.com.caelum.lista;

public class TarefaImprimir implements Runnable {
	
	private Lista lista;
	
	public TarefaImprimir(Lista lista) {
		this.lista = lista;
	}

	public void run() {
		synchronized(lista) {
			try {
				System.out.println("Indo dormir, aguardando notificação!");
				lista.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < lista.tamanho(); i++) {
				System.out.println(i + " - " + lista.pegaELemento(i));
			}
		}
	}

}
