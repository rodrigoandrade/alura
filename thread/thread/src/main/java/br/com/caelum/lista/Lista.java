package br.com.caelum.lista;

public class Lista {
	
	private String[] elementos = new String[1000];
	private int indice = 0;
	
	public void adicionaElementos(String elemento) {
		synchronized (this) {
			this.elementos[indice] = elemento;
			this.indice++;
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (this.indice == this.elementos.length) {
				System.out.println("A lista tá cheia, notificando");
				this.notify();
			}
		}
	}
	
	public int tamanho() {
		return this.elementos.length;
	}
	
	public String pegaELemento(int posicao) {
		return this.elementos[posicao];
	}

}
