package Cal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    //create frames and buttons
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButtons, subButtons, mulButtons, divButtons;
    JButton decButtons, equButtons, delButtons, clrButtons, negButtons;

    JPanel panel;

    Font myFont = new Font("Maiandra GD", Font.BOLD, 30);//change font style
    double num1=0, num2=0, result=0;
    char operator = '+';



    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //defind function buttons
        addButtons = new JButton("+");
        subButtons = new JButton("-");
        mulButtons = new JButton("*");
        divButtons = new JButton("/");
        decButtons = new JButton(".");
        equButtons = new JButton("=");
        delButtons = new JButton("Dlt");
        clrButtons = new JButton("Clr");
        negButtons = new JButton("(-)");

        functionButtons[0] = addButtons;
        functionButtons[1] = subButtons;
        functionButtons[2] = mulButtons;
        functionButtons[3] = divButtons;
        functionButtons[4] = decButtons;
        functionButtons[5] = equButtons;
        functionButtons[6] = delButtons;
        functionButtons[7] = clrButtons;
        functionButtons[8] = negButtons;

        for (int i=0; i<9; ++i){

            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i=0;i<10;++i){

            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        //create button size
        negButtons.setBounds(50, 430, 100, 50);
        delButtons.setBounds(150,430,100,50);
        clrButtons.setBounds(250,430,100,50);

        //create panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.lightGray);

        //given the order of numbers button and function buttons
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButtons);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButtons);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButtons);

        panel.add(decButtons);
        panel.add(numberButtons[0]);
        panel.add(equButtons);
        panel.add(divButtons);

        frame.add(negButtons);
        frame.add(panel);
        frame.add(delButtons);
        frame.add(clrButtons);
        frame.add(textField);
        frame.setVisible(true);

    } //constructor

    public static void main(String[] args){

        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0; i<10; ++i){

            //get a click value and check is it equal to number?
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        //get a click value and check is it equal to function?
        if(e.getSource() == decButtons){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButtons) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButtons){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }

        if(e.getSource() == mulButtons){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }

        if(e.getSource() == divButtons){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }

        if(e.getSource()==clrButtons){
            textField.setText("");
        }

        if(e.getSource() == negButtons){

            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));

        }

        if(e.getSource()==delButtons){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        // defind equal operation and create math operators
        if(e.getSource() == equButtons) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

    }
}
