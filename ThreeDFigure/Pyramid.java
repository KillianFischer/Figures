package ThreeDFigure;

import TwoDFigure.Shape2D;

/*  Das Lot von der Spitze endet im Mittelpunkt 
und bildet einen rechten Winkel zu Grundfläche. */

public class Pyramid<T extends Shape2D> extends ThreeDShape {
    double height;
    T baseShape;

    public Pyramid(double height, T base) {
        this.height = height;
        this.baseShape = base;
    }

    public double getVolume() {
        return baseShape.getSurface() * height * (1.0 / 3.0);
    }

    public double getSurfaceArea() {
        return baseShape.getSurface() + getSlantSurface();
    }

    public double getSlant() {
        // normal pyramid slant calculation
        return Math.sqrt(Math.pow(baseShape.getCircumference() * 0.5, 2) + Math.pow(height, 2));
    }

    public double getSlantSurface() {
        // The Lateral Surface Area of pyramid (LSA) = (1/2) Pl
        return (baseShape.getCircumference() * 0.5) * getSlant();
    }

    public double getHeight() {
        // if height is undetermined
        height = Math.sqrt(Math.pow(getSlant(), 2) - Math.pow(baseShape.getCircumference() * 0.5, 2));
        return height;
    }

    public double getCircumference() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not possible to calculate the circumference of the 3D object");
    }

    public double getSurface() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not possible to calculate the circumference of the 3D object");
    }
}
