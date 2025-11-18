package jogo;

import javax.swing.*;
import java.awt.*;

public class GameStart extends JFrame {

    public GameStart() {
        setTitle("Escolha o modo de jogo");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JButton pvp = new JButton("2 Jogadores");
        JButton pvc = new JButton("1 Jogador vs CPU");

        pvp.addActionListener(e -> {
            GameMode.twoPlayers = true;
            abrirJogo();
        });

        pvc.addActionListener(e -> {
            GameMode.twoPlayers = false;
            abrirJogo();
        });

        add(pvp);
        add(pvc);

        setVisible(true);
    }

    private void abrirJogo() {
        new window();
        dispose();
    }

    public static void main(String[] args) {
        new GameStart();
    }

}
