package meujogo.modelo;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {

    private Image image;
    private int x, y;
    private int width, height;
    private boolean visible;

    // private static final int LARGE = 1024;
    private static int SPEED = -4;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    public void load() {
        ImageIcon reference = new ImageIcon("public/Ship_2_1_BTN.png");
        image = reference.getImage();

        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public void update() {
        this.x += SPEED;
       // if (this.x > LARGE) {
            //visible = false;
        //}
    }


    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public static void setSPEED(int SPEED) {
        Enemy.SPEED = SPEED;
    }

    public Image getImage() {
        return image;
    }
}
