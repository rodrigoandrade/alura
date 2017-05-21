package br.com.caelum.banco;

public class TarefaAcessaBancoProcidemento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcidemento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	public void run() {
		synchronized (pool) {
			System.out.println("pegue a conexao");
			pool.getConnection();
			
			synchronized (tx) {
				System.out.println("Começando a tx");
				tx.begin();
			}
		}
	}

}
