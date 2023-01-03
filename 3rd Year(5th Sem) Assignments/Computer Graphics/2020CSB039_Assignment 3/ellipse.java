import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ellipse extends Applet implements ActionListener {
    int j = 80;
    int originX = 0;
    int originY = 0;
    Button B1, B2;

    public void init() {
        setBackground(Color.yellow);
        originX = (getX() + getWidth()) / 2;
        originY = (getY() + getHeight()) / 2;
        B1 = new Button("zoomin");
        add(B1);
        B1.addActionListener(this);

        B2 = new Button("zoomout");
        add(B2);
        B2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B1) {
            if (j < 100) {
                j = j + 10;
                repaint();
            }
        } else {
            if (j > 10) {
                j = j - 10;
                repaint();
            }
        }
    }

    public void paint(Graphics g) {
        for (int i = originY; i >= 0; i -= j) {
            g.drawLine(0, i, getWidth(), i);
        }
        for (int i = originY; i <= getHeight(); i += j) {
            g.drawLine(0, i, getWidth(), i);
        }
        for (int i = originX; i >= 0; i -= j) {
            g.drawLine(i, 0, i, getHeight());
        }
        for (int i = originX; i <= getWidth(); i += j) {
            g.drawLine(i, 0, i, getHeight());
        }
        g.setColor(Color.BLUE);
        g.drawLine(0, originY, getWidth(), originY);
        g.drawLine(originX, 0, originX, getHeight());

        plotellipse(8, 6, Color.blue, g);

    }

    public void plotPoint(int x, int y, Color c, Graphics g) {
        originX = (getX() + getWidth()) / 2;
        originY = (getY() + getHeight()) / 2;
        Color temp = g.getColor();
        g.setColor(c);
        g.fillOval((originX + j * x - 15), (originY - j * y - 15), 30, 30);
        g.setColor(temp);
    }

    public void plotellipse(int r1, int r2, Color c, Graphics g) {
        int x = 0, y = r2;
        plotPoint(x, y, c, g);
        plotPoint(x, -y, c, g);

        int p = (r2 * r2) - (r1 * r1 * r2) + (1 / 4) * r1 * r1;
        for (x = 1; x <= y; x++) {
            if (p < 0) {
                p = p + 2 * r2 * r2 * x + r2 * r2;
            } else {
                y = y - 1;
                p = p + 2 * r2 * r2 * x - 2 * r1 * r1 * y + r2 * r2;
            }
            plotPoint(x, y, c, g);
            plotPoint(-x, y, c, g);
            plotPoint(x, -y, c, g);
            plotPoint(-x, -y, c, g);
        }
        x = x - 1;
        p = (r2 * r2 * (x + 1 / 2) * (x + 1 / 2)) + (r1 * r1 * (y - 1) * (y - 1)) - (r1 * r1 * r2 * r2);
        for (y = y - 1; y >= 0; y--) {
            if (p > 0) {
                p = p - (2 * r1 * r1 * y) + (r1 * r1);
            } else {
                x = x + 1;
                p = p + (2 * r2 * r2 * x) - (2 * r1 * r1 * y) + (r1 * r1);
            }
            plotPoint(x, y, c, g);
            plotPoint(-x, y, c, g);
            plotPoint(x, -y, c, g);
            plotPoint(-x, -y, c, g);
        }
    }
}
