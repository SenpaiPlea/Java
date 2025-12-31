package countSingleDigits;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSingleDigits {

//	Using streams to write a program that generates 100 random integers between 0 and 9 and displays the count for each number
	


	
	
	public static void main(String[] args) {
		// 

		Random randomValues = new Random();
		IntStream intStream = randomValues.ints(100, 0, 10);
		
		Map<Integer, Long> occurrences = intStream
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		occurrences.entrySet().forEach(entry ->
				System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times")
				);
			
	}

}