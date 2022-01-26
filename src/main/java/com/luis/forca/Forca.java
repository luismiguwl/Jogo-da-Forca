package com.luis.forca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.luis.forca.Status.*;
import static com.luis.forca.Utils.*;

public class Forca {

    private final String palavra;
    private final String dica;
    private char[] palavraEscondida;
    private List<Character> letrasUsadas;
    private int erros;

    private static final int CHANCES = 5;

    public Forca(String palavra, String dica) {
        this.palavra = palavra;
        this.dica = dica;
        this.erros = 0;
        letrasUsadas = new ArrayList<>();
        esconderPalavra();
    }

    public void iniciar() {
        System.out.println("Dica: " + dica);

        while (true) {
            char letra = solicitarLetra();

            if (letraJaFoiUsada(letra)) {
                System.out.println("========== Letra já foi usada. Tente outra ==========");
                continue;
            }

            if (letraExisteNaPalavra(letra)) {
                substituirLetraNaPalavraEscondida(letra);
                exibirPalavraEscondida(getPalavraEscondida());
            } else {
                System.out.println(String.format("'%s' não existe na palavra", letra));

                erros++;
                if (chancesAcabaram()) {
                    exibirMensagemFinal(PERDEDOR, palavra);
                    break;
                }

                System.out.println(String.format("Você ainda tem %d chances", (getChancesRestantes())));
            }

            if (palavraEstaCompleta()) {
                exibirMensagemFinal(VENCEDOR, palavra);
                break;
            }

            letrasUsadas.add(letra);
        }

    }

    public void esconderPalavra() {
        palavraEscondida = new char[palavra.length()];

        for (int i = 0; i < palavraEscondida.length; i++) {
            char caracter = palavra.charAt(i);

            if (ehLetra(caracter) || ehNumero(caracter)) {
                palavraEscondida[i] = '_';
            } else {
                palavraEscondida[i] = caracter;
            }
        }
    }

    public boolean ehLetra(char caracter) {
        return "abcdefghijklmnopqrstuvwxyzç".contains(Character.toString(caracter).toLowerCase());
    }
    
    public boolean ehNumero(char caracter) {
        return "0123456789".contains(Character.toString(caracter));
    }

    private char solicitarLetra() {
    	char caracter = Utils.solicitarChar("Informe uma letra: ");
        return ehLetra(caracter) ? caracter : solicitarLetra();
    }

    public boolean letraJaFoiUsada(char letraAlvo) {
        return letrasUsadas.stream().anyMatch(letra -> letra == letraAlvo);
    }

    public boolean letraExisteNaPalavra(char letraAlvo) {
        return Arrays.stream(palavra.toLowerCase().split(""))
                .anyMatch(letra -> letra.equalsIgnoreCase(Character.toString(letraAlvo)));
    }

    public boolean chancesAcabaram() {
        return getChancesRestantes() == 0;
    }

    public int getChancesRestantes() {
        return CHANCES - getErros();
    }
    
    public int getErros() {
    	return erros;
    }

    public void substituirLetraNaPalavraEscondida(char letra) {
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.toLowerCase().charAt(i) == Character.toLowerCase(letra)) {
                palavraEscondida[i] = palavra.charAt(i);
            }
        }
    }

    public boolean palavraEstaCompleta() {
        return Arrays.equals(palavraEscondida, palavra.toCharArray());
    }
    
    public char[] getPalavraEscondida() {
    	return palavraEscondida;
    }
    
    public void setPalavraEscondida(char[] palavraEscondida) {
    	this.palavraEscondida = palavraEscondida;
    }
    
    public List<Character> getLetrasUsadas() {
    	return letrasUsadas;
    }
    
    public String getPalavra() {
    	return palavra;
    }
}
