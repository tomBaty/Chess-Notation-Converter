
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.GridBagConstraints;

public class GUI extends JFrame {
    public static JTextArea input, output;
    JButton convert;
    JComboBox<String> mode;
    JLabel pasteGame;

    public GUI(){
        setTitle("SWEN221 Chess Tool");
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        convert = new JButton("Convert");
        convert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Chess.convert(input.getText());
                output.setText(Chess.output.toString());
            }
        });

        input = new JTextArea(5,5);
        input.setLineWrap(true);
        output = new JTextArea(5,5);
        output.setLineWrap(true);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0,20,0,10);

        pasteGame = new JLabel("Paste moves in short notation (eg. 1. e4 e5).");
        mode = new JComboBox<String>();
        mode.addItem("Long format");
        mode.addItem("Code string");
        mode.addItem("Code string and board");

        c.gridx = 1; c.gridy = 0;
        c.ipady = 80; c.weightx = 1.5;
        input.setMaximumSize(input.getPreferredSize());
        add(input,c);

        c.gridy = 2;
        add(output,c);

        c.ipady = 20; c.weightx = 1;
        c.gridx = 3; 
        c.gridy = 0; 
        add(pasteGame,c);
        
        c.gridy = 1;
        add(mode,c);

        c.gridy = 2;
        add(convert,c);

        setVisible(true);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
    }

    public static void main(){
        new GUI();
    }
}
