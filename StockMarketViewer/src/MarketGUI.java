import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// ========================================================================================= //
// ==========================           Main GUI Window           ========================== //
// ========================================================================================= //

public class MarketGUI extends JFrame implements ActionListener {
    // ********************************* MAIN ******************************** //
    public static void main(String[] args) {
        MarketGUI frm = new MarketGUI();
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.setVisible(true);
    }


    // ********************************************************************** //
    // ** Instant Field
    // ********************************************************************** //
    private JButton retrieve, quit;
    private JLabel start;
    private JLabel end;
    private JComboBox<String> tickerSymbol, startD, startM, startY, endD, endM, endY;


    // ********************************************************************** //
    // ** Constructor
    // ********************************************************************** //
    private MarketGUI() {
        // ========================================================
        // == setting
        // ========================================================
        setTitle("Stock Market Data Viewer");
        // size, position and icon
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(dim.width/2, dim.height/6);
        setLocation(new Point(dim.width/4, dim.height/4));

        // ========================================================
        // == container & initial
        // ========================================================
        Container c = getContentPane();
        JPanel p = new JPanel();
        // ------------ for south ------------ //
        this.quit = new JButton("Quit");
        this.retrieve = new JButton("Retrieve");
        // ------------ for north ------------ //
        JLabel ticker = new JLabel("Ticker Symbol: ");
        final String[] tickers = {"AAPL", "AMZN", "MSFT"};
        this.tickerSymbol = new JComboBox<>(tickers);
        // ------------ for center ------------ //
        this.start = new JLabel("Start Data (Y/M/D): ");
        this.end = new JLabel("End Data (Y/M/D): ");
        final String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
                "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
                "27", "28", "29", "30", "31"};
        this.startD = new JComboBox<>(days);
        this.endD = new JComboBox<>(days);
        final String[] months = {"01", "02", "03", "04", "05", "06",
                "07", "08", "09", "10", "11", "12"};
        this.startM = new JComboBox<>(months);
        this.endM = new JComboBox<>(months);
        String[] years = {"2017", "2018", "2019"};
        this.startY = new JComboBox<>(years);
        this.endY = new JComboBox<>(years);

        // ========================================================
        // == set south: quit button panel
        // ========================================================
        addJButton(p, this.retrieve); addJButton(p, this.quit);
        c.add(p, "South");

        // ========================================================
        // == set north: ticker selection panel
        // ========================================================
        p = new JPanel();
        p.add(ticker);
        addJComboBox(p, this.tickerSymbol);
        c.add(p, "North");


        // ========================================================
        // == set center: main/input panel
        // ========================================================
        p = new JPanel();
        GroupLayout layout = new GroupLayout(p);
        p.setLayout(layout);
        setGroupLayout(layout);
        c.add(p, "Center");
    }


    // ********************************************************************** //
    // ** Method for add Button and ComboBox
    // ********************************************************************** //
    private void addJButton(JPanel p, JButton button) {
        button.addActionListener(this);
        p.add(button);
    }

    private void addJComboBox(JPanel p, JComboBox comboBox) {
        comboBox.addActionListener(this);
        p.add(comboBox);
    }


    // ********************************************************************** //
    // ** Method for setting group layout in the center of JFrame
    // ********************************************************************** //
    private void setGroupLayout(GroupLayout layout) {
        // ------------ Setting gaps between components ------------ //
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // ------------ horizontal axis setting ------------ //
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.start)
                .addComponent(this.end));
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.startY)
                .addComponent(this.endY));
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.startM)
                .addComponent(this.endM));
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.startD)
                .addComponent(this.endD));
        layout.setHorizontalGroup(hGroup);

        // ------------ vertical axis setting ------------ //
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.start)
                .addComponent(this.startY)
                .addComponent(this.startM)
                .addComponent(this.startD));
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(this.end)
                .addComponent(this.endY)
                .addComponent(this.endM)
                .addComponent(this.endD));
        layout.setVerticalGroup(vGroup);
    }


    // ********************************************************************** //
    // ** Setting Interaction
    // ********************************************************************** //
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == this.retrieve) {
            String selectedTicker = (String)this.tickerSymbol.getSelectedItem();
            String start = String.format("%s/%s/%s",
                    this.startM.getSelectedItem(),
                    this.startD.getSelectedItem(),
                    this.startY.getSelectedItem());
            String end = String.format("%s/%s/%s",
                    this.endM.getSelectedItem(),
                    this.endD.getSelectedItem(),
                    this.endY.getSelectedItem());

            // ------------ check validation of date ------------ //
            DateFormat df = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
            try {
                df.parse(start);
                df.parse(end);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }

            // ================================================================================= //
            // ======================            Retrieve Data            ====================== //
            // ================================================================================= //
            RetrieveFromWSJ r = null;
            try {
                r = new RetrieveFromWSJ(selectedTicker, start, end);
            } catch (IOException e1) {
                e1.printStackTrace();       // <- to be continued
            }

            // ================================================================================= //
            // ======================             Plot Window             ====================== //
            // ================================================================================= //
            try {
                assert r != null;
                PlotGUI plt = new PlotGUI(r.getData(), selectedTicker);
                plt.setDefaultCloseOperation(EXIT_ON_CLOSE);
                plt.setVisible(true);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        } else if (source == this.quit) {
            System.exit(0);
        }
    }
}
