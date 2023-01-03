import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class point {
    int x;
    int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Shapes extends Applet implements ActionListener {
    int j = 80;
    int originX = 0;
    int originY = 0;
    Button B1, B2;

    public void init() {
        setBackground(Color.CYAN);
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
        g.setColor(Color.RED);
        g.drawLine(0, originY, getWidth(), originY);
        g.drawLine(originX, 0, originX, getHeight());

    }

    public void plotPoint(int x, int y, Color c, Graphics g) {
        originX = (getX() + getWidth()) / 2;
        originY = (getY() + getHeight()) / 2;
        Color temp = g.getColor();
        g.setColor(c);
        g.fillOval(originX + j * x - j / 2, originY - j * y - j / 2, j, j);
        g.setColor(temp);
    }

    public void midPointCircleDraw(Graphics g, int x_corr, int y_corr, int r) {
        int x = 0, y = r;
        double P = (double) 5 / 4 - r;
        while (x <= y) {
            plotPoint(x + x_corr, y + y_corr, Color.BLUE, g);
            plotPoint(-x + x_corr, y + y_corr, Color.BLUE, g);
            plotPoint(x + x_corr, -y + y_corr, Color.BLUE, g);
            plotPoint(-x + x_corr, -y + y_corr, Color.BLUE, g);
            plotPoint(y + x_corr, x + y_corr, Color.BLUE, g);
            plotPoint(-y + x_corr, x + y_corr, Color.BLUE, g);
            plotPoint(y + x_corr, -x + y_corr, Color.BLUE, g);
            plotPoint(-y + x_corr, -x + y_corr, Color.BLUE, g);
            x++;
            if (P <= 0)
                P = P + 2 * x + 1;
            else {
                y--;
                P = P + 2 * x - 2 * y + 1;
            }
            // if (y < x)
            // break;
        }
    }

    public void dda(point p1, point p2, Color c, Graphics g) {
        int x1 = p1.x, y1 = p1.y;
        int x2 = p2.x, y2 = p2.y;
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int steps = Math.max(dy, dx);
        double inx = dx / ((1.0) * steps), iny = dy / ((1.0) * steps);
        if (x2 < x1)
            inx *= -1;
        if (y2 < y1)
            iny *= -1;
        double x3 = x1, y3 = y1;
        for (int i = 0; i <= steps; i++) {
            int demo = (int) Math.round(x3);
            int demo1 = (int) Math.round(y3);
            plotPoint(demo, demo1, c, g);
            x3 = x3 + inx;
            y3 = y3 + iny;
        }
    }

    public void Ellipse(int rx, int ry, Color c, int sx, int sy, double angle, Graphics g) {
        double radians = Math.toRadians(angle);
        int x = 0, y = ry;
        double p = ry * ry + 0.25 * rx * rx - rx * rx * ry;
        while (2 * x * (ry * ry) < 2 * y * (rx * rx)) {
            plotPoint((int) (x * Math.cos(radians) - y * Math.sin(radians)) + sx,
                    (int) (x * Math.sin(radians) + y * Math.cos(radians)) + sy, c, g);
            plotPoint((int) ((-x) * Math.cos(radians) - y * Math.sin(radians)) + sx,
                    (int) ((-x) * Math.sin(radians) + y * Math.cos(radians)) + sy, c, g);
            plotPoint((int) (x * Math.cos(radians) - (-y) * Math.sin(radians)) + sx,
                    (int) ((x * Math.sin(radians) + (-y) * Math.cos(radians))) + sy, c, g);
            plotPoint((int) ((-x) * Math.cos(radians) - (-y) * Math.sin(radians)) + sx,
                    (int) ((-x) * Math.sin(radians) + (-y) * Math.cos(radians)) + sy, c, g);
            if (p < 0) {
                x += 1;
                p += 2 * ry * ry * x + ry * ry;
            } else {
                p += 2 * ry * ry * x + ry * ry - 2 * rx * rx * y;
                y -= 1;
                x += 1;
            }
        }

        double p2 = ry * ry * (x + 0.5) * (x + 0.5) + (y - 1) * (y - 1) * rx * rx - rx * rx * ry * ry;

        while (y >= 0) {
            plotPoint((int) (x * Math.cos(radians) - y * Math.sin(radians)) + sx,
                    (int) (x * Math.sin(radians) + y * Math.cos(radians)) + sy, c, g);
            plotPoint((int) ((-x) * Math.cos(radians) - y * Math.sin(radians)) + sx,
                    (int) ((-x) * Math.sin(radians) + y * Math.cos(radians)) + sy, c, g);
            plotPoint((int) (x * Math.cos(radians) - (-y) * Math.sin(radians)) + sx,
                    (int) ((x * Math.sin(radians) + (-y) * Math.cos(radians))) + sy, c, g);
            plotPoint((int) ((-x) * Math.cos(radians) - (-y) * Math.sin(radians)) + sx,
                    (int) ((-x) * Math.sin(radians) + (-y) * Math.cos(radians)) + sy, c, g);
            if (p2 < 0) {
                x += 1;
                y -= 1;
                p2 += 2 * ry * ry * x - 2 * rx * rx * y + rx * rx;
            } else {
                y -= 1;
                p2 += rx * rx - 2 * rx * rx * y;
            }
        }

    }

}