package estrutura_dados.listaligada;

public class Celula {

	private Object elemento;
	private Celula proximo;
	private Celula anterior;
	
	public Celula(Object elemento) {
		this(null, elemento);
	}

	public Celula(Object elemento, Celula proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}

	public Celula(Celula proximo, Object elemento) {
		this.proximo = proximo;
		this.elemento = elemento;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

	public Object getElemento() {
		return elemento;
	}

	public Celula getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
}