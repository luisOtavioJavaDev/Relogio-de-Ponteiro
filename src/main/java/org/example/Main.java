package org.example;

import org.example.Relogio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Meu Relógio Java");
        Relogio meuRelogio = new Relogio();

        janela.add(meuRelogio); // Coloca o seu painel dentro da janela
        janela.setSize(800, 800); // Tamanho da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa no X
        janela.setVisible(true); // Faz a mágica aparecer!
    }
}