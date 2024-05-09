package TwoDFigure;

public class Rectangle extends Shape2D {
    private double height;
    private double width;

    public Rectangle (double h, double w) {
        this.height = h;
        this.width = w;
    }

    public double surface () {
        return this.height * this.width;
    }

    public double circumference () {
        return 2 * (this.height + this.width);
    }

    @Override
    public double getCircumference() {
        return circumference();
    }

    @Override
    public double getSurface() {
        return surface();
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