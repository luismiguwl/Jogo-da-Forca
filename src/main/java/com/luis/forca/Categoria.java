package com.luis.forca;

public enum Categoria {
	SOCIAL("Social"), FILMES("Filmes"), SERIES_DE_TV("Séries de TV");
	
	private static Categoria[] categorias = Categoria.values();

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

	public static Categoria solicitarCategoria() {
		System.out.println("==== CATEGORIA ====");
		exibirArrayComOpcoes();
		int numeroDaOpcao = Utils.solicitarUmaOpcao(categorias.length);
		return categorias[numeroDaOpcao - 1];
	}

	private static void exibirArrayComOpcoes() {
		for (int i = 0; i < categorias.length; i++) {
			System.out.println(String.format("%d. %s", (i + 1), categorias[i].get()));
		}
	}

}
