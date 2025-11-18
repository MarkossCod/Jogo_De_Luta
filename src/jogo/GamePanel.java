package jogo;

import personagens.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer timer = new Timer(16, this);

    private BufferedImage bg;

    private Sprite p1Sprite, p2Sprite;

    private Lutador p1 = new Lutador_Medio("Samurai Azul", 100, 12);
    private Lutador p2 = new Lutador_Pesado("Samurai Armadura", 120, 14);

    // ESTADOS
    private boolean p1_attacking = false;
    private boolean p2_attacking = false;

    // FRAMES
    private BufferedImage[] p1_idle, p1_attack, p1_hit;
    private BufferedImage[] p2_idle, p2_attack, p2_hit;

    public GamePanel() {

        setPreferredSize(new Dimension(1280, 720));
        setFocusable(true);
        addKeyListener(this);

        loadAssets();

        p1Sprite = new Sprite(300, 450, p1_idle);
        p2Sprite = new Sprite(900, 450, p2_idle);

        timer.start();
    }

    // ==========================================================
    // CARREGAR ASSETS + FRAMES ANIMADOS
    // ==========================================================
    private void loadAssets() {
        try {
            bg = ImageIO.read(new File("assets/bg.png"));

            p1_idle   = Animation.loadFrames("assets/p1_idle.png",   4, 120, 120);
            p1_attack = Animation.loadFrames("assets/p1_attack.png", 4, 120, 120);
            p1_hit    = Animation.loadFrames("assets/p1_hit.png",    2, 120, 120);

            p2_idle   = Animation.loadFrames("assets/p2_idle.png",   4, 120, 120);
            p2_attack = Animation.loadFrames("assets/p2_attack.png", 4, 120, 120);
            p2_hit    = Animation.loadFrames("assets/p2_hit.png",    2, 120, 120);

        } catch (Exception e) {
            System.out.println("Erro ao carregar assets: " + e);
        }
    }

    // ==========================================================
    // UPDATE — animação + combate
    // ==========================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        updateGame();
        repaint();
    }

    private void updateGame() {

        p1Sprite.update();
        p2Sprite.update();

        // ========= ATAQUE DO PLAYER 1 ============
        if (p1_attacking) {
            p1Sprite.setFrames(p1_attack);

            Rectangle box1 = new Rectangle(p1Sprite.x, p1Sprite.y, 120, 120);
            Rectangle box2 = new Rectangle(p2Sprite.x, p2Sprite.y, 120, 120);

            if (box1.intersects(box2)) {
                p1.atacar(p2);
                p2Sprite.setFrames(p2_hit);
                p2Sprite.x += 20;
            }

        } else {
            p1Sprite.setFrames(p1_idle);
        }

        // ========= ATAQUE DO PLAYER 2 ============
        if (p2_attacking) {
            p2Sprite.setFrames(p2_attack);

            Rectangle box2 = new Rectangle(p2Sprite.x, p2Sprite.y, 120, 120);
            Rectangle box1 = new Rectangle(p1Sprite.x, p1Sprite.y, 120, 120);

            if (box2.intersects(box1)) {
                p2.atacar(p1);
                p1Sprite.setFrames(p1_hit);
                p1Sprite.x -= 20;
            }

        } else {
            p2Sprite.setFrames(p2_idle);
        }

    }

    // ==========================================================
    // RENDER
    // ==========================================================
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bg, 0, 0, null);

        drawHUD(g);

        p1Sprite.draw(g);
        p2Sprite.draw(g);
    }

    private void drawHUD(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));

        g.drawString("P1 HP: " + p1.getVida(), 50, 50);
        g.drawString("P2 HP: " + p2.getVida(), 1000, 50);

        g.setColor(Color.RED);

        g.fillRect(50, 70, p1.getVida() * 2, 20);
        g.fillRect(1000, 70, p2.getVida() * 2, 20);
    }

    // ==========================================================
    // CONTROLES
    // ==========================================================
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            // PLAYER 1
            case KeyEvent.VK_J:
                p1_attacking = true;
                break;

            // PLAYER 2
            case KeyEvent.VK_NUMPAD1:
                p2_attacking = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_J:
                p1_attacking = false;
                break;

            case KeyEvent.VK_NUMPAD1:
                p2_attacking = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
