/**
 *
 *  JCalculatorSolution.java
 *   
 *   Classes to produce a simple calculator in a window
 *   
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;


public class JCalculatorSolution extends JFrame{

	public JCalculatorSolution() {

		// set size, position, icon, and title for the JFrame
		setTitle("JCalculator");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setSize(300,400);
		setLocation(new Point(dim.width/4, dim.height/4));
		Container contentPane = this.getContentPane();

		// designate top (NORTH) panel for display
		JTextArea display = new JTextArea(1,20);
		display.setFont(new Font("Courier", Font.BOLD, 40));
		display.setEditable(false);
		display.setPreferredSize(new Dimension(300,100));
		contentPane.add(display, BorderLayout.NORTH);

		// designate centre panel for buttons
		// and add it to the frame
		CalculatorSolutionButtons buttons = new CalculatorSolutionButtons(display);
		buttons.setLayout(new GridLayout(4,4));
		contentPane.add(buttons, BorderLayout.CENTER);

	}

	public static void main(String args[]) {
		JFrame frm = new JCalculatorSolution();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}

class CalculatorSolutionButtons extends JPanel {
	enum OP { PLUS, MINUS, MULT, DIV }
	private static final String buttonLabels[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "=", "+/-", "/" };
	private static final String opButtonLabels[] = {"+","-","*","=","+/-","/"};
	private int operand1;
	private OP operation;
	private int displayedValue;

	public CalculatorSolutionButtons(JTextArea display) {
		// create buttons using factory method
		for (int i=0; i<16; i++) {
			makeButton(this, buttonLabels[i], display);
		} 

		operand1 = 0;
		displayedValue = 0;
		operation = null;
	}

	// factory method for making buttons
	private void makeButton(JPanel p, String name, JTextArea display) {
		JButton b = new JButton(name);
		p.add(b);
		ButtonAction a = new ButtonAction(name, display);
		b.addActionListener(a); 
	}

	private class ButtonAction implements ActionListener {
		private String theLabel;
		private JTextArea theDisplay;

		public ButtonAction(String name, JTextArea d) {
			theLabel = name;
			theDisplay = d;
		}

		public void actionPerformed(ActionEvent actionEvent) {
			boolean opButtonPressed = false;
			String resultText;

			for (int i = 0; i <6; i++){
				if (theLabel.equals(opButtonLabels[i])){
					opButtonPressed = true;
				}
			}

			if (!opButtonPressed) {
				displayedValue=displayedValue*10+Integer.parseInt(theLabel);
				theDisplay.setText(Integer.toString(displayedValue));
			} else if (theLabel.equals("+/-")) { 
				displayedValue = -displayedValue;
				if (displayedValue != 0)
					theDisplay.setText(Integer.toString(displayedValue));// only display value if a value has been entered
			} else if (theLabel.equals("=")) {

				if (operation == null) {
					System.out.println("No-op "+displayedValue);
				} else {
					int operand2 = displayedValue;
					System.out.println("Operands are " + operand1 + " and " + operand2);
					switch (operation){
					case PLUS : displayedValue = operand1 + operand2; break;
					case MINUS : displayedValue = operand1 - operand2; break;
					case MULT : displayedValue = operand1 * operand2; break;
					case DIV : displayedValue = operand1 / operand2; break;
					}
					System.out.println("Result = " + displayedValue);
					operand1 = 0;
					operation = null;// clear operation
					theDisplay.setText(Integer.toString(displayedValue));
				}
			}
			else if (operation == null) {
				if (theLabel.equals("+")) {
					operand1 = displayedValue;
					operation = OP.PLUS;
					theDisplay.setText("+");
					displayedValue = 0;
				}
				else if (theLabel.equals("-")) {
					operand1 = displayedValue;
					operation = OP.MINUS;
					theDisplay.setText("-");
					displayedValue = 0;
				}
				else if (theLabel.equals("*")) {
					operand1 = displayedValue;
					operation = OP.MULT;
					theDisplay.setText("*");
					displayedValue = 0;
				}
				else if (theLabel.equals("/")) {
					operand1 = displayedValue;
					operation = OP.DIV;
					theDisplay.setText("/");
					displayedValue = 0;
				}
			}
		}
	}
}
