package Figure2D;

public class n_corner {
    
    private double sideLength;
    private double sideNumber;

    public n_corner(double sideLength, double sideNumber) {
        this.sideLength = sideLength;
        this.sideNumber = sideNumber;
    }

    public double getSideLength() {
        return this.sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideNumber() {
        return this.sideNumber;
    }

    public void setSideNumber(double sideNumber) {
        this.sideNumber = sideNumber;
    }

    public double innerCircleRadius() {
        return this.sideLength / (2 * Math.tan(Math.PI / this.sideNumber));
    }
    
    public double outerCircleRadius() {
        return this.sideLength / (2 * Math.sin(Math.PI / this.sideNumber));
    }

}
