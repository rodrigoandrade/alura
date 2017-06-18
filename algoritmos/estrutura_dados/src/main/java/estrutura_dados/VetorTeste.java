package estrutura_dados;

public class VetorTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Jo�o");
		Aluno a2 = new Aluno("Jose");
		
		Vetor lista = new Vetor();
		
		System.out.println(lista.tamanho());
		lista.adiciona(a1);
		
		System.out.println(lista.tamanho());
		lista.adiciona(a2);
		
		System.out.println(lista.tamanho());
		
		System.out.println(lista.contem(a1));

		/*Aluno x = lista.pega(1);
		System.out.println(x);
		
		Aluno x1 = lista.pega(101);
		System.out.println(x1);*/
		
		Aluno a3 = new Aluno("Danilo");
		lista.adiciona(1, a3);
		
		System.out.println(lista);
		
		System.out.println("removendo");
		lista.remove(1);
		System.out.println(lista);
		
		for (int i = 0; i < 300; i++) {
			Aluno y = new Aluno("Joao " + i);
			lista.adiciona(y);		
		}
		
		System.out.println(lista);
	}
}
