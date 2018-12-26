
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.ParseException;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

// ========================================================================================= //
// ==========================             Plot Window             ========================== //
// ========================================================================================= //

class PlotGUI extends JFrame implements ActionListener, ComponentListener {
    // ********************************************************************** //
    // ** Instant Field
    // ********************************************************************** //
    private JButton quit;
    private JCheckBox openBox, closeBox,highBox, lowBox, volumeBox;
    private PlotJPanel plotPanel;


    // ********************************************************************** //
    // ** Constructor
    // ********************************************************************** //
    PlotGUI(String data, String symbol) throws ParseException {
        HandleData h = new HandleData(data);

        // ========================================================
        // == setting
        // ========================================================
        setTitle("Stock Market Data Viewer - " + symbol);
        // size, position and icon
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize((int)(dim.width/1.1), (int)(dim.height/1.2));
        setLocation(new Point(dim.width/15, dim.height/10));

        // ========================================================
        // == container & initial
        // ========================================================
        Container c = getContentPane();
        JPanel p = new JPanel();
        // south
        this.quit = new JButton("back");
        // north
        JLabel options = new JLabel("Options: ");
        this.openBox = new JCheckBox("open (black)");
        this.closeBox = new JCheckBox("close (red)");
        this.highBox = new JCheckBox("high (green)");
        this.lowBox = new JCheckBox("low (blue)");
        this.volumeBox = new JCheckBox("volume");
        // center - plot
        this.plotPanel = new PlotJPanel(h);

        // ========================================================
        // == set south: quit button panel
        // ========================================================
        addJButton(p, this.quit);
        c.add(p, "South");

        // ========================================================
        // == set north: ticker selection panel
        // ========================================================
        p = new JPanel();
        p.add(options);
        addJCheckBox(p, openBox, true);
        addJCheckBox(p, closeBox, true);
        addJCheckBox(p, highBox, true);
        addJCheckBox(p, lowBox, true);
        addJCheckBox(p, volumeBox, true);
        c.add(p, "North");

        // ========================================================
        // == set center: main/input panel
        // ========================================================
        this.plotPanel.addComponentListener(this);
        c.add(this.plotPanel, BorderLayout.CENTER);
    }


    // ********************************************************************** //
    // ** Override Methods
    // ********************************************************************** //
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == this.quit) {
            this.setVisible(false);
        }
        else {
            Boolean[] b = {this.openBox.isSelected(), this.closeBox.isSelected(),
                    this.highBox.isSelected(), this.lowBox.isSelected(), this.volumeBox.isSelected()};
            this.plotPanel.setShowOption(b);
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        if (e.getSource() == this.plotPanel) {
            this.plotPanel.repaint();
        }
        // TODO Auto-generated method stub

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub
    }


    // ********************************************************************** //
    // ** Method for add Button and ComboBox
    // ********************************************************************** //
    private void addJButton(JPanel p, JButton button) {
        button.addActionListener(this);
        p.add(button);
    }

    private void addJCheckBox(JPanel p, JCheckBox cb, Boolean isSelected) {
        cb.setSelected(isSelected);
        cb.addActionListener(this);
        p.add(cb);
    }
}


