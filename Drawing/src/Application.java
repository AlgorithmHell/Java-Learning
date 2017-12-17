import javafx.util.Pair;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Helga on 11/25/2017.
 */
public class Application extends JFrame {

    private static final int BOUND_X = 350;

    private static final int BOUND_Y = 50;

    public static final int HEIGHT = 600;

    public static final int WIDTH = 600;

    private static final String TITLE = "Drawing";

    private JScrollPane jScrollPane;

    private JPanel jPanel;

    private JButton redButton;

    private JButton yellowButton;

    private JButton greenButton;

    private JButton chooseImage;

    private JButton saveImage;

    private PaintArea paintPanel;

    private BufferedImage bufferedImage;

    private ArrayList<Point> coordinates;

    private ArrayList< Pair<ArrayList<Point> , Color> > lines;

    private class PaintArea extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if(bufferedImage != null) {
                g.drawImage(bufferedImage,0,0, null);
            }
            for ( Pair <ArrayList<Point>, Color >   line  : lines ) {
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

    }

    public Application(){

        super(TITLE);
        setWindowParams();
        initButtons();
        initScrollPane();
        initListeners();
        coordinates = new ArrayList<>();
        lines = new ArrayList<>();
    }

    private void setWindowParams() {

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("HS.jpg");
        this.setIconImage(imageIcon.getImage());
        this.setBounds(BOUND_X, BOUND_Y, WIDTH, HEIGHT);
        this.setResizable(false);

    }

    private void initScrollPane(){
        paintPanel = new PaintArea();
        bufferedImage = null;

        paintPanel.setBackground(Color.PINK);
        jScrollPane = new JScrollPane(paintPanel);
        jScrollPane.setPreferredSize(new Dimension(getWidth(),getHeight() * 4));
        paintPanel.setPreferredSize(new Dimension(getWidth(),getHeight() * 4));
        jScrollPane.setBounds(this.getX(),this.getY(),this.getWidth(),this.getHeight() * 4);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setWheelScrollingEnabled(true);
        jScrollPane.setBackground(Color.PINK);
        this.add(jScrollPane, BorderLayout.CENTER);
    }

    private void initButtons() {

        redButton = new JButton("Red");
        yellowButton = new JButton("Yellow");
        greenButton = new JButton("Green");
        chooseImage = new JButton("Open");
        saveImage = new JButton("Save");


        jPanel = new JPanel(new GridLayout(1 , 5));
        this.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(redButton);
        jPanel.add(yellowButton);
        jPanel.add(greenButton);
        jPanel.add(chooseImage);
        jPanel.add(saveImage);


        redButton.setEnabled(false);
    }

    private void initListeners() {

        saveImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\Note\\Desktop\\Drawing");

                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    BufferedImage bufferedImage = new BufferedImage(paintPanel.getWidth(),paintPanel.getHeight(),BufferedImage.TYPE_INT_RGB);
                    paintPanel.paint(bufferedImage.getGraphics());
                    try {
                        ImageIO.write(bufferedImage,"PNG",file);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(Application.this, "Error saving image",
                                "Error" , JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        chooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\Note\\Desktop\\Drawing");

                if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        bufferedImage = ImageIO.read(file);
                        lines.clear();
                        paintPanel.repaint();

                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(Application.this, "Error choosing image",
                                "Error" , JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDisableStatus("Red");
            }
        });

        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDisableStatus("Yellow");
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDisableStatus("Green");
            }
        });

        paintPanel.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
               if(paintPanel.getMousePosition() != null) {
                   coordinates.add(paintPanel.getMousePosition());
                   paintPanel.repaint();
               } else {
                   lines.add(new Pair<>(new ArrayList<>(coordinates), getSelectedColor()));
                   coordinates.clear();
               }
            }
        });

        paintPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(paintPanel.getMousePosition() != null) {
                    coordinates.add(paintPanel.getMousePosition());
                }
                paintPanel.repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(paintPanel.getMousePosition() != null) {
                    coordinates.add(paintPanel.getMousePosition());
                }
                lines.add(new Pair<>(new ArrayList<>(coordinates), getSelectedColor()));
                paintPanel.repaint();
                coordinates.clear();
            }
        });

    }

    public void setDisableStatus(String disabled) {

        redButton.setEnabled(true);
        greenButton.setEnabled(true);
        yellowButton.setEnabled(true);

        if(redButton.getText().equals(disabled)) {
            redButton.setEnabled(false);
        } else {
            if(yellowButton.getText().equals(disabled)) {
                yellowButton.setEnabled(false);
            } else {
                greenButton.setEnabled(false);
            }
        }
    }

    public  Color getSelectedColor() {
        if(! redButton.isEnabled()) {
            return Color.RED;
        } else {
            if(! yellowButton.isEnabled()) {
                return  Color.YELLOW;
            } else {
                return Color.GREEN;
            }
        }
    }

    public static void main(String... args) {

        Application application = new Application();
        application.setVisible(true);
    }
}
