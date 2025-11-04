package stackIndentationChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/*In this problem, you will create a program that can read in a series of files
which are passed in as command line arguments. Your program will read
through these files and generate listings with line numbers. While generating
the listings your program will check for the correctness of the indentation used
in the program using a "stack" algorithm. When improper indentation is found,
your program will stop processing this file and move onto the next file.
Here are the rules for proper indentation:
1. completely blank lines are ignored.
2. the only thing we are looking at is the column number of the first non-
blank character. We don't care about the actual text on the line or what
the first character is ... it can be: if, {, for, etc. and it just doesn't matter.
3. When a line of text is indented, we don't care how many spaces it is
indented ... i.e. 1, 3, 4, 8, etc. is just fine
4. When a line of text is indented less than the previous line, the column
number must match the column number of a previous line which is still
"in play". The following text will attempt to clarify the rules:*/

/*So when you run your program, you will be using the command line
arguments of:
properlyIndented.txt properlyIndented2.txt notIndentedProperly.txt
notIndentedProperly2.txt notIndentedProperly3.txt*/



class BadIndentationException extends RuntimeException {
	BadIndentationException(String error)
	{
		super(error);
	}
}

public class IndentChecker {
	Stack<Integer> indentStack = new Stack<Integer>();
	

	
	private int findFirstNonBlank(String line)
	{
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(!Character.isWhitespace(c)) {
				return i;
			}
		}
		return -1;
		// return index of first non-blank character
		// return -1 if the line doesn't contain a non-
		//blank character
	}
	private void processLine(String line, int lineNumber)
	{
		int index = findFirstNonBlank(line);

		
		if(index == -1) {
			return;
		}
		
		if(indentStack.isEmpty()){
			indentStack.push(index);
			return;
		}
		
		int top = indentStack.peek();
		
		if(index > top) {
			indentStack.push(index);
			return;
		}
		
		while(!indentStack.isEmpty() && indentStack.peek() > index) {
			indentStack.pop();
		}
		
		if(indentStack.isEmpty() || indentStack.peek() != index) {
			throw new BadIndentationException(
					"Bad indendation at line: " + lineNumber + ": oolumn: " + index
					);
		}
		// Skip blank lines ... i.e. return immediately
		// If the stack is empty, then push this index
		//onto the stack and return
		// If this index > than the top of the stack, then
		//push this index onto the stack and return
		// Pop off all Indentation indexes > index
		// At his point the top of the stack should match
		//the current index. If it
		// doesn't throw a BadIndentationException. In
		//the error message, include the source Line Number
	}
	public void checkIndentation(String fileName)
	{
		// Clear the stack
		indentStack.clear();
		Scanner input = null;
		
		try {
			input = new Scanner (new File(fileName));
			int lineNumber = 1;
			while(input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(lineNumber+" : "+line);
				processLine(line, lineNumber);
				lineNumber += 1;
			}
			
			System.out.println(fileName +" has proper indentation");
			// read through the file line by line
			// for each line, call processLine to check indentation
		}
		catch (BadIndentationException error)
		{
			System.out.println(error.getMessage());
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Can't open file: " + fileName);
		}
		finally
		{
			if (input != null)
				input.close();
		}
	}

	public static void main(String[] args) {
		IndentChecker indentChecker = new IndentChecker();
		for (int i=0; i < args.length; i++)
		{
			System.out.println("Processing file: " + args[i]);
			indentChecker.checkIndentation(args[i]);
		}
	}
}