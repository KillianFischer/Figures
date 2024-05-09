package ThreeDFigure;

public class Sphere {
    
    private double radius;


    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return 4.0/3.0 * Math.PI * Math.pow(this.radius, 3);
    }

    public double surface() {
        return 4.0 * Math.PI * Math.pow(this.radius, 2);
    }

}
