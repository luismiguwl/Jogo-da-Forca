package com.luis.forca;

public enum OpcoesDoMenu {
    JOGAR("Jogar"), SAIR("Sair");
    
    private String opcao;
    
    private OpcoesDoMenu(String opcao) {
        this.opcao = opcao;
    }
    
    public String getOpcao() {
        return opcao;
    }
}
