package com.luis.forca;

public enum Categoria {
	SOCIAL("Social"), FILMES("Filmes"), SERIES_DE_TV("Séries de TV");

	private String categoria;
	private String destino;

	private Categoria(String categoria) {
		this.categoria = categoria;
		this.destino = Destino.getDestino(this);
	}

	public String get() {
		return categoria;
	}
	
	public String getDestino() {
		return destino;
	}
}
