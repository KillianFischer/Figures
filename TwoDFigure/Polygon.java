package TwoDFigure;

import Error.NegativeValueException;

public class Polygon extends Shape2D {

    // This method is for any polygon with equal sides where n represents the amount
    // of sides
    private static final double pi = Math.PI;
    int n; // number of sides
    double s; // length of side

    public Polygon(int n, double s) throws NegativeValueException {
        if (n < 3)
            throw new IllegalArgumentException ("A polygon must have at least 3 sides");
            if (s <= 0)
            throw new NegativeValueException ("Side length cannot be negative or zero");
        this.n = n;
        this.s = s;
    }

    public double getSurface() {
        return (n * s * s) / (4 * Math.tan(pi / n));
    }

    public double getCircumference() {
        return (n * s);
    }

    public double getApothem() {
        // inscribed circle (apothem) in a regular polygon
        // apothem = circumradius * cos(pi/n)
        return s / (2 * Math.tan(180 / n));
    }

    public double getCircumradius() {
        // circumscribed circle (circumradius) in a regular polygon
        return s / (2 * Math.sin(pi / n));
    }

}
