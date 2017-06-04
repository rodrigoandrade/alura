package produtos;

public class TestaMenorPreco {

	public static void main(String[] args) {
		Produto produtos[] = { 
				new Produto("Lamborghini", 1000000), 
				new Produto("Jipe", 46000),
				new Produto("Brasilia", 16000), 
				new Produto("Smart", 46000), 
				new Produto("Fusca", 17000) 
			};

		int maisBarato = buscaMenor(produtos);

		System.out.println("Carro mais barato: " + produtos[maisBarato].getNome());
		System.out.println("Preco mais caro: " + produtos[maisBarato].getPreco());
	}

	private static int buscaMenor(Produto[] produtos) {
		int maisBarato = 0;
		for (int atual = 0; atual < produtos.length; atual++) {
			if (produtos[atual].getPreco() < produtos[maisBarato].getPreco()) {
				maisBarato = atual;
			}
		}
		return maisBarato;
	}
}
