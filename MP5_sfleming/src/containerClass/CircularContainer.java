package containerClass;

public class CircularContainer extends ContainerClass {
	
	private double radius;

	public CircularContainer(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	@Override
	public double calcTopArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double calcTopPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
    public String toString() {
        return String.format("CircularContainer: height=%.2f, radius=%.2f, Volume=%.2f, Surface Area=%.2f", height, radius, calcVolume(), calcSurfaceArea());
	}
	
}

