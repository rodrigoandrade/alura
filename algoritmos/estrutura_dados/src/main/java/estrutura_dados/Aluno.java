package estrutura_dados;

public class Aluno {

	private String nome;
	
	public Aluno(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean equals(Object obj) {
		Aluno outro = (Aluno) obj;
		return outro.getNome().equals(this.nome);
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
