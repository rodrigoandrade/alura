package estrutura_dados.listaligada;

public class TestaListaLigada {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        System.out.println(lista);
        lista.adicionaNoComeco("mauricio");
 
        System.out.println(lista);
        lista.adicionaNoComeco("paulo");
        
        System.out.println(lista);
        lista.adicionaNoComeco("guilherme");
        
        System.out.println(lista);
        lista.adiciona("marcelo");
        
        System.out.println(lista);
        lista.adiciona(2, "gabriel");
        
        Object x = lista.pega(2);
        System.out.println("valor x: " + x);
        
        System.out.println("tamaho: " + lista.tamanho());
        
      // System.out.println(lista);
      //  lista.removeDoComeco();
        
      //  System.out.println(lista);
      //  lista.removeDoFim();
        
        System.out.println(lista);
        lista.remove(2);
        
        System.out.println(lista.contem("mauricio"));
        System.out.println(lista.contem("danilo"));
        
        System.out.println(lista);
    }
}
