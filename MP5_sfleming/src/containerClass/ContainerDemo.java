package containerClass;

public class ContainerDemo {
	public static void main(String[] args) {
		//ignore the syntax for array.
		//If you created the classes following the instruction your code should work.
		double totalSurfaceArea = 0;
		double totalVolume = 0;
		ContainerClass[] containers = new ContainerClass[8];
		containers[0] = new CircularContainer(10., 2.0); // height, radius
		containers[1] = new RectangularContainer(10., 2.0, 3.0); // height, width, length
		containers[2] = new TriangularContainer(10., 4.0, 3.0, 5.0); // height, sideA, sideB, sideC
		containers[3] = new RegularPolygonContainer(10., 1.0, 4); // height, side, numSides
		containers[4] = new CircularContainer(5., 2.0); // height, radius
		containers[5] = new RectangularContainer(5., 2.0, 3.0); // height, width, length
		containers[6] = new TriangularContainer(5., 4.0, 3.0, 5.0); // height, sideA, sideB, sideC
		containers[7] = new RegularPolygonContainer(5., 1.0, 4); // height, side, numSides

		for (ContainerClass container : containers) {
			System.out.println(container);
			System.out.println("surface area: "+container.calcSurfaceArea());
			System.out.println("volume: "+container.calcVolume());
			totalSurfaceArea+=container.calcSurfaceArea();
			totalVolume+=container.calcVolume();
			System.out.println("---------------------------------");
		}
		System.out.println("total surface area: " + totalSurfaceArea );
		System.out.println("total volume: " + totalVolume);
	}
}
