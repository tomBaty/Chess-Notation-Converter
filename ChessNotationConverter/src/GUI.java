package src;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridBagConstraints;

public class GUI extends JFrame {
    public static JTextArea input, output;
    JButton convert;
    JComboBox<String> mode;
    JLabel pasteGame;
    Font f = new Font("Consolas", Font.PLAIN, 15);

    public GUI(){
        setTitle("SWEN221 Chess Tool");
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        convert = new JButton("Convert");
        convert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Chess.testContents(input.getText());
            }
        });

        input = new JTextArea(20,5);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        input.setFont(f);
        JScrollPane inputPane = new JScrollPane(input);

        output = new JTextArea(20,5);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setFont(f);
        JScrollPane outputPane = new JScrollPane(output);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,0,10);

        c.gridx = 1; c.gridy = 0;
        c.ipady = 80; c.weightx = 1.5;
        input.setMaximumSize(input.getPreferredSize());
        add(inputPane,c);

        c.gridx = 2;
        add(outputPane,c);

        c.ipady = 20; c.weightx = 1;
        c.gridx = 3; 
        
        c.gridy = 0;

        c.gridy = -1;
        add(convert,c);

        setVisible(true);
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
    }
}
