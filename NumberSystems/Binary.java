package numberSystemsLab;

import java.io.*;
import java.util.Scanner;

/**
 * Binary Class
 * @author Patrick Stearns
 *
 */
public class Binary {
	Scanner scan = new Scanner(System.in);
	private PrintWriter pw;
	private String binary;
	private String convert;
	
	/**
	 * Constructor for Binary Class
	 * @param PrintWriter variable
	 */
	public Binary(PrintWriter pw) {
		this.pw = pw;
	}
	
	/**
	 * Run methods to convert binary number to decimal and
	 * output the results
	 * @param none
	 * @return none
	 */
	public void binToDec() {
		getBin();
		toDec();
		outDec();
	}
	
	/**
	 * Run methods to convert binary number to hexadecimal and
	 * output the results
	 * @param none
	 * @return none
	 */
	public void binToHex() {
		getBin();
		toHex();
		outHex();
	}
	
	/**
	 * Get binary number from user input
	 * @param none
	 * @return none
	 */
	private void getBin() {
		System.out.print("Please enter binary number to convert: ");
		binary = scan.next();
		
		this.pw.println("Please enter binary number to convert: " + binary);
	}
	
	/**
	 * Convert binary value to decimal
	 * @param none
	 * @return none
	 */
	private void toDec() {
		int number = 0;
		convert = "";
		
		for (int i=0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				number += Math.pow(2, (binary.length()-1) - i);
			}
		}
		convert = String.valueOf(number);
	}
	
	/**
	 * Convert binary value to hexadecimal
	 * @param none
	 * @return none
	 */
	private void toHex() {
		convert = "";
		int number = 0;
		int mult = 0;
		int value;
		
		for (int i=binary.length(); i>0; i--) {
			value = Character.getNumericValue(binary.charAt(i-1));
			number += (value * Math.pow(2,mult));
			mult++;
		}
		
		do {
			value = number % 16;
			number /= 16;
			
			if(value == 10)
				convert = "A" + convert;
			else if (value == 11)
				convert = "B" + convert;
			else if (value == 12)
				convert = "C" + convert;
			else if (value == 13)
				convert = "D" + convert;
			else if (value == 14)
				convert = "E" + convert;
			else if (value == 15)
				convert = "F" + convert;
			else
				convert = value + convert;
		} while (number != 0);
	}
	
	/**
	 * Output results for binary to decimal conversion
	 * @param none
	 * @return none
	 */
	private void outDec() {
		System.out.println(binary + " to Decimal: " + convert);
		System.out.println();
		this.pw.println(binary + " to Decimal: " + convert);
		this.pw.println();
	}
	
	/**
	 * Output results for binary to hexadecimal conversion
	 * @param none
	 * @return none
	 */
	private void outHex() {
		System.out.println(binary + " to Hexadecimal: " + convert);
		System.out.println();
		this.pw.println(binary + " to Hexadecimal: " + convert);
		this.pw.println();
	}
}
