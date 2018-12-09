
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Task6 extends JFrame {

	public Task6() {
		setTitle("Task 6");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		// top left
		this.setBounds(0,0, (int) width/2, (int) height/2);

		String toBe = "To be or not to be";

		Container content = this.getContentPane();

		// Fonts can be set with l0.setFont(...) but may
		// be system-dependent
		
		JLabel l0 = new JLabel(toBe);
		l0.setForeground(Color.RED);
		
		JLabel l1 = new JLabel(toBe);
		l1.setForeground(Color.BLUE);

		JLabel l2 = new JLabel(toBe);
		l2.setForeground(Color.YELLOW);

		JLabel l3 = new JLabel(toBe);
		l3.setForeground(Color.GREEN);
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(l0, BorderLayout.WEST);
		top.add(l1, BorderLayout.EAST);

		JPanel bottom = new JPanel(new BorderLayout());
		bottom.add(l2, BorderLayout.WEST);
		bottom.add(l3, BorderLayout.EAST);

		ImageIcon ii = new ImageIcon("globe.gif");
		JLabel iLabel = new JLabel(ii);
		content.add(iLabel, BorderLayout.CENTER);

		content.add(top,  BorderLayout.NORTH);
		content.add(bottom, BorderLayout.SOUTH);
	} 

	public static void main (String[] args) {
		JFrame frm = new Task6();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
