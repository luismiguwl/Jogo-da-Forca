package com.luis.forca;

import static com.luis.forca.Utils.*;

public class Menu implements AcoesDoMenu {

	private OpcoesDoMenu[] opcoes = OpcoesDoMenu.values();
	private OpcoesDoMenu opcaoAtual;

	public Menu() {
		System.out.println("==== MENU ====");
	}

	@Override
	public void exibirOpcoes() {
		for (int i = 0; i < opcoes.length; i++) {
			System.out.println(String.format("%d. %s", (i + 1), opcoes[i].getOpcao()));
		}
	}

	@Override
	public void solicitarOpcaoAtual() {
		int numeroDaOpcao = solicitarUmaOpcao(opcoes.length);
		setOpcaoAtual(numeroDaOpcao);
	}

	public OpcoesDoMenu getOpcaoAtual() {
		return opcaoAtual;
	}

	public void setOpcaoAtual(int numero) {
		this.opcaoAtual = opcoes[numero - 1];
	}

	@Override
	public void executarOpcao() {
		if (getOpcaoAtual().equals(OpcoesDoMenu.SAIR)) {
			System.out.println("Volte sempre!");
			encerrarSistema();
		}
	}

}
