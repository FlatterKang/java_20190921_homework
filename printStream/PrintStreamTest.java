package homework.printStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * This program try to store a String to a file
 * by using a redirect.
 * It can also return to the initial "System.out"
 * by remain "System.out" to a variable.
 */
public class PrintStreamTest {
	public static void main(String[] args) {
		PrintStream std_ps = System.out;
		try {
			System.setOut(new PrintStream("redirectStreamTestDemo.txt"));
			System.out.println("This Message is printed to \"printStreamTestDemo.txt\"");
			
			System.setOut(std_ps);
			System.out.println("This Message is printed to \"Console\"");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
