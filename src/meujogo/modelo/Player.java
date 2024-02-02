package meujogo.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class Player {
    private int x,y;
    private int dx,dy;
    private Image image;
    private int height, width;
    private List <Fire> fire;
    private boolean visible;


    public Player() {
        this.x = 100;
        this.y = 100;
        visible = true;

        fire = new ArrayList<Fire>();
    }

    public void load() {
        ImageIcon reference = new ImageIcon("public/Ship_Main_Icon.png");
        image = reference.getImage();

        // Diminuir a escala da imagem pela metade
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);


    }

    public void update() {
        x += dx;
        y += dy;
    }





    public void sampleFire() {
        this.fire.add(new Fire(x + width, y + (height/2)));
    }


    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }


    public void keyPressed(KeyEvent key) {
        int code = key.getKeyCode();
        if (code == KeyEvent.VK_J) {
            sampleFire();
        }
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

    public List<Fire> getFire() {
        return fire;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

