import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class test extends Applet implements ActionListener, MouseWheelListener

{
	int originX, originY;
	int height, width;
	int gap = 20;
	Button b1 = new Button(" + ");
	Button b2 = new Button(" - ");

	public void init() {
		setBackground(new Color(232, 249, 253));
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
			zoom(10);
		if (e.getSource() == b2)
			zoom(-10);
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		int z = e.getWheelRotation();
		zoom(z);
	}

	public void zoom(int i) {

		if (gap + i >= 5 && gap + i <= 300) {
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
		drawXaxis(g);
		drawYaxis(g);
		drawOriginCircle(g);

		drawHorizontalLines(g);
		drawVeritcalLines(g);
		plotPoint(g, 1, 1, Color.green);
		g.fillRect(originX + gap, originY + gap, gap, gap);
	}

	public void drawOriginCircle(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(originX - gap / 4, originY - gap / 4, gap / 2, gap / 2);
	}

	public void plotPoint(Graphics g, int x, int y, Color c) {
		g.setColor(c);
		g.fillOval(originX + (x * gap) - gap / 4, originY - (y * gap) - gap / 4, gap / 2, gap / 2);
	}

	public void drawXaxis(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, originY - 2, width, 4);
	}

	public void drawYaxis(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(originX - 2, 0, 4, height);
	}

	public void drawHorizontalLines(Graphics g) {
		g.setColor(Color.red);
		int xCord = 0;

		for (int i = originX; i <= width; i += gap, xCord++) {
			g.drawLine(i, 0, i, height);
			g.drawString(String.valueOf(xCord), i, originY + gap - gap / 4);

		}
		xCord = 0;
		for (int i = originX; i >= 0; i -= gap, xCord--) {
			g.drawLine(i, 0, i, height);
			g.drawString(String.valueOf(xCord), i, originY + gap - gap / 4);

		}
	}

	public void drawVeritcalLines(Graphics g) {
		g.setColor(Color.red);
		int yCord = 0;
		for (int i = originY; i <= height; i += gap, yCord--) {
			g.drawLine(0, i, width, i);
			// add coordinate text
			if (yCord != 0)
				g.drawString(String.valueOf(yCord), originX, i + gap - 5);
		}
		yCord = 0;
		for (int i = originY; i >= 0; i -= gap, yCord++) {
			g.drawLine(0, i, width, i);
			if (yCord != 0)
				g.drawString(String.valueOf(yCord), originX, i + gap - 5);

		}
	}

}