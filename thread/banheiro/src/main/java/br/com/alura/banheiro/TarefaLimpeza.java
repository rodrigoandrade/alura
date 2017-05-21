package br.com.alura.banheiro;

public class TarefaLimpeza implements Runnable {
	
	private Banheiro banheiro;
	
	public TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	public void run() {
		while(true) {
			banheiro.limpa();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
