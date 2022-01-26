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
    
    public static int solicitarInt(String texto) {
    	char c = solicitarChar(texto);
    	return Character.getNumericValue(c);
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
    
    public static void encerrarSistema() {
    	System.exit(0);
    }
    
    public static int solicitarUmaOpcao(int tamanhoMaximoDoNumeroDaOpcao) {
    	while (true) {
			int numeroDaOpcao = Utils.solicitarInt("Sua opção: ");

			if (opcaoEhValida(numeroDaOpcao, tamanhoMaximoDoNumeroDaOpcao)) {
				return numeroDaOpcao;
			} else {
				System.out.println(String.format("Opção inválida. Informe um número entre 1 e %d", tamanhoMaximoDoNumeroDaOpcao));
			}
		}
    }
    
	private static boolean opcaoEhValida(int numeroDaOpcao, int maximo) {
		return numeroDaOpcao >= 1 && numeroDaOpcao <= maximo;
	}
	
	public static boolean obterSimOuNao(String texto) {
    	char letra = solicitarChar(texto);
    	letra = Character.toLowerCase(letra);
    	
    	if (letra == 's' || letra == 'n') {
			return letra == 's';
		}
    	
        System.out.println("Caracter inválido! Informe S ou N para continuar!");
        return obterSimOuNao(texto);
    }
}
