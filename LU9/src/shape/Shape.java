package shape;

public abstract class Shape {
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public double getRatio() {
		return getArea()/getPerimeter();
	}
	

	
	
	
	public static void main(String[] args) {
//		create 2 shape objects: 1 rectangle and 1 circle
//		display each ratio of area/perimeter
		
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(2);
		shapes[1] = new Rectangle(2, 3);
		
		System.out.println(shapes[1].getRatio());
		System.out.println(shapes[0].getRatio());
		
		
	}
	
	
	
	
}
