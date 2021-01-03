package bpmnforcpsextension;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;


public class Test  extends JFrame{
    public JTextField textField;
    public static JTextField minval;
    public static JTextArea textArea;
    public JScrollPane scrollPane;
    private static JTextField maxval;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {  
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) { 
                println(e)
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Test frame = new Test();
                    frame.setVisible(true); 
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Test() {
        setResizable(false);
        BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
        borderLayout.setVgap(3);
        borderLayout.setHgap(1);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("Choose");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
                chooser.setApproveButtonText("OK"); //intitulé du bouton
                //chooser.showOpenDialog(null); //affiche la boite de dialogue

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {  
                    textField.setText(chooser.getSelectedFile().getAbsolutePath()); 
                    //si un fichier est selectionné, récupérer le fichier puis sont path et l'afficher dans le champs de texte 
                }
            }
        });

        btnNewButton.setBounds(750, 11, 89, 23);
        panel.add(btnNewButton);
        
        textField = new JTextField();
        textField.setBounds(70, 11, 651, 22);
        panel.add(textField);
        textField.setColumns(10);
        
        minval = new JTextField();
        minval .setBounds(229, 47, 163, 22);
        panel.add(minval );
        minval.setColumns(9);
        
        JLabel lblMinimunValue = new JLabel("Minimun value :");
        lblMinimunValue.setBounds(144, 51, 101, 14);
        panel.add(lblMinimunValue);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 81, 885, 439);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(1, 31, 851, 347);
        
        panel_1.add(textArea) ;
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 11, 853, 428);
        panel_1.add(scrollPane);
        JLabel lblBpmnFile = new JLabel("BPMN File : ");
        lblBpmnFile.setBounds(10, 18, 77, 14);
        panel.add(lblBpmnFile);
        JLabel labelminval = new JLabel("Model Deadline: ");
        labelminval.setBounds(10,51,90, 14);
        panel.add(labelminval);
        JLabel lblMaximumValue = new JLabel("Maximum value :");
        lblMaximumValue.setBounds(479, 51, 89, 14);
        panel.add(lblMaximumValue);
        maxval = new JTextField();
        maxval.setColumns(9);
        maxval.setBounds(564, 47, 157, 22);
        panel.add(maxval);
        JButton btnOk = new JButton("OK");
        btnOk.setBounds(750, 47, 89, 23);
        panel.add(btnOk);
        btnOk.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int n1= Integer.parseInt(minval.getText());
                int n2= Integer.parseInt(maxval.getText());
                textArea.setText("");
                String a= textField.getText();
                File entryFile = new File(a);
                Verif.parse(entryFile,n1,n2);
            }
        });

        setBounds(100, 100, 911, 560);
    }

    
    public static  void prompt(String mot) {
        textArea.append(mot + "\n"); 
    }
}
