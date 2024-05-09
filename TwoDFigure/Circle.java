package TwoDFigure;

import Error.NegativeValueException;

public class Circle extends Shape2D {

    private static final double pi = Math.PI;
    public double radius;

    public Circle(double radius) throws NegativeValueException {
        if (radius <= 0) {
            throw new NegativeValueException ("The radius must be a positive value.");
        }
        this.radius = radius;
    }

    public Circle(Circle original) {
        this.radius = original.radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius > 0) {
            this.radius = radius;
        } else
            throw new IllegalArgumentException("The radius must be positive.");
    }

    public double getRadius() {
        return this.radius;
    }

    public double getSurface() {
        return (pi * radius * radius);
    }

    public double getCircumference() {
        return (2 * pi * radius);
    }
}
