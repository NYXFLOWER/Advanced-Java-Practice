import java.awt.*;
import javax.swing.*;

public class SimpleFrame2 extends JFrame {
	
	public SimpleFrame2() {
		setTitle("Drawing Frame");
		setSize(350, 200);
		Container contentPane = this.getContentPane();
		myDrawing = new MyPanel();
		contentPane.add(myDrawing);
	}

	private MyPanel myDrawing;

	public static void main (String[] args) {
		JFrame frm = new SimpleFrame2();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}
