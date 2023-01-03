import java.awt.*;
import java.applet.*;
import java.awt.event.*;
  
public class midpoint extends Applet implements ActionListener
{
	int scale = 40;
	public void init()
	{
		setBackground(Color.YELLOW);
		Button b1 = new Button("Zoom In");   
		b1.setBackground(Color.WHITE);
		Button b2 = new Button("Zoom Out");
		b2.setBackground(Color.WHITE);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void plot(double x, double y, int r, int gr, int b, Graphics g){
		double newX = (getX() + getWidth()) / 2;
		double newY = (getY() + getHeight()) / 2;
		Color myColor = new Color(r, gr, b);
		g.setColor(myColor);
		g.fillOval((int)newX + (int)x * scale - (int)scale / 2, (int)newY - (int)y * scale - (int)scale / 2, (int)scale, (int)scale); 
	}
	
	public void midpoint (double X1, double Y1, double X2, double Y2, Graphics g) {
	    double dx = X2 - X1;
	    double dy = Y2 - Y1;
	    double d = dy - (dx / 2);
	    double x = X1, y = Y1;
	    plot(x, y, 100, 100, 100, g);
	    double m = dy / dx;
	    if(m <= 1){
		    while (x < X2)
		    {
			x++;
			if (d < 0)
			    d = d + dy;
			else
			{
			    d += (dy - dx);
			    y++;
			}
			plot(x, y, 100, 100, 100, g);
		    }
	    }
	    else{
		    while (y < Y2)
		    {
			y++;
			if (d < 0)
			    d = d + dx;
			else
			{
			    d += (dx - dy);
			    x++;
			}
			plot(x, y, 100, 100, 100, g);
		    }
	    }
	}

	public void paint(Graphics g)
	{
		int x = (getX() + getWidth()) / 2;
		int y = (getY() + getHeight()) / 2;
		g.setColor(Color.BLUE);
		g.drawLine(x, 0, x, getHeight());
		g.setColor(Color.BLUE);
		g.drawLine(0, y, getWidth(), y);
		for(int i = x + scale; i <= getWidth(); i += scale){
			g.setColor(Color.black);
			g.drawLine(i, 0, i, getHeight());
		}
		for(int i = scale; i <= getWidth(); i += scale){
			g.setColor(Color.black);
			g.drawLine(x - i, 0, x - i, getHeight());
		}
		for(int i = y + scale; i <= getHeight(); i += scale){
			g.setColor(Color.RED);
			g.drawLine(0, i, getWidth(), i);
		}
		for(int i = scale; i <= getHeight(); i += scale){
			g.setColor(Color.RED);
			g.drawLine(0, y - i, getWidth(), y - i);
		}
		midpoint(0, 2, 6, 10, g);
	}
	public void actionPerformed(ActionEvent e) {
		String st = e.getActionCommand();
		if(st.equals("Zoom Out"))
			scale = scale / 3;
		else
			scale = scale * 3;
		repaint();
	}
}
