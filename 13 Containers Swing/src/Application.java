import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Helga on 11/25/2017.
 */
public class Application extends JFrame {

    private static final int BOUND_X = 350;

    private static final int BOUND_Y = 50;

    private static final int HEIGHT = 600;

    private static final int WIDTH = 600;

    private static final String TITLE = "Container";

    private JTextField leftField;

    private JTextField rightField;

    private JTextField nameField;

    private JTextField priceField;

    private JTextField leftRange;

    private JTextField rightRange;

    private JButton submit;

    private JButton findToys;

    private JButton openFile;

    private JButton saveFile;

    private boolean dataExists;

    private JTextPane textPane;

    private Toys toys;


    public Application(){

        super(TITLE);
        setWindowParams();
        initWindow();
        initListeners();
    }

    private void setWindowParams() {

        this.setLayout(new GridLayout(1,2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("HS.jpg");
        this.setIconImage(imageIcon.getImage());
        this.setBounds(BOUND_X, BOUND_Y, WIDTH, HEIGHT);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        dataExists = false;
        toys = new Toys();

    }

    private void initWindow(){

        textPane = new JTextPane();
        textPane.setEditable(false);
        this.add(textPane);
        JPanel jPanel = new JPanel(new GridLayout(6,2));
        JPanel bufPanel = new JPanel(new GridLayout(2,1));
        bufPanel.add(jPanel);
        this.add(bufPanel);
        JLabel staticLeft = new JLabel("Left edge");
        staticLeft.setHorizontalAlignment(JTextField.CENTER);
        JLabel staticRight = new JLabel("Right edge");
        staticRight.setHorizontalAlignment(JTextField.CENTER);

        leftField = new JTextField();
        leftField.setHorizontalAlignment(JTextField.CENTER);

        rightField = new JTextField();
        rightField.setHorizontalAlignment(JTextField.CENTER);

        submit = new JButton("Create Toy");
        submit.setHorizontalAlignment(JButton.CENTER);
        submit.setVerticalAlignment(JButton.CENTER);

        findToys = new JButton("Find ");
        findToys.setHorizontalAlignment(JButton.CENTER);
        findToys.setVerticalAlignment(JButton.CENTER);

        openFile = new JButton(new ImageIcon("open.jpg"));
        saveFile = new JButton(new ImageIcon("save.jpg"));

        JTextField staticName = new JTextField("Name");
        staticName.setHorizontalAlignment(JTextField.CENTER);
        staticName.setEditable(false);
        JTextField staticPrice = new JTextField("Price");
        staticPrice.setHorizontalAlignment(JTextField.CENTER);
        staticPrice.setEditable(false);

        nameField = new JTextField();
        nameField.setHorizontalAlignment(JTextField.CENTER);
        priceField = new JTextField();
        priceField.setHorizontalAlignment(JTextField.CENTER);

        leftRange = new JTextField();
        leftRange.setHorizontalAlignment(JTextField.CENTER);
        rightRange = new JTextField();
        rightRange.setHorizontalAlignment(JTextField.CENTER);


        jPanel.add(staticName);
        jPanel.add(nameField);
        jPanel.add(staticPrice);
        jPanel.add(priceField);
        jPanel.add(staticLeft);
        jPanel.add(leftField);
        jPanel.add(staticRight);
        jPanel.add(rightField);
        jPanel.add(submit);
        JPanel jPanel1 = new JPanel(new GridLayout(1,3));
        jPanel.add(jPanel1);
        jPanel1.add(openFile);
        jPanel1.add(new JPanel());        ;
        jPanel1.add(saveFile);

        JPanel jPanel2 = new JPanel(new GridLayout(1,2));
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel.add(jPanel2);
        jPanel.add(jPanel3);
        jPanel2.add(findToys);
        JTextField jTextField = new JTextField("Range : [");
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jTextField.setEditable(false);
        jPanel2.add(jTextField);
        JTextField jTextField1 = new JTextField("   ]");
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setEditable(false);
        jPanel3.add(jTextField1,BorderLayout.EAST);
        JPanel jPanel4 = new JPanel(new GridLayout(1,2));
        jPanel3.add(jPanel4,BorderLayout.CENTER);
        jPanel4.add(leftRange);
        jPanel4.add(rightRange);


    }

    private void initListeners() {

        findToys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isValidForSearching()) {
                   textPane.setText(toys.getEligibleToys(Integer.parseInt(leftRange.getText()),
                           Integer.parseInt(rightRange.getText())).toString());
                }
            }
        });

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\Note\\Desktop\\13 Containers Swing");
                if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        toys = new Toys(file);
                        dataExists = true;
                        textPane.setText(toys.toString());

                    }
                    catch (NumberFormatException  | InvalidFileInfoException
                            | IllegalParameterException |ParserConfigurationException |
                            SAXException | IOException e1) {
                        dataExists = false;
                        JOptionPane.showMessageDialog(Application.this, e1.getMessage(),
                                "Error Reading from file" , JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser("C:\\Users\\Note\\Desktop\\13 Containers Swing");

                if (fc.showSaveDialog(fc) == JFileChooser.CANCEL_OPTION) {
                    return;
                }
                File file = fc.getSelectedFile();
                String filePath = file.getPath();
                try {
                    FileWriter fw = new FileWriter(filePath + ".xml");
                    fw.write(toys.toXMLString());
                    fw.close();

                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(Application.this, e1.getMessage(),
                            "Error Reading from file" , JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(isReadyForCreation()){
                   dataExists = true;
                   try {
                       toys.add(new Toy(nameField.getText(),Integer.parseInt(priceField.getText()),
                               Integer.parseInt(leftField.getText()),Integer.parseInt(rightField.getText())));
                       textPane.setText(toys.toString());
                   }catch (IllegalParameterException e1) {
                       JOptionPane.showMessageDialog(Application.this, e1.getMessage(),
                               "Error" , JOptionPane.ERROR_MESSAGE);
                   }

                }
            }
        });
    }

    private boolean isValidForSearching() {
        return edgeValidation(leftRange)&&edgeValidation(rightRange)&&dataExists;
    }

    private boolean isReadyForCreation() {
        return edgeValidation(leftField)&&edgeValidation(rightField)&&nameValidation()&&priceValidation();
    }

    private boolean nameValidation(){
        if(!isAlphabeticOrNumeric(nameField.getText()) || isEmptyInputString(nameField.getText())) {
            return false;
        }
        return true;
    }

    private boolean priceValidation(){
        if(!isNumber(priceField.getText()) || isEmptyInputString(priceField.getText())) {
            return false;
        } else{
            if(Integer.parseInt(priceField.getText()) <= 0) {
                return false;
            }
        }
        return true;
    }

    private boolean edgeValidation(JTextField textField){
        if(!isNumber(textField.getText()) || isEmptyInputString(textField.getText())) {
            return false;
        } else{
            if(Integer.parseInt(textField.getText()) <= 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphabeticOrNumeric (String string){

        for(int i = 0 ; i < string.length(); i++){
            if(!Character.isAlphabetic(string.charAt(i))&&!Character.isDigit(string.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean isNumber(String string){
        for (int i = 0; i< string.length(); i++){
            if(!Character.isDigit(string.charAt(i))){
                return  false;
            }
        }
        return true;
    }

    private boolean isEmptyInputString(String string){
        if(string.compareTo("")==0)
            return true;
        return false;
    }

    public static void main(String... args) {

        Application application = new Application();
        application.setVisible(true);
    }
}
