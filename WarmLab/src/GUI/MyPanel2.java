package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javax.swing.JPanel;

public class MyPanel2 extends JPanel {

	// TODO 
	// everything

	private Polygon polygon;
	private int sides;
	
	public MyPanel2() {
		setBackground(Color.white);
		polygon = null;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		if (polygon != null) {
			g2.draw(polygon);
		}
	}

	
	public void setPolygon(int sides) {
		this.sides = sides;
		this.setPolygon();
	}

	public void setPolygon() {
		// coordinates of the centre of this JPanel
		double xCentre = this.getWidth() / 2.0;
		double yCentre = this.getHeight() / 2.0;

		// Radius of a circle that will occupy 90% of the smaller X or Y dimension
		double radius = Math.min(xCentre, yCentre) * 0.9;

		int[] xs = new int[sides];
		int[] ys = new int[sides];
		double increment = 2 * Math.PI / sides;
		for (int i = 0 ; i < sides ; i ++) {
			xs[i] = (int) (xCentre + radius * Math.cos(i * increment));
			ys[i] = (int) (yCentre + radius * Math.sin(i * increment));
		}
		polygon = new Polygon(xs, ys, sides);
		this.repaint();
	}
}
