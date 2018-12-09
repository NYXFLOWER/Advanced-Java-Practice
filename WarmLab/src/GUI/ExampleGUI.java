package Week9;


import org.omg.CORBA.OBJ_ADAPTER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExampleGUI {
    public static void main(String[] args) {
        JFrame gf;
//        gf = new GUI1Frame();                       // quit button
//        gf = new GUI2Frame();                       // redraw button and quit button
        gf = new GUI3Frame();                       // set button plane background color with button
//        gf = new ButtonFrame4();                     // RGB button with ColorAction class
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.setVisible(true);
    }
}

//------------------------------------------------------------------------------
class GUIFrame extends JFrame implements ActionListener {

    public GUIFrame() {
        this.setTitle("GUIJFrame Example");
        this.setSize(600, 400);

        Container contentPane = this.getContentPane();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // Factory method for Buttons
    public static JButton makeJButton(String s, ActionListener a) {     // this -> a
        JButton b = new JButton(s);
        b.addActionListener(a);
        return b;
    }
}

//------------------------------------------------------------------------------
// A frame with quit button
class GUI1Frame extends JFrame implements ActionListener {
    private JButton quitButton;

    public GUI1Frame() {
        this.setTitle("Event Handling");
        this.setSize(200, 100);
        Container contentPane = this.getContentPane();
        JPanel p = new JPanel();
        this.quitButton = new JButton("Quit");
        this.quitButton.addActionListener(this);
        p.add(this.quitButton);
        contentPane.add(p);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == this.quitButton) {
            System.out.println("The quit button has been pressed");
            System.exit(0);
        }

    }
}

//------------------------------------------------------------------------------
class GUI2Frame extends JFrame implements ActionListener {
    private JButton quitButton;
    private JButton redrawButton;
    private GUI2Panel drawingPanel;

    public GUI2Frame() {
        this.setTitle("Event Handling 2");
        this.setSize(250, 150);
        Container contentPane = this.getContentPane();
        JPanel p = new JPanel();
        this.quitButton = this.makeJButton("Quit", this);
        p.add(this.quitButton);
        this.redrawButton = this.makeJButton("Redraw", this);
        p.add(this.redrawButton);
        contentPane.add(p, "South");

        // add draw panel
        this.drawingPanel = new GUI2Panel();
        contentPane.add(this.drawingPanel, "Center");
    }

    private JButton makeJButton(String s, ActionListener a) {
        JButton b = new JButton(s);
        b.addActionListener(a);
        return b;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == this.quitButton) {
            System.exit(0);
        } else if (source == this.redrawButton) {
            this.drawingPanel.repaint();        // method will call the override method paintComponent()
        }

    }
}

class GUI2Panel extends JPanel {
    GUI2Panel() {
        this.setBackground(Color.white);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine((int)(Math.random() * 200.0D), (int)(Math.random() * 150.0D), (int)(Math.random() * 120.0D), (int)(Math.random() * 70.0D));
    }
}

//------------------------------------------------------------------------------
class GUI3Frame extends JFrame implements ActionListener {
    JPanel buttonPanel = new JPanel();
    JButton red = GUIFrame.makeJButton("red", this);
    JButton blue = GUIFrame.makeJButton("Blue", this);
    JButton green = GUIFrame.makeJButton("Green", this);

    GUI3Frame() {
        this.setTitle("Button for colour change");
        this.setSize(600, 400);

        Container container = getContentPane();
        buttonPanel.add(red); buttonPanel.add(blue); buttonPanel.add(green);
        container.add(buttonPanel, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == red) {
            buttonPanel.setBackground(Color.RED);
        } else if (source == green) {
            buttonPanel.setBackground(Color.GREEN);
        } else if (source == blue) {
            buttonPanel.setBackground(Color.BLUE);
        }
    }
}

//------------------------------------------------------------------------------
class ButtonFrame extends JFrame {
    ButtonFrame() {
        setTitle("RBG button test");

        // set size, position and icon
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(dim.width/4, dim.height/4);
        setLocation(new Point(dim.width/4, dim.height/4));

        // container and center panel
        Container c = getContentPane();
        JPanel centrePanel = new JPanel();
        c.add(centrePanel);

        // add button panel
        c.add(new ButtonPanel(), "South");
    }
}


class ButtonPanel extends JPanel {
    public ButtonPanel() {
        // create buttons
        JButton green = new JButton("Green");
        JButton red = new JButton("Red");
        JButton blue = new JButton("Blue");

        // add buttons to panel
        add(green); add(red); add(blue);

        // create button actions
        ColorAction3 greenAction = new ColorAction3(Color.GREEN, this);
        ColorAction3 blueAction = new ColorAction3(Color.BLUE, this);
        ColorAction3 redAction = new ColorAction3(Color.RED, this);

        // associate actions to buttons
        green.addActionListener(greenAction);
        blue.addActionListener(blueAction);
        red.addActionListener(redAction);
    }
}

class ColorAction3 implements ActionListener {
    private Color theColor;
    private JComponent theComponent;

    public ColorAction3(Color col, JComponent comp) {
        theColor = col;
        theComponent = comp;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        theComponent.setBackground(theColor);
    }
}

//------------------------------------------------------------------------------
class ButtonFrame4 extends JFrame {

    public ButtonFrame4() {
        setTitle("Button Test");

        // size, position and icon
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(dim.width/4, dim.height/4);
        setLocation(new Point(dim.width/4, dim.height/4));

        Container c = getContentPane();
        JPanel centrePanel = new JPanel();

        // add panels
//        c.add(new ButtonPanel4(), "South");
//        c.add(new ButtonPanel5(), "South");
        c.add(new ButtonPanel6(), "South");
        c.add(centrePanel,"Center");
    }

//    public static void main(String args[]) {
//        JFrame frm = new ButtonFrame4();
//        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frm.setVisible(true);
//    }
}

class ButtonPanel4 extends JPanel {
    public ButtonPanel4() {
        // create buttons
        JButton greenButton = new JButton("Green");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        // add buttons to panel
        add(greenButton);
        add(blueButton);
        add(redButton);

        // create button actions
        ColorAction4 greenAction = new ColorAction4(Color.GREEN);
        ColorAction4 blueAction = new ColorAction4(Color.BLUE);
        ColorAction4 redAction = new ColorAction4(Color.RED);

        // associate actions to buttons
        greenButton.addActionListener(greenAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    class ColorAction4 implements ActionListener {
        private Color theColor;

        ColorAction4(Color col) {
            theColor = col;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            // long reference to method in ButtonPanel4
            // ButtonPanel4.this.setBackground(theColor);
            // short reference to method on ButtonPanel4
            setBackground(theColor);
        }
    }
}

class ButtonPanel5 extends JPanel {

    public ButtonPanel5() {
        makeButton("blue", Color.BLUE);
        makeButton("green", Color.GREEN);
        makeButton("red", Color.RED);
    }

    void makeButton(String name, final Color col) {
        JButton button = new JButton(name);
        add(button);
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        setBackground(col);
                    }
                }
        );
    }
}

class ButtonPanel6 extends JPanel {
    public ButtonPanel6() {
        makeButton("blue", new ImageIcon("blueball.gif"), Color.BLUE);
        makeButton("green", new ImageIcon("greenball.gif"), Color.GREEN);
        makeButton("red", new ImageIcon("redball.gif"), Color.RED);
    }

    void makeButton(String name, Icon icon, Color col) {
        JButton button = new JButton(new ColorAction6(name, icon, col));
        add(button);
    }

    private class ColorAction6 extends AbstractAction {
        public ColorAction6(String name, Icon icon, Color col) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue("color", col);
            putValue(Action.SHORT_DESCRIPTION,"Set panel color to "+name.toLowerCase());
        }

        public void actionPerformed(ActionEvent actionEvent) {
            setBackground((Color)getValue("color"));
            System.out.println(getValue(Action.SHORT_DESCRIPTION));
        }
    }
}