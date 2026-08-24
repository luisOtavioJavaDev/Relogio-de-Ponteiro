package org.example;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class Relogio extends JPanel {
    private Color corDoPonteiro = Color.BLACK;

    public Relogio() {
      int intervalo = 1000;
      Timer timer = new Timer(intervalo, e -> repaint());
      timer.start();
        JButton botaoCor = new JButton("Escolher Cor do Relógio");
        botaoCor.addActionListener(e -> abrirPainelDeCor());
        this.add(botaoCor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g); // limpa o painel
        LocalTime localTime = LocalTime.now();

        double anguloSegundos = localTime.getSecond() * 6;
        double anguloMinutos = localTime.getMinute() * 6;
        double anguloHoras =( localTime.getHour() * 30) + (localTime.getMinute() * 0.5);
        int xCentro = getWidth()/2;
        int yCentro = getHeight()/2;
        int tamanhoRelogio = (int) (getHeight() - getHeight()*0.1);
        int espessuraRelogio = 5;
        int tamanhoPonteiroHoras = (int) ((tamanhoRelogio - tamanhoRelogio*0.5)/2);;
        int tamanhoPonteiroMinutosSegundos = (int) ((tamanhoRelogio - tamanhoRelogio*0.1)/2);
        int espessuraPonteiroHorasMinutos = 5;
        int espessuraPonteiroSegundos = 2;

         g.setColor(corDoPonteiro);
         g2d.setStroke(new BasicStroke(espessuraRelogio));
         g.drawOval(xCentro - tamanhoRelogio/2,yCentro - tamanhoRelogio/2,tamanhoRelogio,tamanhoRelogio);
        for (int i = 1; i <= 12; i++) {
            double anguloEmRadianosNumeros = Math.toRadians((i * 30) - 90);
            int xDaPonta = (int) (xCentro + (tamanhoRelogio / 2 * 0.95 * Math.cos(anguloEmRadianosNumeros)));
            int yDaPonta = (int) (yCentro + (tamanhoRelogio / 2 * 0.95 * Math.sin(anguloEmRadianosNumeros)));
            g.drawString(String.valueOf(i), xDaPonta, yDaPonta);
        }

        double anguloEmRadianosSegundos = Math.toRadians(anguloSegundos - 90);
        int xPontaSegundos = (int) (xCentro + (tamanhoPonteiroMinutosSegundos * Math.cos(anguloEmRadianosSegundos)));
        int yPontaSegundos = (int) (yCentro + (tamanhoPonteiroMinutosSegundos * Math.sin(anguloEmRadianosSegundos)));
        g2d.setStroke(new BasicStroke(espessuraPonteiroSegundos));
        g.drawLine(xCentro, yCentro, xPontaSegundos, yPontaSegundos);

        double anguloEmRadianosMinutos = Math.toRadians(anguloMinutos - 90);
        int xPontaMinutos= (int) (xCentro + (tamanhoPonteiroMinutosSegundos * Math.cos(anguloEmRadianosMinutos)));
        int yPontaMinutos = (int) (yCentro + (tamanhoPonteiroMinutosSegundos * Math.sin(anguloEmRadianosMinutos)));
        g2d.setStroke(new BasicStroke(espessuraPonteiroHorasMinutos));
        g.drawLine(xCentro, yCentro, xPontaMinutos, yPontaMinutos);

        double anguloEmRadianosHoras = Math.toRadians(anguloHoras - 90);
        int xPontaHoras = (int) (xCentro + (tamanhoPonteiroHoras * Math.cos(anguloEmRadianosHoras)));
        int yPontaHoras = (int) (yCentro + (tamanhoPonteiroHoras * Math.sin(anguloEmRadianosHoras)));
        g2d.setStroke(new BasicStroke(espessuraPonteiroHorasMinutos));
        g.drawLine(xCentro, yCentro, xPontaHoras, yPontaHoras);


    }

    public void abrirPainelDeCor() {
        Color novaCor = JColorChooser.showDialog(this, "Escolha a cor do ponteiro", corDoPonteiro);
        if (novaCor != null) {
            corDoPonteiro = novaCor;
        }
    }
}