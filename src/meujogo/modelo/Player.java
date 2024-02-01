package meujogo.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x,y;
    private int dx,dy;
    private Image image;
    private int height, widht;


    public Player() {
        this.x = 100;
        this.y = 100;
    }

    public void load() {
        ImageIcon reference = new ImageIcon("public/Ship_Main_Icon.png");
        image = reference.getImage();

        // Diminuir a escala da imagem pela metade
        int newWidth = image.getWidth(null) / 2;
        int newHeight = image.getHeight(null) / 2;

        image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        height = image.getHeight(null);
        widht = image.getWidth(null);
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent key) {
        int code = key.getKeyCode();
        if (code == KeyEvent.VK_W) {
            dy = -3;
        }
        if (code == KeyEvent.VK_S) {
            dy = 3;
        }
        if (code == KeyEvent.VK_D) {
            dx = 3;
        }
        if (code == KeyEvent.VK_A) {
            dx = -3;
        }
    }

    public void keyReleased(KeyEvent key) {
        int code = key.getKeyCode();
        if (code == KeyEvent.VK_W) {
            dy = 0;
        }
        if (code == KeyEvent.VK_S) {
            dy = 0;
        }
        if (code == KeyEvent.VK_D) {
            dx = 0;
        }
        if (code == KeyEvent.VK_A) {
            dx = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
