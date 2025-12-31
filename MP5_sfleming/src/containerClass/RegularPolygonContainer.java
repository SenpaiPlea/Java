package containerClass;

class RegularPolygonContainer extends ContainerClass {
    private double side;
    private int numSides;

    public RegularPolygonContainer(double height, double side, int numSides) {
        super(height);
        this.side = side;
        this.numSides = numSides;
    }

    @Override
    public double calcTopArea() {
        return numSides * side * side / (4 * Math.tan(Math.PI / numSides));
    }

    @Override
    public double calcTopPerimeter() {
        return numSides * side;
    }

    @Override
    public String toString() {
        return String.format("RegularPolygonContainer: height=%.2f, side=%.2f, numSides=%d, Volume=%.2f, Surface Area=%.2f",
                height, side, numSides, calcVolume(), calcSurfaceArea());
    }
}