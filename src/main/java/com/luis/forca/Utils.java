package com.luis.forca;

import static com.luis.forca.Status.VENCEDOR;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static char solicitarChar(String texto) {
        System.out.print(texto);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        
        return input.charAt(0);
    }

    public static int obterNumeroAleatorio(int limite) {
        return new Random().nextInt(limite);
    }
    
    public static void exibirPalavraEscondida(char[] palavraEscondida) {
        for (int i = 0; i < palavraEscondida.length; i++) {
            System.out.print(palavraEscondida[i]);
        }
        
        System.out.println();
    }
    
    public static void exibirMensagemFinal(Status status, String palavra) {
        if (status.equals(VENCEDOR)) {
            System.out.println("Você venceu! A palavra é " + palavra);
        } else {
            System.out.println("Você perdeu! A palavra era " + palavra);
        }
    }
}
