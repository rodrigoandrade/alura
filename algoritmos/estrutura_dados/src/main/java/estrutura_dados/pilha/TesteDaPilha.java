package estrutura_dados.pilha;

public class TesteDaPilha {
	
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		pilha.insere("Mauricio");
		System.out.println(pilha);
		pilha.insere("Guilherme");
		System.out.println(pilha);
		
		String r1 = pilha.remove();
		System.out.println("Removendo: " + r1);
		System.out.println(pilha);
		
		String r2 = pilha.remove();
		System.out.println("Removendo: " + r2);
		System.out.println(pilha);
	}
}
