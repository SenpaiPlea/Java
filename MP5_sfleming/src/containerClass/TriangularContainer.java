package containerClass;

class TriangularContainer extends ContainerClass {
    private double sideA;
    private double sideB;
    private double sideC;

    public TriangularContainer(double height, double sideA, double sideB, double sideC) {
        super(height);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calcTopArea() {
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calcTopPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String toString() {
        return String.format("TriangularContainer: height=%.2f, sideA=%.2f, sideB=%.2f, sideC=%.2f, Volume=%.2f, Surface Area=%.2f",
                height, sideA, sideB, sideC, calcVolume(), calcSurfaceArea());
    }
}