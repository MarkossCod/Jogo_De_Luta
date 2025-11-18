package jogo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {

    public int x, y;

    private BufferedImage[] frames;
    private int index = 0;
    private int delay = 8;
    private int tick = 0;

    public Sprite(int x, int y, BufferedImage[] frames) {
        this.x = x;
        this.y = y;
        this.frames = frames;
    }

    public void setFrames(BufferedImage[] newFrames) {
        this.frames = newFrames;
        this.index = 0;
    }

    public void update() {
        tick++;
        if (tick > delay) {
            tick = 0;
            index++;
            if (index >= frames.length) index = 0;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(frames[index], x, y, null);
    }
}
