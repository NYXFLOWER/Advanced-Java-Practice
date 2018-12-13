package GUI;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/* MyPanel.java 1.0 
 *  
 * Creates a panel including examples of different types of Graphocs 2D 
 * objects that can be included in the interface
 * (You should make sure that you understand what the different parts of the 
 * code do and how it affects what you see in the interface.)
 */

public class MyPanel extends JPanel {

	public MyPanel() {
		setBackground(Color.white);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Task 3
		g2.setStroke(new BasicStroke(10)); 
		g2.setPaint(new Color(128,0,0));  
		
		Rectangle2D.Double s = new Rectangle2D.Double(20.0,20.0,100.0,50.0);
		g2.draw(s);

		// Example of how polymorphism can be used to include 
		// several different types of object in an interface
		g2.setStroke(new BasicStroke(3));  
		Shape[] shapeList = new Shape[3];		
		shapeList[0] = new Rectangle2D.Double(150.0, 20.0, 170.0, 70.0);
		shapeList[1] = new Ellipse2D.Double(150.0, 20.0, 170.0, 70.0);
		int[] x = { 10, 50, 70};
		int[] y = { 20, 70, 20 };
		shapeList[2] = new Polygon(x, y, 3);

		// now update the display
		for (Shape shape : shapeList)
			g2.draw(shape);

		// Task 4
		
		// Example of adding text to interface
		g2.setPaint(Color.black); // set draw colour
		// set Font and size 		
		g2.setFont(new Font("Papyrus", Font.PLAIN, 48));
		// set rendering to smooth edges
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON );
		String text = "Test message"; // this is our text
		g2.drawString(text, 40, 150); // draw it

	}
}

