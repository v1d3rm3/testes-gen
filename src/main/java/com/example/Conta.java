package com.example;

import java.util.Arrays;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Conta {

    private Long id;

    private String beneficiario;

    private Banco banco;

    private Double saldo;

    private int numeroConta;

    private char digitoVerificador;


    /**
     * Says hello to the world.
     * @param numeroConta numero da conta para ser validado.
     * @see https://www.creditas.com/exponencial/digito-da-conta-o-que-e-para-que-serve-e-como-encontra-lo/
     */
    public char calculaDigitoVerificador(int numeroConta) {
        Integer[] digitosConta = new Integer[8];
        Arrays.fill(digitosConta, 0);
        int[] multiplicadores = {2,3,4,5,6,7,8,9};
        String numeroContaAsString = new StringBuilder(
                String.valueOf(numeroConta))
                .reverse().toString();

        for (int i = 0; i < numeroContaAsString.length(); i++) {
            char c = numeroContaAsString.charAt(i);
            digitosConta[i] = (Integer) (Character.getNumericValue(c) * multiplicadores[i]);
        }

        int somaDigitos = Stream.of(digitosConta).reduce(0, Integer::sum);
        int restoDivisao = somaDigitos % 11;
        if(restoDivisao < 10){
            return Character.forDigit(restoDivisao, 10);
        }
        return 'X';
    }
}
