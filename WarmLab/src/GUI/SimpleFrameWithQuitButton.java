import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;                                                                                                                                                                                           

public class SimpleFrameWithQuitButton extends JFrame implements ActionListener  {          

	public static final int DEFAULT_WIDTH = 300;                                                                                                                                                                     
	public static final int DEFAULT_HEIGHT = 200;         

	private JButton quitButton;
	private JTextArea text;

	public SimpleFrameWithQuitButton() {                                                                                                                                                                             
		setTitle("A Simple Frame with quit button");                                                                                                                                                                   
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);                                                                                                                                                                        
		Container contentPane = this.getContentPane();                                                                                                                                                                 
		JPanel p = new JPanel();                                                                                                                                                                                       
		quitButton = new JButton("Quit");  quitButton.addActionListener(this);                                                                                                                                             
		p.add(quitButton);
		
		// TASK 5
		
		for (int i = 1 ; i < 5 ; i++) {
			p.add(makeJButton(String.valueOf(i), this));
		}
		
		// output messages go here
		text = new JTextArea();
		
		contentPane.add(p, BorderLayout.NORTH);
		contentPane.add(text, BorderLayout.CENTER);
	}

	// button generation method for Task 5
	
	private JButton makeJButton(String s, ActionListener al) {
		JButton b = new JButton(s);
		b.addActionListener(al);
		return b;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == quitButton) {
			System.exit(0);
		}
		// Following added for Task 5
		else {
			text.setText("You have pressed button " + ((JButton) source).getText());
			
		}
	}
	
	// main required to run Task 5
	
	public static void main (String[] args) {
		JFrame frm = new SimpleFrameWithQuitButton();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}


}