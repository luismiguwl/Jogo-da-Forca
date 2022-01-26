package com.luis.forca;

import java.util.List;
import static com.luis.forca.Utils.*;

public class Principal {

    public static void main(String[] args) {
    	AcessoADados acessoADados = new AcessoADados(Destino.getDestino(Categoria.FILMES));
        List<ElementoDaForca> palavrasEDicas = acessoADados.obterPalavrasEDicas();
        
        while (true) {
            System.out.println("===========================================");
            
            ElementoDaForca elemento = obterElementoAleatorio(palavrasEDicas);
            Forca forca = new Forca(elemento.getPalavra(), elemento.getDica());
            forca.iniciar();
            
            System.out.println("===========================================");
            
            boolean querJogarNovamente = perguntarSeDesejaJogarNovamente();
            
            if (!querJogarNovamente) {
                System.out.println("Obrigado por jogar!");
                System.exit(0);
            }
        }
    }

    private static ElementoDaForca obterElementoAleatorio(List<ElementoDaForca> elementos) {
        int numeroAleatorio = obterNumeroAleatorio(elementos.size());
        return elementos.get(numeroAleatorio);
    }

    private static boolean perguntarSeDesejaJogarNovamente() {
    	char letra = solicitarChar("Deseja jogar novamente(S/N)? ");
    	letra = Character.toLowerCase(letra);
    	
    	if (letra == 's' || letra == 'n') {
			return letra == 's';
		}
    	
        System.out.println("Caracter inválido! Informe S ou N para continuar!");
        return perguntarSeDesejaJogarNovamente();
    }
}
