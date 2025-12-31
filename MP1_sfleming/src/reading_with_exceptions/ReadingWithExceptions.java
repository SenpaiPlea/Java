package reading_with_exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



//public class ReadingWithExceptions implements Serializable {
//	private static final long serialVersionUID = 1L;
//	FileReader fileIO = null;
//	FileWriter fileOut = null;
//	Scanner scannerIO = null;
//	PrintWriter printOut = null;

	
		
//		ObjectOutputStream oos = null;
//		ObjectInputStream ois = null;
//		int numberToRead;
//		int counter = 0;
//		List<Integer> intList = new ArrayList<Integer>();
//		oos = new ObjectOutputStream(new FileOutputStream("objectOut.dat"));
//		ois = new ObjectInputStream(new FileInputStream("objectIn.dat"));
////		ois.readObject();
//		fileIO = new FileReader("inputFilename");
//		fileOut = new FileWriter("output.txt");
//		scannerIO = new Scanner(new FileInputStream("inputFilename"));
//		printOut = new PrintWriter(new FileOutputStream("printout.txt"));
////		c =fileIO.read();
//		String firstLine = scannerIO.nextLine();
//		String[] tokens;
//				
//			try {
//				
//				while (scannerIO.hasNextLine()) {
//					String line = scannerIO.nextLine();
//					tokens = firstLine.split(" ");
//					
//				numberToRead = Integer.parseInt(tokens[1]);
//				if(numberToRead < 0) {
//					System.out.println("Negative numbers are not allowed.");
//					numberToRead = -1; //to read everything
//					
//
//					
//				}
//			} catch (NumberFormatException e) {
//				// 
//				System.out.println("Invalid number formatting.");
//				numberToRead = -1; //to read everything
//				return;
//			}
//
//		
//			}
//		} 
//		catch (IOException e) {
//			// 
//			System.out.println("File not found or cannot be opened.");
//			return;
//		}
//		catch (Exception e2) {
//			// 
//			System.out.println("Null line.");
//			return;
//		}
//		
//		finally {
//			oos.close();
//			ois.close();
//			fileIO.close();
//			scannerIO.close();
//			fileOut.close();
//			printOut.close();
			
//		USED AI TO HELP CLEAN UP AND CONSOLIDATE MY INITIAL CODE FOR BETTER READABILITY. KEPT ORIGINAL CODE NOTES ABOVE
		
	import java.io.*;
	import java.util.*;

	public class ReadingWithExceptions {

	    public void process(String inputFilename) {
	        FileReader fileIO = null;
	        FileWriter fileOut = null;
	        Scanner scannerIO = null;
	        PrintWriter printOut = null;
	        List<Integer> intList = new ArrayList<>();
	        int numberToRead = -1; // default: read all
	        int counter = 0;

	        try {
	            // Open input file
	            fileIO = new FileReader(inputFilename);
	            scannerIO = new Scanner(new FileInputStream(inputFilename));

	            // Read first line and parse
	            if (!scannerIO.hasNextLine()) {
	                System.out.println("Error: input file is empty.");
	                return;
	            }

	            String firstLine = scannerIO.nextLine().trim();
	            String[] tokens = firstLine.split("\\s+");
	            if (tokens.length < 1) {
	                System.out.println("Error: missing output filename.");
	                return;
	            }

	            String outputFilename = tokens[0];

	            if (tokens.length >= 2) {
	                try {
	                    numberToRead = Integer.parseInt(tokens[1]);
	                    if (numberToRead < 0) {
	                        System.out.println("Warning: negative number count. Reading all numbers instead.");
	                        numberToRead = -1;
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Warning: invalid number format. Reading all numbers instead.");
	                    numberToRead = -1;
	                }
	            } else {
	                System.out.println("Warning: missing number count. Reading all numbers instead.");
	            }

	            // Read integers from file
	            while (scannerIO.hasNextLine()) {
	                String line = scannerIO.nextLine().trim();
	                if (line.isEmpty()) continue;

	                String[] lineTokens = line.split("\\s+");
	                for (String token : lineTokens) {
	                    try {
	                        int num = Integer.parseInt(token);
	                        intList.add(num);
	                        counter++;
	                        if (numberToRead > 0 && counter >= numberToRead) break;
	                    } catch (NumberFormatException e) {
	                        System.out.println("Skipping invalid number: " + token);
	                    }
	                }
	                if (numberToRead > 0 && counter >= numberToRead) break;
	            }

	            if (numberToRead > 0 && counter < numberToRead) {
	                System.out.println("Warning: fewer numbers in file than requested.");
	            }

	            // Write numbers to output file
	            fileOut = new FileWriter(outputFilename);
	            printOut = new PrintWriter(fileOut);

	            for (int i = 0; i < intList.size(); i++) {
	                printOut.print(intList.get(i) + " ");
	                if ((i + 1) % 10 == 0) printOut.println();
	            }
	            printOut.println(); // final newline
	            printOut.close();

	            // Print output file to screen
	            System.out.println(outputFilename + " created with the following output:");
	            Scanner outputScanner = new Scanner(new FileInputStream(outputFilename));
	            while (outputScanner.hasNextLine()) {
	                System.out.println(outputScanner.nextLine());
	            }
	            outputScanner.close();

	        } catch (IOException e) {
	            System.out.println("File not found or cannot be opened: " + inputFilename);
	        } finally {
	            try {
	                if (fileIO != null) fileIO.close();
	                if (scannerIO != null) scannerIO.close();
	                if (fileOut != null) fileOut.close();
	                if (printOut != null) printOut.close();
	            } catch (IOException e) {
	                System.out.println("Error closing file streams.");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        // Hardcoded list of filenames for testing
	        String[] inputFiles = {"file1.txt", "non-existent-file", "file2.txt", "file3.txt"};

	        ReadingWithExceptions rwe = new ReadingWithExceptions();

	        for (String filename : inputFiles) {
	            System.out.println("Processing file: " + filename);
	            rwe.process(filename);
	            System.out.println(); // extra line for readability between files
	        }
	    }
	}
