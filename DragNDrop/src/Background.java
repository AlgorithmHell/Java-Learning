import javax.swing.*;
import java.awt.*;

/**
 * Created by Helga on 11/27/2017.
 */
public class Background extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(Application.class.getResource("background.png")).getImage();
        g.drawImage(image,0,0,Application.getWindowWidth(), Application.getWindowHeight(),null);
    }
}
