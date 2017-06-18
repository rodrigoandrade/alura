package estrutura_dados;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;
	
	public void adiciona(Aluno aluno) {
		garanteEspaco();
		this.alunos[totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}
	
	public void adiciona(int posicao, Aluno aluno) {
		garanteEspaco();
		
		if (!posicaoValida(posicao)) {
			throw new IllegalArgumentException("posicao Invalida");
		}
		
		for (int i = totalDeAlunos -1; i >= posicao; i--) {
			alunos[i+1] = alunos[i];
		}
		alunos[posicao] = aluno;
		totalDeAlunos++;
	}
	
	public boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= totalDeAlunos;
	}
	
	public Aluno pega(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("posicao invalida");
		}
		return alunos[posicao];
	}
	
	public void remove(int posicao) {
		for (int i = posicao; i < totalDeAlunos -1; i++) {
			alunos[posicao] = alunos[i+1]; 
		}
		totalDeAlunos--;
		alunos[totalDeAlunos] = null;
	}
	
	public void garanteEspaco() {
		if (totalDeAlunos == alunos.length) {
			Aluno[] novoArray = new Aluno[alunos.length*2];
			for (int i = 0; i < alunos.length; i++) {
				novoArray[i] = alunos[i];
			}
			alunos = novoArray;
		}
	}

	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalDeAlunos; i++) {
			if (aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int tamanho() {
		return this.totalDeAlunos;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao <= totalDeAlunos;
	}
	
	public String toString() {
		return Arrays.toString(alunos);
	}
}
