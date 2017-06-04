package produtos;

public class OrdenaPorInsercao {
	
	public static void main(String[] args) {
		Produto produtos[] = { 
				new Produto("Lamborghini", 1000000), 
				new Produto("Jipe", 46000),
				new Produto("Brasilia", 16000), 
				new Produto("Smart", 46000), 
				new Produto("Fusca", 17000) 
			};
		
		selectionSort(produtos, produtos.length);
	}
	
	public static void selectionSort(Produto[] produtos, int quantidadeDeElementos) {
		for (int atual = 1; atual < quantidadeDeElementos; atual++) {
			System.out.println("Estou na casinha " + atual);
			int analise = atual;
			while (analise > 0 && produtos[analise].getPreco() < produtos[analise-1].getPreco()) {
				troca(produtos, analise, analise -1);
				
				analise--;
			}
		}
	}

	private static void troca(Produto[] produtos, int primeiro, int segundo) {
		System.out.println("Estou trocando " + primeiro + " com " + (segundo));
		Produto primeiroProduto = produtos[primeiro];
		Produto segundoProduto = produtos[segundo];
		System.out.println("Estou trocando " + primeiroProduto.getNome() + " com " + segundoProduto.getNome());
		produtos[primeiro] = segundoProduto;
		produtos[segundo] = primeiroProduto;
	}

}
