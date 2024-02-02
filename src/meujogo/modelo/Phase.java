package meujogo.modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Phase extends JPanel implements ActionListener {
    private Image background;
    private Player player;
    private Timer timer;
    private List<Enemy> enemy;
    private boolean inGame;


    public Phase() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon reference = new ImageIcon("public/BG.png");
        background = reference.getImage();


        player = new Player();
        player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer( 20, this);
        timer.start();

        initialEnemys();
        inGame = true;
    }

    public void initialEnemys() {
        int coordinates [] = new int [40];
        enemy = new ArrayList<Enemy>();

        for (int i = 0; i < coordinates.length; i++) {
            int x = (int)(Math.random() * 8000 + 1024);
            int y = (int)(Math.random() * 764 +0);
            enemy.add(new Enemy(x, y));
        }
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        if (inGame == true) {


            graphics.drawImage(background, 0, 0, null);
            graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);

            List<Fire> fire = player.getFire();
            for (int i = 0; i < fire.size(); i++) {
                Fire m = fire.get(i);
                m.load();
                graphics.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }

            for (int o = 0; o < enemy.size(); o++) {
                Enemy in = enemy.get(o);
                in.load();
                graphics.drawImage(in.getImage(), in.getX(), in.getY(), this);
            }
        } else {

            ImageIcon endGame = new ImageIcon("public/youlose.png");
            graphics.drawImage(endGame.getImage(),0,0, null);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List<Fire> fire = player.getFire();
        for (int i = 0; i < fire.size(); i++) {
            Fire m = fire.get(i);
            if (m.isVisible()) {
                m.update();
            } else {
                fire.remove(i);
            }
        }

        for (int o = 0; o < enemy.size(); o++) {
            Enemy in = enemy.get(o);
            if (in.isVisible()) {
                in.update();
            } else {
             enemy.remove(o);
            }
        }

        checkColizion();
        repaint();
    }

    public void checkColizion() {
        Rectangle modelNave = player.getBounds();
        Rectangle modelEnemy;
        Rectangle modelfire;


        for (int i = 0; i < enemy.size(); i++) {
            Enemy tempEnemy = enemy.get(i);
            modelEnemy = tempEnemy.getBounds();

            if (modelNave.intersects(modelEnemy)) {
                player.setVisible(false);
                tempEnemy.setVisible(false);
                inGame = false;
            }
        }
        List<Fire> fire = player.getFire();
        for (int g = 0; g < fire.size(); g++) {
            Fire tempFire = fire.get(g);
            modelfire = tempFire.getBounds();
            for (int h = 0; h < enemy.size(); h++) {
                Enemy tempEnemy = enemy.get(h);
                modelEnemy = tempEnemy.getBounds();
                if (modelfire.intersects(modelEnemy)) {
                    tempEnemy.setVisible(false);
                    tempFire.setVisible(false);
                }
            }
        }
    }

    private class TecladoAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }

}
