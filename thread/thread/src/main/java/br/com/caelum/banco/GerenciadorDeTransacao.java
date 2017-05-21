package br.com.caelum.banco;

public class GerenciadorDeTransacao {

	public void begin() {
        System.out.println("Começando a transação - GerenciadorDeTransacao");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
