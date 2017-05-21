package br.com.alura.servidor;

public class ServidorDeTeste {

	private volatile boolean estaRodando;
	
	public static void main(String[] args) {
		ServidorDeTeste servidor = new ServidorDeTeste();
		servidor.rodar();
		servidor.estaRodando = true;
	}
	
	private void rodar() {
		try {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					System.out.println("Servidor começando, estaRodando = " + estaRodando);
					while (!estaRodando) {
					}
					
					if (estaRodando) {
						throw new RuntimeException("Deu erro na thread...");
					}
					
					System.out.println("Servidor rodando, estaRodando = " + estaRodando);
					
					while (estaRodando) {
					}
					
					System.out.println("Servidor terminando, estaRodando = " + estaRodando);
				}
			});
			
			// passando o objeto com a responsabilidade de tratamento de erro
		    thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
		    thread.start();
		    
		} catch (Exception e) {
			System.out.println("Catch na thread MAIN " + e.getMessage());
		}
	}
}
