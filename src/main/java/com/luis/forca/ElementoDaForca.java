package com.luis.forca;

public class ElementoDaForca {

    private String palavra;
    private String dica;

    public ElementoDaForca(String palavra, String dica) {
        this.palavra = palavra;
        this.dica = dica;
    }

    public String getPalavra() {
        return palavra;
    }

    public String getDica() {
        return dica;
    }

}
