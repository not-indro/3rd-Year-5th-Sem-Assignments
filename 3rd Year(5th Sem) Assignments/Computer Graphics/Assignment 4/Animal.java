import java.awt.*;

public class Animal extends Parts {

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

        // head
        head(g, -8, 25, 8);
        // eyes
        eyes(g, -9, 27, 2);
        // beak
        beak(g, -14, 27, 1, 1);
        // ear
        ear(g, -2, 33, 1);
        // body
        body(g, 10, 5, 1, 1);
        // tail
        tail(g, 28, -3, 2);
        // leg 1
        armsAndLegs(g, 22, -18, 2, 1, 0, 1);
        // leg 2
        armsAndLegs(g, 11, -18, 2, 1, 0, 1);
        // Feet 1
        armsAndLegs(g, 0, -40, 1, 0, 0, 0);
        // Feet 2
        armsAndLegs(g, 15, -40, 1, 0, 0, 0);
        // toes 1
        armsAndLegs(g, -7, -40, 0, 0, 0, 0);
        armsAndLegs(g, -5, -43, 0, 0, 0, 0);
        armsAndLegs(g, -3, -45, 0, 0, 0, 0);
        // toes 2
        armsAndLegs(g, 8, -40, 0, 0, 0, 0);
        armsAndLegs(g, 10, -43, 0, 0, 0, 0);
        armsAndLegs(g, 12, -45, 0, 0, 0, 0);
        // arms 1
        armsAndLegs(g, -10, 10, 2, 0, 0, 0);
        // arms 2
        armsAndLegs(g, -8, 0, 2, 0, 0, 0);
        // hand 1
        armsAndLegs(g, -35, 18, 1, 0, 0, 0);
        // hand 2
        armsAndLegs(g, -35, 8, 1, 0, 0, 0);
        // fingers 1
        armsAndLegs(g, -42, 18, 0, 0, 0, 0);
        armsAndLegs(g, -40, 21, 0, 0, 0, 0);
        armsAndLegs(g, -40, 15, 0, 0, 0, 0);
        // fingers 2
        armsAndLegs(g, -42, 8, 0, 0, 0, 0);
        armsAndLegs(g, -40, 11, 0, 0, 0, 0);
        armsAndLegs(g, -40, 5, 0, 0, 0, 0);
    }
}