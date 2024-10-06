package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Conta conta = new Conta();
        char digito = conta.calculaDigitoVerificador(262634);
        System.out.println(digito);
    }
}
