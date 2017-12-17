
import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Helga on 11/25/2017.
 */
public class Application extends JFrame {

    private static final int HEIGHT = 400;

    private static final int WIDTH = 800;

    private static final int BOUND_X = 350;

    private static final int BOUND_Y = 200;

    private static final int INDENT = 100;

    private static final int FACTOR = 10;

    private static final int BUTTON_HEIGHT = 30;

    private static final int MINIMUM_WIDTH = 80;

    private static int buttonWidth;

    private static final String TITLE = "Drag-and-Drop";

    private  String buttonText;

    private JPanel jPanel;

    private JLabel jLabel;

    private JButton jButton;

    private boolean isClicked;

    public Application(){

        super(TITLE);
        setLayout(new BorderLayout());
        initLabel();
        initButton();
        initPanel();
        setWindowParams();
        initListeners();
    }


    public static int getWindowHeight() {
        return HEIGHT;
    }

    public static int getWindowWidth() {
        return WIDTH;
    }

    private void initButton() {

        buttonText = "Drag-and-Drop";
        buttonWidth = buttonText.length() * FACTOR;
        jButton = new JButton(buttonText);
        resizeButton(buttonWidth);
        jButton.setBounds((getWindowWidth() - buttonWidth)/2 , (getWindowHeight() - BUTTON_HEIGHT) / 3 ,buttonWidth, BUTTON_HEIGHT);
    }

    private void initLabel() {

        jLabel = new JLabel();
        jLabel.setBounds( 0, HEIGHT - INDENT, 2* INDENT, INDENT);
        this.add(jLabel, BorderLayout.SOUTH);
    }

    private void setWindowParams() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(BOUND_X, BOUND_Y, WIDTH, HEIGHT);
        ImageIcon imageIcon = new ImageIcon("HS.jpg");
        this.setIconImage(imageIcon.getImage());
        this.add(jPanel);
        jPanel.setBackground(Color.WHITE);
        isClicked = false;

    }

    private void resizeButton(int buttonWidth) {

        if(buttonWidth >= MINIMUM_WIDTH)
       this.buttonWidth = buttonWidth;
    }

    private void refreshButtonLayout() {
        Rectangle rectangle = jButton.getBounds();
        jButton.setBounds( (int) rectangle.getX(), (int) rectangle.getY(), buttonWidth, (int) rectangle.getHeight());
    }

    private void refreshButtonLayout(Point e) {
        if(e != null)
        jButton.setBounds((int)e.getX() - buttonWidth/2 , (int)e.getY() - BUTTON_HEIGHT, buttonWidth, BUTTON_HEIGHT);

    }

    private void refreshButtonLayout(MouseEvent e) {
        jButton.setBounds((getWindowWidth() - buttonWidth) / 2, (getWindowHeight()) / 2 - BUTTON_HEIGHT, buttonWidth, BUTTON_HEIGHT);
    }

    private void initPanel(){

        jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.add(jButton);
        this.add(jPanel, BorderLayout.CENTER);
    }

    private void setLabelText() {
        if(getMousePosition() != null)
        jLabel.setText("X : "+getMousePosition().getX()+" Y : "+getMousePosition().getY());
    }

    private void initListeners() {

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component component = e.getComponent();
                Rectangle rectangle = component.getBounds();
                jButton.setBounds((int)(rectangle.getWidth() - buttonWidth)/2, (int) (rectangle.getHeight() - BUTTON_HEIGHT)/2,buttonWidth,BUTTON_HEIGHT);
            }
        });

        jPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                setLabelText();
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                setLabelText();
                if(isClicked) refreshButtonLayout(e);
            }

        });
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setLabelText();
                refreshButtonLayout(getMousePosition());
            }

        });

        jButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLabelText();
                if(e.isControlDown()) refreshButtonLayout(getMousePosition());
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                setLabelText();
            }
        });

        jButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    if(jButton.getText().length() != 0) {
                        buttonText = jButton.getText().substring(0, jButton.getText().length() - 1);
                        jButton.setText(buttonText);
                    }
                } else {
                    if(buttonWidth <= WIDTH) {
                        buttonText+=e.getKeyChar();
                        jButton.setText(buttonText);
                    }

                }
                resizeButton(buttonText.length() * FACTOR);
                refreshButtonLayout();
                setLabelText();
            }
        });

    }

    public static void main(String... args) {

        Application application = new Application();
        application.setVisible(true);
    }
}
