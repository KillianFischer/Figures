import ThreeDFigure.*;
import TwoDFigure.*;

public class Main {
    public static void main (String[] args) {
        Rectangle rectangle = new Rectangle(3, 3);
        Triangle triangle = new Triangle(2, 2, 2);

        System.out.println(rectangle.surface());
        System.out.println(triangle.surface());
    }
}
