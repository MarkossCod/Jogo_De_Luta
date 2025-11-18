package jogo;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Animation {

    public static BufferedImage[] loadFrames(
            String path,
            int totalFrames,
            int frameWidth,
            int frameHeight
    ) {
        try {
            BufferedImage sheet = ImageIO.read(new File(path));

            BufferedImage[] frames = new BufferedImage[totalFrames];

            for (int i = 0; i < totalFrames; i++) {
                frames[i] = sheet.getSubimage(
                        i * frameWidth,
                        0,
                        frameWidth,
                        frameHeight
                );
            }

            return frames;

        } catch (Exception e) {
            System.out.println("Erro ao carregar frames: " + path);
            return null;
        }
    }
}
