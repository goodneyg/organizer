package organizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class gui {

	    public static void main(String[] args) {

	        JFrame frame = new JFrame();
	        frame.setSize(400, 400);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        Container container = frame.getContentPane();
	        container.setLayout(new FlowLayout());

	        JTextField textField = new JTextField();
	        textField.setPreferredSize(new Dimension(150, 25));

	        JLabel label = new JLabel("Input will appear here");

	        JButton okButton = new JButton("OK");
	        okButton.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String input = textField.getText();
	                System.out.println("Input: " + input);
	                textField.setText("");
	                label.setText(input);
	            }
	        });

	        container.add(textField);
	        container.add(okButton);
	        container.add(label);

	        frame.setVisible(true);
	    }
	}
	
	/*
	class gui {
	    public static void main(String args[]) {

	        //Creating the Frame
	        JFrame frame = new JFrame("Chat Frame");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 400);

	        //Creating the MenuBar and adding components
	        JMenuBar mb = new JMenuBar();
	        JMenu m1 = new JMenu("FILE");
	        JMenu m2 = new JMenu("Help");
	        mb.add(m1);
	        mb.add(m2);
	        JMenuItem m11 = new JMenuItem("Open");
	        JMenuItem m22 = new JMenuItem("Save as");
	        m1.add(m11);
	        m1.add(m22);

	        //Creating the panel at bottom and adding components
	        JPanel panel = new JPanel(); // the panel is not visible in output
	        JLabel label = new JLabel("Enter Text");
	        JTextField tf = new JTextField(10); // accepts upto 10 characters
	        JButton send = new JButton("Send");
	        JButton reset = new JButton("Reset");
	        panel.add(label); // Components Added using Flow Layout
	        panel.add(tf);
	        panel.add(send);
	        panel.add(reset);

	        // Text Area at the Center
	        JTextArea ta = new JTextArea();

	        //Adding Components to the frame.
	        frame.getContentPane().add(BorderLayout.SOUTH, panel);
	        frame.getContentPane().add(BorderLayout.NORTH, mb);
	        frame.getContentPane().add(BorderLayout.CENTER, ta);
	        frame.setVisible(true);
	    }
	}
	*/

