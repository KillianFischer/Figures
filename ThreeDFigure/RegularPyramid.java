package ThreeDFigure;

import TwoDFigure.Polygon;

public class RegularPyramid extends Pyramid<Polygon> {
    double height;
    double DihedralAngle;

    public RegularPyramid(double height, Polygon base) {
        super(height, base);
        this.baseShape = base;
    }

    public double getSlant() {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(baseShape.getCircumradius() * 0.5, 2));
    }

    public double getHeight() {
        // if height is undetermined
        height = baseShape.getCircumradius() * Math.tan(getDihedralAngle());
        return height;
    }

    public double getDihedralAngle() {
        DihedralAngle = Math.atan(baseShape.getCircumradius() / height);
        return DihedralAngle;
    }
}
