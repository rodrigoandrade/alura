package br.com.alura.servidor;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExcecao implements UncaughtExceptionHandler {

    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Deu exce��o na thread " + t.getName() + ", "
                + e.getMessage());
    }

}
