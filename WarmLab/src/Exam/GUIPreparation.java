package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPreparation {
    public static void main(String[] args) {
        JFrame frm = new ButtonFrame4();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}

class ButtonFrame4 extends JFrame {

    public ButtonFrame4() {
        setTitle("Button Test");

        // size, position and icon
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(dim.width/4, dim.height/4);
        setLocation(new Point(dim.width/4, dim.height/4));


        Container c = getContentPane();
        // draw center panel
        JPanel centrePanel = new JPanel();
        c.add(centrePanel,"Center");
        // draw button panel
        c.add(new ButtonPanel(), "South");
    }
}

// Action
class ButtonPanel extends JPanel {

    public ButtonPanel() {
        makeButton("blue", Color.BLUE);
        makeButton("green", Color.GREEN);
        makeButton("red", Color.RED);
    }

    void makeButton(String name, final Color color) {
        JButton button = new JButton(name);
        add(button);
        button.addActionListener(
                actionEvent -> setBackground(color)
        );
//        new ActionListener() {
//            public void actionPerformed(ActionEvent actionEvent) {
//                setBackground(color);
//            }
//        };
    }
}


