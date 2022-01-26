package com.luis.forca;

import static com.luis.forca.Categoria.*;

public abstract class Destino {
	private static final String DESTINO_FILMES = "dados/palavras-da-forca-categoria-filmes.csv";
	private static final String DESTINO_SERIES_DE_TV = "dados/palavras-da-forca-categoria-series-de-tv.csv";
	private static final String DESTINO_SOCIAL = "dados/palavras-da-forca-categoria-social.csv";
	
	public static String getDestino(Categoria categoria) {
		if (categoria.equals(FILMES)) {
			return DESTINO_FILMES;
		}
		
		if (categoria.equals(SERIES_DE_TV)) {
			return DESTINO_SERIES_DE_TV;
		}
		
		if (categoria.equals(SOCIAL)) {
			return DESTINO_SOCIAL;
		}
		
		return null;
	}
}
