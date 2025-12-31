package containerClass;

class RectangularContainer extends ContainerClass {
    private double width;
    private double length;

    public RectangularContainer(double height, double width, double length) {
        super(height);
        this.width = width;
        this.length = length;
    }

    @Override
    public double calcTopArea() {
        return width * length;
    }

    @Override
    public double calcTopPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return String.format("RectangularContainer: height=%.2f, width=%.2f, length=%.2f, Volume=%.2f, Surface Area=%.2f",
                height, width, length, calcVolume(), calcSurfaceArea());
    }
}