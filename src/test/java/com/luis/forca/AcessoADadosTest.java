package com.luis.forca;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AcessoADadosTest {
	
	AcessoADados acessoADados;
	
	@Test
	void deveRetornarUmArrayNaoNuloSeDestinoExistir() {
		acessoADados = new AcessoADados(Destino.get());
		assertNotNull(acessoADados.obterPalavrasEDicas());
	}
	
	@Test
	void deveRetornarNuloSeEnderecoNaoExistir() {
		acessoADados = new AcessoADados("string qualquer");
		assertThrows(NullPointerException.class, () -> {
			acessoADados.obterPalavrasEDicas();
		});
	}
}
