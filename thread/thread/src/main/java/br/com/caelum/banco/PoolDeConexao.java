package br.com.caelum.banco;

public class PoolDeConexao {

	public String getConnection() {
		System.out.println("Emprestando conexão - PoolDeConexao");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "connection";
	}
}
