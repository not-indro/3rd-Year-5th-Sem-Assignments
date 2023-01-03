import java.awt.*;

public class Parts extends Shapes {

    public void head(Graphics g, int x, int y, int r) {
        midPointCircleDraw(g, x, y, r);
    }

    // ----------------------------------------------------------------------------------------------------------------------------------
    public void eyes(Graphics g, int x, int y, int r) {
        midPointCircleDraw(g, x, y, r);
    }

    // ----------------------------------------------------------------------------------------------------------------------------------
    public void beak(Graphics g, int x, int y, int s, int t) {

        // beak size
        // s=0 -> small
        // s!=0 -> big
        if (s == 0) {
            // upper
            dda(new point(x, y), new point((x - 5), y), Color.GREEN, g);
            dda(new point(x, y), new point(x, (y + 3)), Color.GREEN, g);
            dda(new point(x, (y + 3)), new point((x - 5), y), Color.GREEN, g);

            // lower
            dda(new point(x, (y - 4)), new point((x - 4), (y - 4)), Color.GREEN, g);
            dda(new point(x, (y - 4)), new point(x, (y - 7)), Color.GREEN, g);
            dda(new point((x - 4), (y - 4)), new point(x, (y - 7)), Color.GREEN, g);
        } else {
            // upper
            dda(new point(x, y), new point((x - 8), y), Color.GREEN, g);
            dda(new point(x, y), new point(x, (y + 5)), Color.GREEN, g);
            dda(new point(x, (y + 5)), new point((x - 8), y), Color.GREEN, g);

            // lower
            dda(new point(x, (y - 4)), new point((x - 8), (y - 4)), Color.GREEN, g);
            dda(new point(x, (y - 4)), new point(x, (y - 9)), Color.GREEN, g);
            dda(new point((x - 8), (y - 4)), new point(x, (y - 9)), Color.GREEN, g);
        }

        // teeth -> t!=0
        if (t != 0) {
            if (s == 0) {
                // upper
                dda(new point(x, (y - 1)), new point((x - 4), (y - 1)), Color.WHITE, g);
                dda(new point(x, (y - 3)), new point((x - 4), (y - 3)), Color.WHITE, g);
            } else {
                dda(new point(x, (y - 1)), new point((x - 7), (y - 1)), Color.WHITE, g);
                dda(new point(x, (y - 3)), new point((x - 7), (y - 3)), Color.WHITE, g);
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------------------------
    public void ear(Graphics g, int x, int y, int s) {
        // ear shape
        // s=0 -> Circle
        // s!=0 -> Triangle
        if (s == 0) {
            midPointCircleDraw(g, x, y, 3);
        } else {
            dda(new point(x, (y + 3)), new point((x - 3), (y - 2)), Color.BLACK, g);
            dda(new point(x, (y + 3)), new point((x + 3), (y - 2)), Color.BLACK, g);
            dda(new point((x - 3), (y - 2)), new point((x + 3), (y - 2)), Color.BLACK, g);
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------

    public void body(Graphics g, int x, int y, int s, int h) {
        // spot
        // s=0 -> no spots
        // s!=0 -> spotted
        Ellipse(20, 10, Color.BLACK, x, y, -45, g);
        if (s != 0) {
            Ellipse(16, 9, Color.BLUE, x, y, -45, g);
            Ellipse(12, 7, Color.BLUE, x, y, -45, g);
            Ellipse(7, 4, Color.BLUE, x, y, -45, g);
            Ellipse(3, 2, Color.BLUE, x, y, -45, g);
        }

        // hair
        // h!=0 -> hair
        if (h != 0) {
            for (int i = 0; i < 26; i = i + 3) {
                dda(new point((x - 9 + i), (y + 16 - i)), new point((x - 6 + i), (y + 24 - i)), Color.YELLOW, g);
                dda(new point((x + 9 - i), (y - 16 + i)), new point((x + 6 - i), (y - 24 + i)), Color.YELLOW, g);
            }
            // dda(new point((x - 9), (y + 16)), new point((x - 8), (y + 18)), Color.WHITE,
            // g);
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------------------

    public void armsAndLegs(Graphics g, int x, int y, int sz, int sp, int h, int aol) {
        // size short, medium, long
        // sz=0 -> short
        // sz=1 -> medium
        // sz=2 -> long

        // short
        if (sz == 0) {
            midPointCircleDraw(g, x, y, 1);
        }

        // medium
        else if (sz == 1) {
            Ellipse(5, 3, Color.RED, x, y, 0, g);

            // If hairy -> h != 0
            if (h != 0) {
                for (int i = 0; i < 5; i = i + 3) {
                    dda(new point((x - 5 + i), (y + i)), new point((x - 5 + i), (y + 3 + i)), Color.YELLOW, g);
                    dda(new point((x + i), (y + 4 - i)), new point((x + i), (y + 7 - i)), Color.YELLOW, g);
                    dda(new point((x - 5 + i), (y - i)), new point((x - 5 + i), (y - 3 - i)), Color.YELLOW, g);
                    dda(new point((x + i), (y - 4 + i)), new point((x + i), (y - 7 + i)), Color.YELLOW, g);
                }
            }

            // If spotted -> sp != 0
            if (sp != 0) {
                Ellipse(4, 2, Color.RED, x, y, 0, g);
                Ellipse(2, 1, Color.RED, x, y, 0, g);
            }
        }

        // long
        // arms -> aol = 0
        // legs -> aol = 1
        else {

            // arms
            if (aol == 0) {
                Ellipse(8, 4, Color.BLACK, x, y, 0, g);
                Ellipse(8, 4, Color.BLACK, (x - 15), (y + 5), -30, g);
            }

            // legs
            else {
                Ellipse(8, 4, Color.BLACK, x, y, 90, g);
                Ellipse(8, 4, Color.BLACK, (x - 5), (y - 13), 60, g);

                // if spotted
                if (sp != 0) {
                    Ellipse(6, 3, Color.BLUE, x, y, 90, g);
                    Ellipse(6, 3, Color.BLUE, (x - 5), (y - 13), 60, g);
                    Ellipse(3, 1, Color.BLUE, x, y, 90, g);
                    Ellipse(3, 1, Color.BLUE, (x - 5), (y - 13), 60, g);
                }

                // if hairy
                if (h != 0) {
                    for (int i = 0; i < 8; i = i + 3) {
                        dda(new point((x - 6 + i), (y + i)), new point((x - 6 + i), (y + 4 + i)), Color.ORANGE, g);
                        dda(new point((x + i), (y + 5 - i)), new point((x + i), (y + 8 - i)), Color.ORANGE, g);
                        dda(new point((x - 6 + i), (y - i)), new point((x - 6 + i), (y - 4 - i)), Color.ORANGE, g);
                        dda(new point((x + i), (y - 5 + i)), new point((x + i), (y - 8 + i)), Color.ORANGE, g);

                        dda(new point((x - 11 + i), (y + i - 13)), new point((x - 11 + i), (y - 9 + i)), Color.ORANGE,
                                g);
                        dda(new point((x + i - 5), (y - 8 - i)), new point((x + i - 5), (y - 5 - i)), Color.ORANGE, g);
                        dda(new point((x - 11 + i), (y - i - 13)), new point((x - 11 + i), (y - 17 - i)), Color.ORANGE,
                                g);
                        dda(new point((x + i - 5), (y - 18 + i)), new point((x + i - 5), (y - 23 + i)), Color.ORANGE,
                                g);
                    }
                }
            }
        }
    }

    // ---------------------------------------------------------------------------------------------------------------------------------------

    public void tail(Graphics g, int x, int y, int s) {
        // s -> shape
        // s=0 -> circle
        // s=1 -> triangle
        // s=2 -> hairy
        if (s == 0) {
            midPointCircleDraw(g, x, y, 4);
        } else if (s == 1) {
            dda(new point((x - 3), y), new point((x + 2), (y - 5)), Color.RED, g);
            dda(new point((x + 10), (y + 10)), new point((x + 2), (y - 5)), Color.RED, g);
            dda(new point((x + 10), (y + 10)), new point((x - 3), y), Color.RED, g);
        } else {
            midPointCircleDraw(g, x, y, 4);
            midPointCircleDraw(g, x, y, 2);
            dda(new point((x), (y - 2)), new point((x), (y - 8)), Color.RED, g);
            dda(new point((x), (y + 2)), new point((x), (y + 8)), Color.RED, g);
            dda(new point((x + 3), (y - 2)), new point((x + 5), (y - 8)), Color.RED, g);
            dda(new point((x + 3), (y + 2)), new point((x + 5), (y + 8)), Color.RED, g);
            dda(new point((x + 4), (y - 2)), new point((x + 10), (y - 3)), Color.RED, g);
            dda(new point((x + 4), (y + 2)), new point((x + 10), (y + 3)), Color.RED, g);
            dda(new point((x + 5), (y)), new point((x + 11), (y)), Color.RED, g);
        }
    }
}