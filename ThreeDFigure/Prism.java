package ThreeDFigure;

import TwoDFigure.Shape2D;

public class Prism<T extends Shape2D> extends ThreeDShape {
    public double height;
    T base;

    public Prism(double height, T base) {
        this.height = height;
        this.base = base;
    }

    public double getVolume() {
        return base.getSurface() * height;
    }

    public double getSurfaceArea() {
        return (base.getCircumference() * height) + (2 * base.getSurface());
    }

    public double getDiagonal() {
        // Squire root (l^2 + b^2 + h^2)
        return Math.sqrt(Math.pow(base.getCircumference(), 2) + Math.pow(height, 2));
    }

    public double getHeight () {
        // if height is undetermined
        height = Math.sqrt(Math.pow(getDiagonal(), 2) - Math.pow(base.getCircumference(), 2));
        return height;
    }

    public double getCircumference() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not possible to calculate the circumference of a 3D object");
    }
    
    public double getSurface() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not possible to calculate the circumference of a 3D object");
    }
}
