package jogo;

import javax.swing.*;

public class window extends JFrame {

    public window() {
        setTitle("Samurai Fight");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        add(new GamePanel());
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
