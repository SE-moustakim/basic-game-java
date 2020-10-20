
package gfx;

import java.awt.image.BufferedImage;


public class Assets {
    
    public static final int width = 32, height = 32;
    //public static final int width = 60, height = 65;
    public static BufferedImage player, dirt, grass, rock, tree;
    public static BufferedImage[] player_down, player_up, player_left, player_right; 
    
public static void init()
{
    SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/sheet2.png"));
    //SpriteSheet sheetAnimation = new SpriteSheet(ImageLoader.LoadImage("/textures/sheet3.png"));
    
    player_down = new BufferedImage[2];
    player_up = new BufferedImage[2];
    player_left = new BufferedImage[2];
    player_right = new BufferedImage[2];
    
    player_down[0] = sheet.crop(width * 4, 0, width, height);
    player_down[1] = sheet.crop(width * 5, 0, width, height);
    
    player_up[0] = sheet.crop(width * 6, 0, width, height);
    player_up[1] = sheet.crop(width * 7, 0, width, height);
    
    player_right[0] = sheet.crop(width * 4, height, width, height);
    player_right[1] = sheet.crop(width * 5, height, width, height);
    
    player_left[0] = sheet.crop(width * 6, height, width, height);
    player_left[1] = sheet.crop(width * 7, height, width, height);
    
    //player = sheet.crop(width * 4, 0, width, height);
    
    /*
    player_down = new BufferedImage[8];
    player_up = new BufferedImage[8];
    player_left = new BufferedImage[8];
    player_right = new BufferedImage[8];
    
    
    player_down[0] = sheetAnimation.crop(width * 0, height * 2, width, height);
    player_down[1] = sheetAnimation.crop(width * 1, height * 2, width, height);
    player_down[2] = sheetAnimation.crop(width * 2, height * 2, width, height);
    player_down[3] = sheetAnimation.crop(width * 3, height * 2, width, height);
    player_down[4] = sheetAnimation.crop(width * 4, height * 2, width, height);
    player_down[5] = sheetAnimation.crop(width * 5, height * 2, width, height);
    player_down[6] = sheetAnimation.crop(width * 6, height * 2, width, height);
    player_down[7] = sheetAnimation.crop(width * 7, height * 2, width, height);
    
    player_up[0] = sheetAnimation.crop(width * 0, 0, width, height);
    player_up[1] = sheetAnimation.crop(width * 1, 0, width, height);
    player_up[2] = sheetAnimation.crop(width * 2, 0, width, height);
    player_up[3] = sheetAnimation.crop(width * 3, 0, width, height);
    player_up[4] = sheetAnimation.crop(width * 4, 0, width, height);
    player_up[5] = sheetAnimation.crop(width * 5, 0, width, height);
    player_up[6] = sheetAnimation.crop(width * 6, 0, width, height);
    player_up[7] = sheetAnimation.crop(width * 7, 0, width, height);
    
    player_right[0] = sheetAnimation.crop(width * 0, height * 3, width, height);
    player_right[1] = sheetAnimation.crop(width * 1, height * 3, width, height);
    player_right[2] = sheetAnimation.crop(width * 2, height * 3, width, height);
    player_right[3] = sheetAnimation.crop(width * 3, height * 3, width, height);
    player_right[4] = sheetAnimation.crop(width * 4, height * 3, width, height);
    player_right[5] = sheetAnimation.crop(width * 5, height * 3, width, height);
    player_right[6] = sheetAnimation.crop(width * 6, height * 3, width, height);
    player_right[7] = sheetAnimation.crop(width * 7, height * 3, width, height);
    
    player_left[0] = sheetAnimation.crop(width * 0, height, width, height);
    player_left[1] = sheetAnimation.crop(width * 1, height, width, height);
    player_left[2] = sheetAnimation.crop(width * 2, height, width, height);
    player_left[3] = sheetAnimation.crop(width * 3, height, width, height);
    player_left[4] = sheetAnimation.crop(width * 4, height, width, height);
    player_left[5] = sheetAnimation.crop(width * 5, height, width, height);
    player_left[6] = sheetAnimation.crop(width * 6, height, width, height);
    player_left[7] = sheetAnimation.crop(width * 7, height, width, height);
    */
    dirt = sheet.crop(width, 0, width, height);
    grass = sheet.crop(width * 2, 0, width, height);
    rock = sheet.crop(width * 3, 0, width, height);
    tree = sheet.crop(width * 0, 0, width, height);
    
}
}
