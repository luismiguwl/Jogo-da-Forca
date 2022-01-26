package com.luis.forca;

public class ElementoDaForca {

    private String palavra;
    private String dica;
    private Categoria categoria;

    public ElementoDaForca(String palavra, String dica, Categoria categoria) {
        this.palavra = palavra;
        this.dica = dica;
        this.categoria = categoria;
    }
    
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
    
    public Categoria getCategoria() {
    	return categoria;
    }

}
