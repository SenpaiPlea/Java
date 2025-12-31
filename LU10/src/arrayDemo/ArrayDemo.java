package arrayDemo;

public class ArrayDemo {

	
	public static void main(String[] args) {
		
		double sum = 0;
		double average;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		
		int[] myArray = {1,2,3,4};
		int[] intArray;
		intArray = new int[5];
		System.out.println(intArray[0]);
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int) (Math.random()*20)+1;
		}
		

		for (int i : intArray) {
			System.out.println(i);
			sum += i;
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		
		average = (double)sum/intArray.length;
		System.out.println("sum is: "+ sum);
		System.out.println("average is: "+ average);
		System.out.println("max is: "+ max);
		System.out.println("min is: "+ min);
		
	}
	
	
}
