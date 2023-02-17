/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author saubhagyadwitiya
 */
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField txtf;
    JButton numButtons[] = new JButton[10];
    JButton funcButtons[] = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    
    JPanel panel;
    Font myfont = new Font("Arial",Font.BOLD,30);
    //variables to store values and result
    double num1 = 0, num2 = 0, result = 0;
    
    char operator;
    
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setResizable(false);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,800);
        frame.setLayout(null);
        
        txtf = new JTextField();
        txtf.setBounds(50, 25, 300, 50);
        txtf.setFont(myfont);
        txtf.setEditable(false);
        
        //define the buttons
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("Neg");
        
        //add function buttons to the array
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;
        
        
        for(int i=0;i<9;i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myfont);
            funcButtons[i].setFocusable(false);
        }
        
        //define number buttons
        for(int i=0;i<10;i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myfont);
            numButtons[i].setFocusable(false);
        }
        
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250,430,100,50);
        
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(txtf);
        frame.setVisible(true);
    }
    
    public static void main(String[] args){
        Calculator c = new Calculator();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //if user presses number buttons
        for(int i=0;i<10;i++){
            if(e.getSource() == numButtons[i]){
                txtf.setText(txtf.getText().concat(String.valueOf(i)));
            }
        }
        
        //if user presses other buttons
        if(e.getSource()==decButton){
            txtf.setText(txtf.getText().concat("."));
        }
        
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(txtf.getText());
            operator = '+';
            txtf.setText("");
        }
        
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(txtf.getText());
            operator = '-';
            txtf.setText("");
        }
        
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(txtf.getText());
            operator = '*';
            txtf.setText("");
        }
        
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(txtf.getText());
            operator = '/';
            txtf.setText("");
        }
        
        if(e.getSource()==equButton){
            num2 = Double.parseDouble(txtf.getText());
            
            switch(operator){
                case'+':
                    result = num1+num2;
                    break;
                case'-':
                    result = num1-num2;
                    break;
                case'/':
                    result = num1/num2;
                    break;
                case'*':
                    result = num1*num2;
                    break;
            }
            txtf.setText(String.valueOf(result));
            num1 = result;
        }
        
        if(e.getSource()==clrButton){
            txtf.setText("");
        }
        
        if(e.getSource()==delButton){
            String str = txtf.getText();
            txtf.setText("");
            txtf.setText(str.substring(0,str.length()-1));
        }
        
        if(e.getSource()==negButton){
            double temp = Double.parseDouble(txtf.getText());
            temp*=-1;
            txtf.setText(String.valueOf(temp));
        }
    }
}
