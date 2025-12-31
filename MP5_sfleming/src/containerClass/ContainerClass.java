package containerClass;

public abstract class ContainerClass {

	protected double height;
	
	public ContainerClass(double height) {
	    this.height = height;
	}

	public abstract double calcTopArea();
	public abstract double calcTopPerimeter();

	public double calcVolume() {
	    return height * calcTopArea();
	}

	public double calcSurfaceArea() {
	    return 2 * calcTopArea() + height * calcTopPerimeter();
	}

	
}

