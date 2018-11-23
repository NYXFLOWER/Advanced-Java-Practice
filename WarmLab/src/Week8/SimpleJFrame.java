package Week8;

import javax.swing.*;
import java.awt.*;


public class SimpleJFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 200;

    public SimpleJFrame() {
        setTitle("Flower & MT");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //
        Container contentPane = this.getContentPane();
        JPanel myDrowing = new MyPane();
        contentPane.add(myDrowing);
    }

    public static void main(String[] args) {
        JFrame frm = new SimpleJFrame();

        // NECESSARY!
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate program when the window is closed
        frm.setVisible(true);  // must be called before the frame is displayed
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