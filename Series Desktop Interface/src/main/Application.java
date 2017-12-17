package main;

import series.Exponential;
import series.Linear;
import series.Series;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Helga on 11/13/2017.
 */

public class Application extends JFrame implements ActionListener {

    private static final  int X_FRAME =350;
    private static final  int Y_FRAME =200;
    private static final  int WIDTH_FRAME =600;
    private static final  int HEIGHT_FRAME =300;
    private static final String TITLE ="Series";

    private boolean isLinear;
    private int first;
    private int size;
    private int delimeter;
    private String fileName;
    private String textDynamicStatus;


    private static final String TEXT_LINEAR = "Linear";
    private static final String TEXT_EXPONENTIAL = "Exponential";
    private static final String ENTER_FIRST_ELEMENT = "First Element : ex. 1 ";
    private static final String ENTER_DELIMETER = "Delimeter : ex 5 ";
    private static final String CHOOSE_TYPE_OF_A_SERIES = "Choose type of a Series : ";
    private static final String ENTER_SIZE = "Amount of First n : ex. 20";
    private static final String ENTER_FILE_FOR_SAVING = "Filename  : ex. Data";
    private static final String TEXT_SUBMIT_CREATION = "Submit Creation";
    private static final String TEXT_RESET_FIELDS = "Reset";
    private static final String TEXT_STATUS = "Status : ";
    private static final String PRESS_ENTER = "Press enter after each input ";



    private Series series;

    private JRadioButton linearRadioButton;

    private JRadioButton exponentialRadioButton;

    private JLabel typeOfaSeriesLabel;

    private JTextField firstElementTextField;

    private JLabel firstElementTextLabel;

    private JTextField delimeterTextField;

    private JLabel delimeterTextLabel;

    private JTextField sizeTextField;

    private JLabel sizeTextLabel;

    private JTextField fileTextField;

    private JLabel fileTextLabel;

    private JButton submitCreationButton;

    private JButton resetFieldsButton;

    private JLabel statusConstantTextLabel;

    private JLabel statusTextLabel;

    private JTextPane seriesTextPane;

    private JScrollPane seriesScrollPane;


    public Application(){
        super(TITLE);

        setWindowParams();
        initStaticElements();
        initDynamicElements();
        initPanels();

    }

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==submitCreationButton){
                submitCreationButtonProcessing();
            }
            else{
                if(e.getSource()==resetFieldsButton){
                  if(submitCreationButton.isEnabled()) {
                      reset();
                  } else {
                      resetAll();
                  }
                }
            }
        }



    private void radioButtonProcessing(){
        isLinear = (linearRadioButton.isSelected());
    }

    private void submitCreationButtonProcessing(){

        radioButtonProcessing();
        if(isReadyForCreation()){
            submitCreationButton.setEnabled(false);
            first = Integer.parseInt(firstElementTextField.getText());
            size = Integer.parseInt(sizeTextField.getText());
            delimeter = Integer.parseInt(delimeterTextField.getText());
            fileName = fileTextField.getText() + ".txt";
            if(isLinear){
                series = new Linear(first,delimeter,size);
            }
            else{
                series = new Exponential(first,delimeter,size);
            }
            sendMessage("Sum : "+Integer.toString(series.sum()));
            statusConstantTextLabel.setText(TEXT_STATUS +"Press RESET to create new Series");
            seriesTextPane.setText(series.toString());
            try {
                series.save(fileName, series.toString());
            } catch (IOException e){
                JOptionPane.showMessageDialog(this, "Writing exception " + e.getMessage() ,
                        "IOException",JOptionPane.ERROR_MESSAGE,new ImageIcon("HS.png"));
            }
            reset();
        }
        else {
            sendMessage("Invalid input, re-input wrong values");
            if(!sizeValidation()) sizeTextField.setText("");
            if(!firstElementValidation()) firstElementTextField.setText("");
            if(!delimeterValidation()) delimeterTextField.setText("");
            if(!filenameValidation()) fileTextField.setText("");
        }
    }

    private boolean sizeValidation() {

        if(!isNumber(sizeTextField.getText()) || isEmptyInputString(sizeTextField.getText())) {
             return false;
        } else{
            if(Integer.parseInt(sizeTextField.getText()) <= 0) {
                return false;
            }
        }

        return true;
    }

    private boolean firstElementValidation() {
        if(!isNumber(firstElementTextField.getText()) || isEmptyInputString(firstElementTextField.getText())) {
            return false;
        }
        return true;
    }

    private boolean delimeterValidation() {
        if(!isNumber(delimeterTextField.getText()) || isEmptyInputString(delimeterTextField.getText())) {
            return false;
        }
        return true;
    }

    private boolean filenameValidation() {
        if(!isAlphabeticOrNumeric(fileTextField.getText()) || isEmptyInputString(fileTextField.getText())) {
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

    private boolean isReadyForCreation(){

        return firstElementValidation() && sizeValidation() && delimeterValidation() && filenameValidation();
    }

    private boolean isAlphabeticOrNumeric (String string){

        for(int i = 0 ; i < string.length(); i++){
            if(!Character.isAlphabetic(string.charAt(i))&&!Character.isDigit(string.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean isEmptyInputString(String string){
        if(string.compareTo("")==0)
            return true;
        return false;
    }

    private void sendMessage(String message){
        statusTextLabel.setText(message);
    }

    private void reset(){
        isLinear = true;
        linearRadioButton.setSelected(true);
        exponentialRadioButton.setSelected(false);
        sizeTextField.setText("");
        firstElementTextField.setText("");
        delimeterTextField.setText("");
        fileTextField.setText("");
    }

    private void resetAll(){
        reset();
        seriesTextPane.setText("");
        sendMessage(textDynamicStatus);
        statusConstantTextLabel.setText(TEXT_STATUS + PRESS_ENTER);
        submitCreationButton.setEnabled(true);
    }

    private void initStaticElements() {

        typeOfaSeriesLabel = new JLabel(CHOOSE_TYPE_OF_A_SERIES);
        typeOfaSeriesLabel.setVerticalAlignment(JLabel.CENTER);
        typeOfaSeriesLabel.setHorizontalAlignment(JLabel.CENTER);

        firstElementTextLabel = new JLabel(ENTER_FIRST_ELEMENT);
        firstElementTextLabel.setHorizontalAlignment(JLabel.CENTER);
        firstElementTextLabel.setVerticalAlignment(JLabel.CENTER);

        delimeterTextLabel = new JLabel(ENTER_DELIMETER);
        delimeterTextLabel.setHorizontalAlignment(JLabel.CENTER);
        delimeterTextLabel.setVerticalAlignment(JLabel.CENTER);

        sizeTextLabel = new JLabel(ENTER_SIZE);
        sizeTextLabel.setVerticalAlignment(JLabel.CENTER);
        sizeTextLabel.setHorizontalAlignment(JLabel.CENTER);


        fileTextLabel = new JLabel(ENTER_FILE_FOR_SAVING);
        fileTextLabel.setHorizontalAlignment(JLabel.CENTER);
        fileTextLabel.setVerticalAlignment(JLabel.CENTER);

        statusConstantTextLabel = new JLabel(TEXT_STATUS +" "+ PRESS_ENTER);
        statusConstantTextLabel.setVerticalAlignment(JLabel.CENTER);
        statusConstantTextLabel.setHorizontalAlignment(JLabel.CENTER);

        statusTextLabel = new JLabel(textDynamicStatus);
        statusTextLabel.setHorizontalAlignment(JLabel.CENTER);
        statusTextLabel.setVerticalAlignment(JLabel.CENTER);

    }

    private void initDynamicElements() {

        linearRadioButton = new JRadioButton(TEXT_LINEAR,true);
        linearRadioButton.addActionListener(this);
        exponentialRadioButton = new JRadioButton(TEXT_EXPONENTIAL, false);
        exponentialRadioButton.addActionListener(this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(linearRadioButton);
        buttonGroup.add(exponentialRadioButton);



        firstElementTextField = new JTextField();
        firstElementTextField.addActionListener(this);

        delimeterTextField = new JTextField();
        delimeterTextField.addActionListener(this);

        sizeTextField = new JTextField();
        sizeTextField.addActionListener(this);

        fileTextField = new JTextField();
        fileTextField.addActionListener(this);

        submitCreationButton = new JButton(TEXT_SUBMIT_CREATION);
        submitCreationButton.setHorizontalAlignment(JButton.CENTER);
        submitCreationButton.setVerticalAlignment(JButton.CENTER);
        submitCreationButton.addActionListener(this);
        submitCreationButton.setMaximumSize(new Dimension(25,15));
        submitCreationButton.setPreferredSize(new Dimension(25,15));

        resetFieldsButton = new JButton(TEXT_RESET_FIELDS);
        resetFieldsButton.setVerticalAlignment(JButton.CENTER);
        resetFieldsButton.setHorizontalAlignment(JButton.CENTER);
        resetFieldsButton.addActionListener(this);

        seriesTextPane = new JTextPane();
        seriesScrollPane = new JScrollPane(seriesTextPane);
        seriesTextPane.setEditable(false);
    }

    private void initPanels() {

        JPanel firstRow = new JPanel(new GridLayout(1,2));
        JPanel firstColumnOfFirstRow = new JPanel(new GridLayout(1,2));

        firstColumnOfFirstRow.add(linearRadioButton);
        firstColumnOfFirstRow.add(exponentialRadioButton);


        firstRow.add(typeOfaSeriesLabel);
        firstRow.add(firstColumnOfFirstRow);


        JPanel secondRow = new JPanel(new GridLayout(1,4));
        secondRow.add(firstElementTextLabel);
        secondRow.add(firstElementTextField);
        secondRow.add(delimeterTextLabel);
        secondRow.add(delimeterTextField);

        JPanel thirdRow = new JPanel(new GridLayout(1,4));
        thirdRow.add(sizeTextLabel);
        thirdRow.add(sizeTextField);
        thirdRow.add(fileTextLabel);
        thirdRow.add(fileTextField);

        JPanel forthRow = new JPanel(new GridLayout(1,2));
        JPanel firstColumnOfForthRow = new JPanel(new GridLayout(2,1));
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.add(submitCreationButton);
        buttonPanel.add(resetFieldsButton);
        JPanel secondColumn = new JPanel(new FlowLayout(0));
        secondColumn.add(statusConstantTextLabel);
        secondColumn.add(statusTextLabel);
        firstColumnOfForthRow.add(buttonPanel);
        firstColumnOfForthRow.add(secondColumn);
        forthRow.add(firstColumnOfForthRow);
        forthRow.add(seriesScrollPane);

        JPanel realFirstRow = new JPanel(new GridLayout(3,1));
        realFirstRow.add(firstRow);
        realFirstRow.add(secondRow);
        realFirstRow.add(thirdRow);


        this.add(realFirstRow);
        this.add(forthRow);
    }

    private void setWindowParams() {

        this.setBounds(X_FRAME, Y_FRAME, WIDTH_FRAME, HEIGHT_FRAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,1));
        ImageIcon imageIcon = new ImageIcon("HS.jpg");
        this.setIconImage(imageIcon.getImage());

        textDynamicStatus  = "Processing series creation";
        isLinear = true;
    }

    public static void main( String...args) {

        Application application = new Application();
        application.setVisible(true);
        //myApplication.pack();
    }
}

