package estrutura_dados.conjunto;

public class TesteDeConjunto {
	
	public static void main(String[] args) {
		Conjunto conjunto = new Conjunto();
		conjunto.adiciona("Mauricio");
		System.out.println(conjunto);

		conjunto.adiciona("Mauricio");
		System.out.println(conjunto);

		conjunto.adiciona("Marcelo");
		System.out.println(conjunto);
		
		conjunto.adiciona("Guilherme");
		System.out.println(conjunto);
		
		conjunto.adiciona("Marcia");
		System.out.println(conjunto);
		
		conjunto.adiciona("Gustavo");
		System.out.println(conjunto);
	
		conjunto.remove("Marcelo");
		System.out.println(conjunto);
	}

}
