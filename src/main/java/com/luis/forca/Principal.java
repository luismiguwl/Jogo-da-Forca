package com.luis.forca;

import java.util.List;
import static com.luis.forca.Utils.*;

public class Principal {
	
    public static void main(String[] args) {
    	exibirMenu();
    	Categoria categoria = Categoria.solicitarCategoria();
    	
        while (true) {
        	AcessoADados acessoADados = new AcessoADados(Destino.getDestino(categoria));
            List<ElementoDaForca> palavrasEDicas = acessoADados.obterPalavrasEDicas();
            
            System.out.println("===========================================");
            
            ElementoDaForca elemento = obterElementoAleatorio(palavrasEDicas);
            Forca forca = new Forca(elemento.getPalavra(), elemento.getDica());
            forca.iniciar();
            
            System.out.println("===========================================");
            
            boolean querJogarNovamente = obterSimOuNao("Deseja jogar novamente? (S/N) ");
            
            if (!querJogarNovamente) {
            	encerrarJogoSeUsuarioDesejar();
            }
            
            boolean desejaVerMenu = obterSimOuNao("Deseja ver menu? (S/N) ");
            
            if (desejaVerMenu) {
				exibirMenu();
				categoria = Categoria.solicitarCategoria();
			}
        }
    }

    private static ElementoDaForca obterElementoAleatorio(List<ElementoDaForca> elementos) {
        int numeroAleatorio = obterNumeroAleatorio(elementos.size());
        return elementos.get(numeroAleatorio);
    }
    
    private static void exibirMenu() {
    	Menu menu = new Menu();
    	menu.exibirOpcoes();
    	menu.solicitarOpcaoAtual();
    	menu.executarOpcao();
    }
    
    private static void encerrarJogoSeUsuarioDesejar() {
    	boolean desejaEncerrarJogo = obterSimOuNao("Deseja encerrar jogo? (S/N) ");
    	
    	if (desejaEncerrarJogo) {
    		System.out.println("Obrigado por jogar!");
			encerrarSistema();
		}
    }
    
}
