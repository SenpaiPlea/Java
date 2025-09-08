package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */
public class FileIODemo {
	
	/**
	 * While variable c does not reach the end of the file[-1], it will output each character to the console.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileReader fileIO = null;
		FileWriter fileOut = null;
		Scanner scannerIO = null;
		PrintWriter printOut = null;
		
		
		int c;
		
		try {
			fileIO = new FileReader("input.txt");
			fileOut = new FileWriter("output.txt");
			scannerIO = new Scanner(new FileInputStream("input.txt"));
			printOut = new PrintWriter(new FileOutputStream("printout.txt"));
			c =fileIO.read();
			while(c != -1) {
				System.out.print((char)c);
				fileOut.write(c);
				c = fileIO.read();
			}
			while(scannerIO.hasNext()) {
//				System.out.println(scannerIO.next());
				printOut.println(scannerIO.next());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		finally {
			fileIO.close();
			scannerIO.close();
			fileOut.close();
			printOut.close();
		}
		
	}
}
