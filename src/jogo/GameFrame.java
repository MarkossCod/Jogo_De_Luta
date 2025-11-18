package jogo;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Jogo de Luta 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
