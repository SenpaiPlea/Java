package scrabbleScoreStats;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*In the problem you will use streams to calculate the three largest scrabble score in a list of
words, the average score, and display the words having scrabble score above and below the
average score. (Hint: it will be helpful to create a static method that accepts a word and returns
the Scrabble score for that word.)

List of words to be used: "Java", "program", "list", "string", "unix", "hours", "syntax", "error"
Your output should look like this:

Top three words are:
Java:18
syntax:16
program:12
Average scrabble value is: 10.125
words below average:[list, string, hours, error]
words above average:[Java, program, unix, syntax]
*/



public class ScrabbleScore {

	static Map<Character, Integer> letterValues = new HashMap(); 
	
	static {
	letterValues.put('a', 1);
	letterValues.put('b', 3);
	letterValues.put('c', 3);
	letterValues.put('d', 2);
	letterValues.put('e', 1);
	letterValues.put('f', 4);
	letterValues.put('g', 2);
	letterValues.put('h', 4);
	letterValues.put('i', 1);
	letterValues.put('j', 8);
	letterValues.put('k', 5);
	letterValues.put('l', 1);
	letterValues.put('m', 3);
	letterValues.put('n', 1);
	letterValues.put('o', 1);
	letterValues.put('p', 3);
	letterValues.put('q', 10);
	letterValues.put('r', 1);
	letterValues.put('s', 1);
	letterValues.put('t', 1);
	letterValues.put('u', 1);
	letterValues.put('v', 8);
	letterValues.put('w', 4);
	letterValues.put('x', 8);
	letterValues.put('y', 4);
	letterValues.put('z', 10);
	}
	
	static Map<String, Double> wordScores = new HashMap<>();
	
	static String[] words = {"java", "program", "list", "string", "unix", "hours", "syntax", "error"};
	
	public static double calculateWordScore(String word, Map<Character, Integer> letterValues) {
//		Break it into individual characters,
//		Look up each character’s score in the map,
//		Add up those scores to get the total for that word.
		
		double totalScore = 0;
		
		for(char c : word.toLowerCase().toCharArray()) {

			
			double score = letterValues.get(c);
			totalScore += score;
		}
		
		return totalScore;
	}
	
	
	public static void main(String[] args) {
		
		for(String word : words) {
			double total = calculateWordScore(word, letterValues);		
			wordScores.put(word, total);
		}
		
//		Find the highest-scoring word(s)
		wordScores.entrySet().stream()
			.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
			.limit(3)
			.forEach(entry ->
				System.out.println(entry.getKey() + ": " + entry.getValue())
					);
		
//		Calculate the average score
		OptionalDouble averageScoreOpt = wordScores.values().stream()
			.mapToDouble(Double::doubleValue)
			.average();
		System.out.println("The average word score is: " + averageScoreOpt.getAsDouble());
		
		double averageScore = averageScoreOpt.getAsDouble();
		
			
//		Filter and display words below average
		List<String> belowAverageWords = wordScores.entrySet().stream()
			.filter( entry -> 
				entry.getValue() < averageScore)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
		System.out.println("Words below average: " + belowAverageWords);
		
//		Filter and display words above average
		List<String> aboveAverageWords = wordScores.entrySet().stream()
				.filter( entry -> 
					entry.getValue() > averageScore)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
			System.out.println("Words above average: " + aboveAverageWords);

		
		

		
	}

	
	
	
}


