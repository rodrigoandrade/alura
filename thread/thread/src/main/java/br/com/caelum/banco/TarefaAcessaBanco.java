package br.com.caelum.banco;

public class TarefaAcessaBanco implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	public void run() {
		synchronized (pool) {
			System.out.println("Peguei a chave do pool");
			pool.getConnection();
			
			synchronized (tx) {
				System.out.println("come�ando a gerenciar a tx");
				tx.begin();
			}
		}
	}

}
