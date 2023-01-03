import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class candle extends Applet implements ActionListener, MouseWheelListener {
    int originX, originY;
    int height, width;
    int gap = 2;
    int kindle = 0;
    Button b1 = new Button(" Switch on ");
    Button b2 = new Button("Switch off ");

    public void init() {
        setBackground(new Color(255, 255, 255));
        b1.setBackground(new Color(31, 70, 144));
        b2.setBackground(new Color(255, 229, 180));
        add(b1);
        add(b2);
        addMouseWheelListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)
            kindle = 1;
        repaint();
        if (e.getSource() == b2)
            kindle = 0;
        repaint();
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        int z = e.getWheelRotation();
        zoom(z);
    }

    public void zoom(int i) {
        if (gap + i >= 2 && gap + i <= 50000) {
            gap += i;
            repaint();
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        height = getHeight();
        width = getWidth();
        originX = (getX() + width) / 2;
        originY = (getY() + height) / 2;

        g.setColor(Color.black);

        g.setColor(Color.blue);
        for (int i = -20; i < -1; i++) {
            DDALine(g, -2, i, 2, i, Color.blue);
        }
        if (kindle == 1) {

            for (int x = 2, y = 2; x <= 10 && y <= 8; x++, y += 2) {
                DDALine(g, 0, 0, x, y);
            }
            for (int x = 11, y = 10; x >= 0; x--, y += 2) {
                DDALine(g, 0, 0, x, y);
            }
            for (int x = -2, y = 2; x >= -10 && y <= 8; x--, y += 2) {
                DDALine(g, 0, 0, x, y);
            }
            for (int x = -11, y = 10; x <= 0; x++, y += 2) {
                DDALine(g, 0, 0, x, y);
            }
            animate();
        }
    }

    public void plotPoint(Graphics g, int x, int y, Color c) {
        g.setColor(c);
        g.fillOval(originX + (x * gap) - gap, originY - (y * gap) - gap, gap * 2, gap * 2);
    }

    public void plotPoint(Graphics g, int x, int y, Color c, int gap) {
        g.setColor(c);
        g.fillOval(originX + (x * gap) - gap, originY - (y * gap) - gap, gap * 2, gap * 2);
    }

    public void drawCandle(Graphics g, Color c) {
        for (int i = 10; i <= 500; i += 10) {
            DDALine(g, -30, -i, 30, -i, c);
        }
    }

    int round(float n) {
        if (n - (int) n < 0.5)
            return (int) n;
        return (int) (n + 1);
    }

    // function for line generation
    void DDALine(Graphics g, int x0, int y0, int x1, int y1) {

        // calculate dx and dy
        int dx = x1 - x0;
        int dy = y1 - y0;

        int step;

        // if dx > dy we will take step as dx
        // else we will take step as dy to draw the complete line
        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        // calculate x-increment and y-increment for each step
        float x_incr = (float) dx / step;
        float y_incr = (float) dy / step;

        // take the initial points as x and y
        float x = x0;
        float y = y0;

        for (int i = 0; i < step; i++) {
            // putpixel(round(x), round(y), WHITE);
            if (y < 10 && (x <= 2 && x >= -2)) {
                plotPoint(g, round(x), round(y), Color.red);
            } else
                plotPoint(g, round(x), round(y), Color.yellow);
            x += x_incr;
            y += y_incr;
            // delay(10);
        }
    }

    void DDALine(Graphics g, int x0, int y0, int x1, int y1, Color c) {

        // calculate dx and dy
        int dx = x1 - x0;
        int dy = y1 - y0;

        int step;

        // if dx > dy we will take step as dx
        // else we will take step as dy to draw the complete line
        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        // calculate x-increment and y-increment for each step
        float x_incr = (float) dx / step;
        float y_incr = (float) dy / step;

        // take the initial points as x and y
        float x = x0;
        float y = y0;

        for (int i = 0; i < step; i++) {
            // putpixel(round(x), round(y), WHITE);
            plotPoint(g, round(x), round(y), c, 10);
            x += x_incr;
            y += y_incr;
            // delay(10);
        }
    }

    public void animate() {
        // repaint();
    }
}
