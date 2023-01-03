import java.awt.*;
import java.applet.*;
import java.awt.event.*;
  
public class Bresenhams extends Applet implements ActionListener
{
	int scale = 40;
	public void init()
	{
		setBackground(Color.yellow);
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
	
	public void bresenhams(double x1, double y1, double x2, double y2, Graphics g){
		double dx, dy, x, y, p;
		dx = x2 - x1;
		dy = y2 - y1; 
		x = x1;
		y = y1;
		
		double m = dy / dx;
		if(m <= 1){
			p = 2 * dy - dx;
			while(x <= x2){
				plot(x, y, 100, 100, 100, g);
				if(p >= 0){	
					y++;
					p += 2 * dy - 2 * dx;
				}
				else{
					p += 2 * dy;
				}
				x++;
			}
		}
		else{
			p = 2 * dx - dy;
			while(y <= y2){
				plot(x, y, 100, 100, 100, g);
				if(p >= 0){	
					x++;
					p += 2 * dx - 2 * dy;
				}
				else{
					p += 2 * dx;
				}
				y++;
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
			g.setColor(Color.RED);
			g.drawLine(i, 0, i, getHeight());
		}
		for(int i = scale; i <= getWidth(); i += scale){
			g.setColor(Color.RED);
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
		bresenhams(2, 2, 6, 10, g);
		bresenhams(-1, -1, 0, 0, g);



		
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
