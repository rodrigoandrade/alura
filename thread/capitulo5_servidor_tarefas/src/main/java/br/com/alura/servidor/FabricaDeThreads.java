package br.com.alura.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

	private static int numero = 1;
	
	private ThreadFactory defaultFactory;

    public FabricaDeThreads(ThreadFactory defaultFactory) {
        this.defaultFactory = defaultFactory;
    }

    public Thread newThread(Runnable tarefa) {

    	//criando uma thread usando para fabrica padrão
        Thread thread = defaultFactory.newThread(tarefa); 

        //personalizando a thread
        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
        return thread;
    }
}
