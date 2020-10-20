
package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage LoadImage(String path) 
    {
        try {
            // the way to load images in java
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1); // if the images dosn't loaded, we don't start the game
        }
        return null;
    }
}
