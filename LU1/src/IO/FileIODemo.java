package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		int c;
		
		try {
			fileIO = new FileReader("input.txt");
			c =fileIO.read();
			while(c != -1) {
				System.out.print((char)c);
				c = fileIO.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		finally {
			fileIO.close();
		}
		
	}
}
