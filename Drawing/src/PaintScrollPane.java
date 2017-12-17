import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PaintScrollPane extends JScrollPane {

  /*  @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for ( Pair<ArrayList<Point>, Color > line  : lines ) {
            g.setColor(line.getValue());
            for(int i = 0 ; i < line.getKey().size() - 1 ; i++){
                g.drawLine((int) line.getKey().get(i).getX(),(int) line.getKey().get(i).getY(),
                        (int)line.getKey().get(i+1).getX(),(int)line.getKey().get(i+1).getY());
            }
        }
        g.setColor(getSelectedColor());
        for ( int i = 0 ; i < coordinates.size() - 1; i++) {
            g.drawLine((int) coordinates.get(i).getX(), (int) coordinates.get(i).getY(),
                    (int) coordinates.get(i+1).getX() , (int) coordinates.get(i+1).getY());
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bufferedImage,0,0, null);
    }*/
}