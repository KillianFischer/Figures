package Figure2D;

public class Rectangle {
    private double height;
    private double width;

    public Rectangle (double h, double w) {
        this.height = h;
        this.width = w;
    }

    public double surface () {
        return this.height * this.width;
    }

    public double perimeter () {
        return 2 * (this.height + this.width);
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}