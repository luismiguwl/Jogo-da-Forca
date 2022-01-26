package com.luis.forca;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ForcaTest {

	Forca forca;
	
	@BeforeEach
	void setUp() {
		forca = new Forca("Pantera cor-de-rosa", "Personagem de desenho animado");	
	}
	
	@Test
	void deveRetornarArrayComPalavraSubstituidaPorUnderline() {
		char[] arrayEsperado = "_______ ___-__-____".toCharArray();
		forca.esconderPalavra();
		assertArrayEquals(arrayEsperado, forca.getPalavraEscondida());
	}
	
	@Test
	void deveRetornarTrueSeCaracterForLetra() {
		assertTrue(forca.ehLetra('a'));
	}
	
	@Test
	void deveRetornarFalseSeCaracterNaoForLetra() {
		assertFalse(forca.ehLetra('1'));
	}
	
	@Test
	void deveRetornarTrueSeCaracterForNumero() {
		assertTrue(forca.ehNumero('1'));
	}
	
	@Test
	void deveRetornarFalseSeCaracterNaoForNumero() {
		assertFalse(forca.ehNumero('a'));
	}
	
	@Test
	void deveRetornarTrueSeLetraJaFoiUsada() {
		char caracter = 'a';
		forca.getLetrasUsadas().add(caracter);
		assertTrue(forca.letraJaFoiUsada(caracter));
	}
	
	@Test
	void deveRetornarFalseSeLetraNaoFoiUsada() {
		assertFalse(forca.letraJaFoiUsada(Mockito.anyChar()));
	}
	
	@Test
	void deveRetornarTrueSeLetraExisteNaPalavra() {
		assertTrue(forca.letraExisteNaPalavra('a'));
	}
	
	@Test
	void deveRetornarFalseSeLetraNaoExisteNaPalavra() {
		assertFalse(forca.letraExisteNaPalavra('y'));
	}
	
	@Test
	void deveRetornarZeroSeQuantidadeDeErrosForIgualACinco() {
		forca = Mockito.mock(Forca.class);
		Mockito.when(forca.getErros()).thenReturn(5);
		assertEquals(forca.getChancesRestantes(), 0);
	}
	
	@Test
	void deveRetornarCincoSeJogoAindaNaoComecou() {
		assertEquals(forca.getChancesRestantes(), 5);
	}
	
	@Test
	void deveSubstituirLetraNaPalavraEscondida() {
		char letra = 'a';
		forca.substituirLetraNaPalavraEscondida(letra);
		assertArrayEquals("_a____a ___-__-___a".toCharArray(), forca.getPalavraEscondida());
	}

	@Test
	void deveRetornarTrueSePalavraEstiverCompleta() {
		char[] palavraPreenchida = forca.getPalavra().toCharArray();
		forca.setPalavraEscondida(palavraPreenchida);
		
		assertTrue(forca.palavraEstaCompleta());
	}
}
