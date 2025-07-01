package exercicio5.areaGeometrica;

public record Rectangle(double width, double height ) implements GeometricForm {
    @Override
    public double getArea() {
        return height * width;
    }
}
