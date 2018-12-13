package Week8;

import com.sun.tools.internal.xjc.reader.xmlschema.BGMBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameExample extends JFrame implements ActionListener {
    // ----------- instant field -----------
    private JButton button1, button2;
    private JLabel label;                             // a line of text or/and an icon
    private JTextField text;                          // input a line of text
    private JCheckBox checkItalic, checkBold;         // for yes/no (on/off) choices
    private JRadioButton orOne, orTwo, orThree;       // a set of alternatives, only one of which may be on
    private PicturePanel picPanel;

    // ----------- instant method -----------
    public JFrameExample() {
        setTitle("JFrame Example with Buttons by BorderLayout");
        setSize(300, 200);

        // get container
        Container contentPane = getContentPane();

        // add the components to contentPane using BorderLayout
        JPanel p = new JPanel();
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        addJButton(p, button1);
        addJButton(p, button2);
        contentPane.add(p, BorderLayout.NORTH);

        // add text field
        p = new JPanel();                           // the draft layout is BorderLayout
        label = new JLabel("Name: ");
        text = new JTextField("type name here", 16);
        p.add(label); p.add(text);
        text.addActionListener(this);
        contentPane.add(p, BorderLayout.SOUTH);

        // add check box with GridLayout
        p = new JPanel(new GridLayout(2, 1));
        checkBold = new JCheckBox("Bold");
        checkItalic = new JCheckBox("Italic");
        checkItalic.addActionListener(this);
        checkBold.addActionListener(this);
        p.add(checkBold); p.add(checkItalic);
        contentPane.add(p, "East");

        // add radio buttons with GridLayout
        p = new JPanel(new GridLayout(3, 1));
        ButtonGroup group = new ButtonGroup();
        orOne = addJRadioButton(p, "One", true, group, this);
        orTwo = addJRadioButton(p, "Two", false, group, this);
        orThree = addJRadioButton(p, "Three", false, group, this);
        contentPane.add(p, "West");

        // picturePanel is used to display action associated with components
        picPanel = new PicturePanel();
        contentPane.add(picPanel, "Center");
    }

    public void addJButton(JPanel p, JButton button) {
        button.addActionListener(this);
        p.add(button);
    }

    public JRadioButton addJRadioButton(JPanel p, String name, Boolean b, ButtonGroup group, JFrameExample jfe) {
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.setSelected(b);
        radioButton.addActionListener(this);
        group.add(radioButton);
        p.add(radioButton);
        return radioButton;
    }

    // ----------- stated method -----------

    // override method
    @Override
    public void actionPerformed(ActionEvent event) {
        String s;
        Object source = event.getSource();
        if (source == button1)
            picPanel.setDisplayString("but1 pressed");
        else if (source == button2)
            picPanel.setDisplayString("but2 pressed");
        else if (source == orOne)
            picPanel.setDisplayString("orOne pressed");
        else if (source == orTwo)
            picPanel.setDisplayString("orTwo pressed");
        else if (source == orThree)
            picPanel.setDisplayString("orThree pressed");
        else if (source == checkBold) {
            if (checkBold.isSelected()) s="true"; else s="false";
            picPanel.setDisplayString("checkBold selected: "+s);
        }
        else if (source == checkItalic) {
            if (checkItalic.isSelected()) s="true"; else s="false";
            picPanel.setDisplayString("checkItalic selected: "+s);
        }
        else if (source == text)
            picPanel.setDisplayString("text entered: "+text.getText());
    }


    public static void main(String[] args) {
        JFrameExample frm = new JFrameExample();
        // NECESSARY!
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate program when the window is closed
        frm.setVisible(true);  // must be called before the frame is displayed

    }
}

class PicturePanel extends JPanel {

    private String displayString = "";

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(displayString, 10, 20);
    }

    public void setDisplayString(String s) {
        displayString = s;
        repaint();
    }
}
