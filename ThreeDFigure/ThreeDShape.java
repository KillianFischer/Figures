package ThreeDFigure;
import TwoDFigure.Shape2D;

public abstract class ThreeDShape extends Shape2D {
    protected double volume;
    protected double surfaceArea;

    public abstract double getVolume();

    public abstract double getSurfaceArea();
}
