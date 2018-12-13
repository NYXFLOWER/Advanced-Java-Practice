package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener, ComponentListener {

	private MyPanel2 drawingPanel; // a panel to draw polygons

	public MyFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		this.setBounds((int) width/4, (int) height/4, (int) width/2, (int) height/2);

		Container contentPane = this.getContentPane(); 
		drawingPanel = new MyPanel2();
		drawingPanel.addComponentListener(this);
		contentPane.add(drawingPanel, BorderLayout.CENTER);

		/* Create a column of buttons using GridLayout in an ordinary JPanel
		 * (because it doesn't need extra functionality) on the EAST side of 
		 * the content pane.
		 */
		JPanel columnOfButtons = new JPanel(new GridLayout(8,1));

		for (int i=3; i<10; i++) {
			makeButton(columnOfButtons, String.valueOf(i), this);
		}

		makeButton(columnOfButtons, "Exit", this); 
		contentPane.add(columnOfButtons, BorderLayout.EAST);
	}

	private void makeButton(JPanel p, String name, ActionListener target) {
		JButton b = new JButton(name);
		// add it to the specified JPanel and make the JPanel listen
		p.add(b);  
		b.addActionListener(target); 
	}

	public void actionPerformed(ActionEvent e) {
		// Do the appropriate thing depending on which button is pressed.  
		// Use the getActionCommand() method to identify the button. 
		String command = e.getActionCommand();
		System.out.println(command);
		if (command.equals("Exit")) {
			System.exit(0);
		}
		else {
			int sides = Integer.parseInt(command);
			drawingPanel.setPolygon(sides);
		}
		
	}

	public static void main(String args[]) { 
		JFrame frm = new MyFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frm.setVisible(true); 
	}

	@Override
	public void componentResized(ComponentEvent e) {
		if (e.getSource() == drawingPanel) {
			drawingPanel.setPolygon();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
