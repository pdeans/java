/**
 * Name: Patrick Stearns
 * Palomar ID: 006829974
 * CSCI 210 - Stegman
 * Infix To Postfix Lab
 */

package infixToPostfix;

import java.io.*;
import java.util.Scanner;

/**
 * 	Driver Class
 * @author Patrick Stearns
 *
 */
public class Driver {
	public static void main(String[] args) throws IOException {
		
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Scanner fileScan = new Scanner(new File("infix.txt"));
		int result;
		String post,
			   buf;
		InfixToPostfix conversion = new InfixToPostfix();
		EvalPostfix evaluation = new EvalPostfix();
		
		while (fileScan.hasNext()) 
		{
			buf = fileScan.nextLine();
			
			post = conversion.toPostfix(buf);
			result = evaluation.evaluatePostfix(post);
			
			// Output to terminal and output file
			System.out.println("Infix expression: " + buf);
			System.out.println("Postfix conversion: " + post);
			System.out.println("Postfix evaluation: " + result);
			pw.println("Infix expression: " + buf);
			pw.println("Postfix conversion: " + post);
			pw.println("Postfix evaluation: " + result);
			// Empty line for formatting
			pw.println();
		}
		
		fileScan.close();
		pw.close();
	}

}
