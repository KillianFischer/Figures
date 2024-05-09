package ThreeDFigure;

import TwoDFigure.Circle;

public class ConePyramid extends Pyramid<Circle> {
    public double height;

    public ConePyramid(Circle base, double height) {
        super(height, base);
    }

    public double getSurfaceArea() {
        // Total Surface Area, TSA of cone = πr(r + l)
        return baseShape.getSurface() + getCurvedSlantSurface();
    }

    @Override
    public double getSlant() {
        // calculate the slant of a cone
        return Math.sqrt(Math.pow(baseShape.radius, 2) + Math.pow(height, 2));
    }

    public double getCurvedSlantSurface() {
        // Curved Surface Area, CSA of cone = πrl
        return baseShape.radius * Math.PI * getSlant();
    }

    public double getHeight() {
        // if height is undetermined
        height = Math.sqrt(Math.pow(getSlant(), 2) - Math.pow(baseShape.radius, 2));
        return height;
    }
}