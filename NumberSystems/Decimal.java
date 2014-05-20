package numberSystemsLab;

import java.io.*;
import java.util.Scanner;

/**
 * Decimal Class
 * @author Patrick Stearns
 *
 */
public class Decimal {
	Scanner scan = new Scanner(System.in);
	private PrintWriter pw;
	private int decimal;
	private String convert;
	
	/**
	 * Constructor for Decimal Class
	 * @param PrintWriter variable
	 */
	public Decimal(PrintWriter pw) {
		this.pw = pw;
	}
	
	/**
	 * Run the methods to convert decimal number to binary and
	 * output the results
	 * @param none
	 * @return none
	 */
	public void decToBin() {
		getDec();
		toBin();
		outBin();
	}
	
	/**
	 * Run the methods to convert decimal number to hexadecimal and
	 * output the results	
	 * @param none
	 * @return none
	 */
	public void decToHex() {
		getDec();
		toHex();
		outHex();
	}
	
	/**
	 * Get decimal value from user input
	 * @param none
	 * @return none
	 */
	private void getDec() {
		System.out.print("Please enter decimal number to convert: ");
		decimal = scan.nextInt();
		
		this.pw.println("Please enter decimal number to convert: " + decimal);
	}
	
	/**
	 * Convert decimal value to binary
	 * @param none
	 * @return none
	 */
	private void toBin() {
		int number = decimal;
		convert = "";
		
		do {
			if (number % 2 == 0)
				convert = "0" + convert;
			else
				convert = "1" + convert;
			number /= 2;
		} while (number > 0);
	}
	
	/**
	 * Convert the decimal value to hexadecimal
	 * @param none
	 * @return none
	 */
	private void toHex() {
		convert = "";
		String hexTable = "0123456789ABCDEF";
		int number = decimal;
		int index;
		
		if (number == 0)
			convert = "0";
		while (number > 0) {
			index = number % 16;
			convert = hexTable.charAt(index) + convert;
			number /= 16;
		}
	}
	
	/**
	 * Output decimal to binary conversion
	 * @param none
	 * @return none
	 */
	private void outBin() {
		System.out.println(decimal + " to Binary: " + convert);
		System.out.println();
		this.pw.println(decimal + " to Binary: " + convert);
		this.pw.println();
	}
	
	/**
	 * Output decimal to hexadecimal conversion
	 * @param none
	 * @return none
	 */
	private void outHex() {
		System.out.println(decimal + " to Hexadecimal: " + convert);
		System.out.println();
		this.pw.println(decimal + " to Hexadecimal: " + convert);
		this.pw.println();
	}
}
