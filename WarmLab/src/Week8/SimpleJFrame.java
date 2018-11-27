package Week8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleJFrame extends JFrame implements ActionListener {
    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 200;
    JButton quitButton = new JButton("Quit");
    Container contentPane = getContentPane();


    public SimpleJFrame() {
        setTitle("Flower & MT");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // add panel
//        JPanel myDrowing = new MyPane();
//        contentPane.add(myDrowing);

        // add JButton to JPanel then to JFrame, after setting action listener and event
//        quitButton.addActionListener(this);
//        JPanel panelQuit = new JPanel();
//        panelQuit.add(quitButton);
//        contentPane.add(panelQuit);

        // border layout
        JPanel panelLayout = new JPanel();
        contentPane.add(panelLayout, BorderLayout.SOUTH);   // North, South, West, East & Center
    }

    public static void main(String[] args) {
        JFrame frm = new SimpleJFrame();

        // NECESSARY!
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate program when the window is closed
        frm.setVisible(true);  // must be called before the frame is displayed
    }

    @Override
    public void actionPerformed(ActionEvent event) { // use button must implement ActionListener and its abstract method
        Object source = event.getSource();

        // return source object of the event
        if (source == quitButton) {
            System.exit(0);
        }
    }
}

class MyPane extends JPanel {
    public MyPane() {
        setBackground(Color.yellow);
    }

    public void paintComponent(Graphics graphics) {
        // draw line
//        super.paintComponent(graphics);
//        graphics.drawLine(20,  20, 88, 88);

        //
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(6));
        graphics2D.setPaint(Color.green);
        graphics2D.setFont(new Font("Papyrus", Font.PLAIN, 48));
        // make shapes and text appear
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        // draw
        graphics2D.drawString("I LOVE YOU!", 88, 88);
    }
}