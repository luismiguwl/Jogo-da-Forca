package com.luis.forca;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

	@Test
	void deveRetornarUmNumeroInteiroEntreZeroENove() {
		Assertions.assertThat(Utils.obterNumeroAleatorio(10)).isBetween(0, 9);
	}

}
