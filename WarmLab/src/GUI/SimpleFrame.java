
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SimpleFrame extends JFrame {

	public SimpleFrame() {
		setTitle("Quarter Sized Frame");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		// Task 1
		
		// top left
		this.setBounds(0,0, (int) width/2, (int) height/2);

		// top right
		// this.setBounds((int) width/2, 0, (int) width/2, (int) height/2);

		// bottom left
		// this.setBounds(0, (int) height/2, (int) width/2, (int) height/2);

		// bottom right
		// this.setBounds((int) width/2, (int) height/2, (int) width/2, (int) height/2);

	} 

	public static void main (String[] args) {
		JFrame frm = new SimpleFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
