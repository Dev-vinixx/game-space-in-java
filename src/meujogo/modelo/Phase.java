package meujogo.modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Phase extends JPanel implements ActionListener {
    private Image background;
    private Player player;
    private Timer timer;



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
    }
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(background, 0, 0, null);
        graphics.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
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
