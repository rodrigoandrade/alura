package br.com.caelum.lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista();
		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarELemento(lista, i)).start();
		}
		
		new Thread(new TarefaImprimir(lista)).start();
		
		
		//List<String> lista = Collections.synchronizedList(new ArrayList<>());
		//Lista lista = new Lista();
		//for (int i = 0; i < 10; i++) {
		//	new Thread(new TarefaAdicionarELemento(lista, i)).start();
		//}
		
		//Thread.sleep(2000);
	
		//for (int i = 0; i < lista.size(); i++) {
		//	System.out.println(i + " - " + lista.get(i));
		//}
	}

}
