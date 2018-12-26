
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

// ========================================================================================= //
// ==========================             Plot Panel             =========================== //
// ========================================================================================= //

class PlotJPanel extends JPanel {
    // ********************************************************************** //
    // ** Instant Field
    // ********************************************************************** //
    // ------------ for constructor ------------ //
    private Boolean[] showOption;   // open, close, high, low, volume
    private HandleData h;

    // ------------ color setting ------------ //
    private Color gridColor = new Color(200, 200, 200, 150);

    // ------------ center and basis distance ------------ //
    private int xCentre;
    private int dX;
    private int dBlank;
    private int dPoint;

    // ------------ basis point setting ------------ //
    private int xOrigin, yOrigin, vOrigin;

    // ------------ scale setting ------------ //
    private double yBasis, vBasis, yScale;
    private int xScale;


    // ********************************************************************** //
    // ** Constructor
    // ********************************************************************** //
    PlotJPanel(HandleData h) {
        setBackground(Color.white);
        this.showOption = new Boolean[] {true, true, true, true, true};
        this.h = h;
    }


    // ********************************************************************** //
    // ** Method for Repaint Panel
    // ********************************************************************** //
    void setShowOption(Boolean[] showOption) {
        this.showOption = showOption;
        this.repaint();
    }


    // ********************************************************************** //
    // ** Method for Paint Panel
    // ********************************************************************** //
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.WHITE);


        // ========================================================
        // == Setting Parameters
        // ========================================================
        // ------------ center and basis distance ------------ //
        xCentre = this.getWidth() / 2;
        int yCentre = this.getHeight() / 2;
        int dY = (int) (yCentre / 1.2);
        dX = (int) (xCentre/1.2);
        int dV = (int) (yCentre / 2.4);
        int dLabel = 20;
        dBlank = 8;
        dPoint = 4;

        // ------------ basis point setting ------------ //
        xOrigin = xCentre - dX;
        yOrigin = yCentre + dV;
        vOrigin = yOrigin + dBlank + dLabel;

        // ------------ scale setting ------------ //
        ArrayList<MyDate> dates = this.h.getData();
        int nDate = dates.size();
        yBasis = Collections.min(this.h.getLow());
        vBasis = (int) (Collections.min(this.h.getVolume()) * 0.9);
        xScale = 2*dX / (nDate - 1);
        yScale = (dY + dV) / (Collections.<Double>max(this.h.getHigh()) - yBasis);
        float vScale = (float) (dV / (Collections.max(this.h.getVolume()) - vBasis));


        // ========================================================
        // == draw grid box
        // ========================================================
        g.setColor(Color.BLACK);
        g.drawRect(xCentre - dX - dBlank, yCentre - dY - dBlank,
                2*(dX + dBlank), dY + dV + 2*dBlank);
        // draw box for volume
        if (this.showOption[4]) {
            g.drawRect(xCentre - dX - dBlank, yCentre + dV + dBlank + dLabel,
                    2*(dX + dBlank), dV + dBlank);
        }


        // ========================================================
        // == Drawing grid line and scale for y axis
        // ========================================================
        int x1, y1;
        int dG = 6;
        // draw grid line and scale for main y axis
        int nY = 15;
        int yGridScale = (dY + dV) / (nY-1);
        this.drawYGrid(nY, dG, g, yGridScale, false);
        // draw grid line and scale for volume y axis
        if (this.showOption[4]) {
            nY = 5;
            yGridScale = (dV) / (nY - 1);
            this.drawYGrid(nY, dG, g, yGridScale, true);
        }


        // ========================================================
        // == Drawing grid line and scale for x axis
        // ========================================================
        MyDate currentDate;
        String currentYear = dates.get(0).getYear();
        for (int k = 0; k < nDate; k++) {
            x1 = xOrigin + k*xScale;
            y1 = yOrigin + dBlank;
            // ------------ draw scale line ------------ //
            g.setColor(Color.BLACK);
            if (k % 10 == 0) {
                g.drawLine(x1, y1, x1, y1 - dG);
            } else {
                g.drawLine(x1, y1, x1, y1 - dG/2);
            }
            // ------------ draw scale string ------------ //
            currentDate = dates.get(k);
            if (k == 0 ) {
                g.drawString(currentDate.getDate(),
                        x1 - (int)(1.4* dLabel), y1 + (int)(dLabel /1.6));
                currentYear = currentDate.getYear();
            } else {
                if (nDate < 21) {
                    g.drawString(currentDate.getDay(), x1 - (int)(0.4* dLabel), y1 + (int)(dLabel /1.6));
                } else if (nDate < 101) {
                    if (k % 7 == 0) {
                        if (!(currentDate.getYear().equals(currentYear))) {
                            g.drawString(currentDate.getDate(),
                                    x1 - (int)(1.4* dLabel), y1 + (int)(dLabel /1.6));
                            currentYear = currentDate.getYear();
                        } else {
                            g.drawString(currentDate.getMonth() + "/" + currentDate.getDay(),
                                    x1 - (int)(0.9* dLabel), y1 + (int)(dLabel /1.6));
                        }
                    }
                }
            }
            // ------------ draw grad line ------------ //
            g.setColor(gridColor);
            g.drawLine(x1, y1, x1, y1 - dV - dY - 2*dBlank);
        }


        // ========================================================
        // == Drawing Line Chart depending on boolean array
        // ========================================================
        int vLength, vWeight;
        ArrayList<Double> opens = this.h.getOpen();
        ArrayList<Double> closes = this.h.getClose();
        ArrayList<Double> highs = this.h.getHigh();
        ArrayList<Double> lows = this.h.getLow();
        ArrayList<Integer> volumes = this.h.getVolume();
        // ------------ color setting ------------ //
        Color lclose = new Color(200, 100, 100, 180);
        Color pclose = new Color(200, 100, 100, 250);
        Color lOpen = new Color(50, 50, 50, 180);
        Color pOpen = new Color(20, 20, 20, 250);
        Color lHigh = new Color(100, 200, 50, 180);
        Color pHigh = new Color(100, 200, 50, 250);
        Color lLow = new Color(50, 200, 200, 180);
        Color pLow = new Color(50, 200, 200, 250);
        Color fvolume = new Color(100, 100, 100, 180);
        for (int i = 1; i < nDate; i++) {
            // ------------ open ------------ //
            if (this.showOption[0]) this.drawLineChart(i, opens.get(i-1), opens.get(i), g, lOpen, pOpen);
            // ------------ for close ------------ //
            if (this.showOption[1]) this.drawLineChart(i, closes.get(i-1), closes.get(i), g, lclose, pclose);
            // ------------ for high ------------ //
            if (this.showOption[2]) this.drawLineChart(i, highs.get(i-1), highs.get(i), g, lHigh, pHigh);
            // ------------ for low ------------ //
            if (this.showOption[3]) this.drawLineChart(i, lows.get(i-1), lows.get(i), g, lLow, pLow);
            // ------------ for volume ------------ //
            if (this.showOption[4]) {
                g.setColor(fvolume);

                // ------------ points ------------ //
                x1 = xOrigin + xScale*i - dBlank - 1;
                y1 = vOrigin;
                vLength = (int)(vScale*(volumes.get(i) - vBasis));
                vWeight = 2*dBlank - 2;

                // ------------ draw ------------ //
                g.fillRect(x1, y1, vWeight, vLength);
                // the beginning case
                if (i == 1) {
                    x1 = xOrigin + xScale*(i-1) - dBlank - 1;
                    y1 = vOrigin;
                    vLength = (int)(vScale*(volumes.get(i-1) - vBasis));
                    vWeight = 2*dBlank - 2;
                    g.fillRect(x1, y1, vWeight, vLength);
                }
            }
        }
    }


    // ********************************************************************** //
    // ** Method for drawing grid line and scale for y axis
    // ********************************************************************** //
    private void drawYGrid(int nY, int dG, Graphics g, int yGridScale, Boolean ifV) {
        int x1, y1, yGrid, basis;
        String s;
        int dS;
        for (int i = 0; i < nY; i++) {
            // ------------ set parameters ------------ //
            x1 = xOrigin - dBlank;
            if (ifV) {
                y1 = vOrigin + i*yGridScale;
                yGrid = yGridScale;
                basis = (int) vBasis;
                dS = 70;
            } else {
                y1 = yOrigin - i*yGridScale;
                yGrid = -yGridScale;
                basis = (int) yBasis;
                dS = 30;
            }
            // ------------ draw scale line ------------ //
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1 + dG, y1);
            for (int j = 1; j < 10; j++) {
                if (i == nY-1) break;
                g.drawLine(x1, y1 + j*yGrid/10, xOrigin - dBlank + dG/2, y1 + j*yGrid/10);
            }
            // ------------ draw scale string ------------ //
            s = Integer.toString(yGridScale*i + basis);
            g.drawString(s, x1-dS, y1+dPoint);
            // ------------ draw grid line ------------ //
            g.setColor(this.gridColor);
            g.drawLine(x1, y1, xCentre + dX + dBlank, y1);
        }
    }


    // ********************************************************************** //
    // ** Method for drawing Line Chart
    // ********************************************************************** //
    private void drawLineChart(int i, Double d1, Double d2, Graphics g, Color line, Color point) {
        int x1, x2, y1, y2;

        // ------------ points ------------ //
        x1 = xOrigin + xScale*(i-1);
        y1 = (int)(yOrigin - yScale*(d1 - yBasis));
        x2 = xOrigin + xScale*i;
        y2 = (int)(yOrigin - yScale*(d2 - yBasis));

        // ------------ draw line ------------ //
        g.setColor(line);
        g.drawLine(x1, y1, x2, y2);

        // ------------ draw point ------------ //
        g.setColor(point);
        g.fillOval(x2 - dPoint/2, y2 - dPoint/2, dPoint, dPoint);
        // draw the first point
        if (i == 1) {
            g.fillOval(x1 - dPoint/2, y1 - dPoint/2, dPoint, dPoint);
        }
    }

}
