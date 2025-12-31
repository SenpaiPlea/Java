package sort2DArray;

import java.util.*;
import java.util.stream.*;


public class Sort2DArray {

	/*
	 * Use streams to write a program that displays the distinct numbers in the
	 * number array. Display the numbers in increasing order, separated by one
	 * space. Number array: {{34,89},{56,3},{27,61},{45,8},{45,89}}
	 */	
	

	
	
	public static void main(String[] args) {
		// 
		
		int[][] numbers = {
				{34,89},
				{56,3},
				{27,61},
				{45,8},
				{45,89}
			};
		
		
		Arrays.stream(numbers)
		.flatMapToInt(row ->
				Arrays.stream(row))
		.distinct()
		.sorted()
		.forEach(n ->
				System.out.println(n + " ")
				);
		
	}

}
