package jogo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Loader simples para assets (pode ser usado para pngs únicos ou spritesheets).
 * Útil caso prefira uma entrada centralizada (não obrigatório).
 */
public class AssetLoader {

    public static BufferedImage load(String path) throws Exception {
        return ImageIO.read(new File(path));
    }

    public static BufferedImage[] loadSpriteSheet(String path, int frames) throws Exception {
        BufferedImage sheet = load(path);
        int frameWidth = sheet.getWidth() / frames;
        int frameHeight = sheet.getHeight();
        BufferedImage[] arr = new BufferedImage[frames];
        for (int i = 0; i < frames; i++) {
            arr[i] = sheet.getSubimage(i * frameWidth, 0, frameWidth, frameHeight);
        }
        return arr;
    }
}
