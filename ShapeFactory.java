import ThreeDFigure.*;
import TwoDFigure.*;

public class ShapeFactory {

    // Create a 3D shape based on the type and a 2D shape as a base
    public static ThreeDShape create3DShape(String type, Shape2D base, double height) {
        switch (type.toLowerCase()) {
            case "conepyramid":
                if (base instanceof Circle) {
                    return new ConePyramid((Circle) base, height);
                }
                throw new IllegalArgumentException("ConePyramid requires a Circle base");
            case "prism":
                // Assuming prisms can have various bases like rectangles and triangles
                if (base instanceof Rectangle || base instanceof Triangle) {
                    return new Prism<>(height, base);
                }
                throw new IllegalArgumentException("Prism requires a Rectangle or Triangle base");
            case "regularpyramid":
                if (base instanceof Polygon) {
                    return new RegularPyramid(height, (Polygon) base);
                }
                throw new IllegalArgumentException("RegularPyramid requires a Polygon base");
            case "pyramid":
                return new Pyramid<>(height, base);
            default:
                throw new IllegalArgumentException("Invalid shape type");
        }
    }

    // Create a 3D sphere
    public static Sphere createSphere(double radius) {
        Sphere sphere = new Sphere();
        sphere.setRadius(radius);
        return sphere;
    }
}