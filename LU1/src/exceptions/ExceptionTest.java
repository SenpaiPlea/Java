package exceptions;

class MyException extends RuntimeException{
	String message;
	public MyException(String message) {
		this.message = message;
	}
	public String toString() {
		return message;
	}
}

public class ExceptionTest {

	public static void foobar() {
		int var1 = 1;
		int var2 = 0;
		try {
			System.out.println(var1/var2);
		} catch (Exception e) {
			System.out.println("Cannot divide by zero");
		}
		
	}
	
	public static void main(String[] args) {
		
		foobar();
		int var1 = 6;
		if (var1<10) {
			throw new MyException("The number is too small.");
		}
		
	}
	
	
	
	
	
}
