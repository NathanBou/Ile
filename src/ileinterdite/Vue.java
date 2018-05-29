package ileinterdite;

import java.awt.Dimension;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Vue {
        private final JFrame window ;

    public Vue(){

        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(1650, 950);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
    }
    public void afficher(){
        this.window.setVisible(true);
    }
}
   