import meujogo.modelo.Phase;

import javax.swing.*;

public class Container extends JFrame {
    public Container() {
        add(new Phase());
        setTitle("Meu jogo");
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Container();
    }
}
