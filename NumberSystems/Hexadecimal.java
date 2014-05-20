package numberSystemsLab;

import java.io.*;
import java.util.Scanner;

/**
 * Hexadecimal Class
 * @author Patrick Stearns
 *
 */
public class Hexadecimal {
	Scanner scan = new Scanner(System.in);
	private PrintWriter pw;
	private String hex;
	private String convert;
	
	/**
	 * Constructor for Hexadecimal Class
	 * @param PrintWriter variable
	 */
	public Hexadecimal(PrintWriter pw) {
		this.pw = pw;
	}
	
	/**
	 * Run methods to convert hexadecimal number to decimal and
	 * output the results
	 * @param none
	 * @return none
	 */
	public void hexToDec() {
		getHex();
		toDec();
		outDec();
	}
	
	/**
	 * Run methods to convert hexadecimal number to binary and
	 * output the results
	 * @param none
	 * @return none
	 */
	public void hexToBin() {
		getHex();
		toBin();
		outBin();
	}
	
	/**
	 * Input is run through a table of hex values and
	 * returns its decimal base 10 value
	 * @param hex digit to be examined
	 * @return returns decimal base 10 value of hex digit
	 */
	private int hexTable(char ch) {
		switch (ch) {
        case '0':
           return 0;
        case '1':
           return 1;
        case '2':
           return 2;
        case '3':
           return 3;
        case '4':
           return 4;
        case '5':
           return 5;
        case '6':
           return 6;
        case '7':
           return 7;
        case '8':
           return 8;
        case '9':
           return 9;
        case 'a':
        case 'A':
           return 10;
        case 'b':
        case 'B':
           return 11;
        case 'c':
        case 'C':
           return 12;
        case 'd':
        case 'D':
           return 13;
        case 'e':
        case 'E':
           return 14;
        case 'f':
        case 'F':
           return 15;
        default:
           return 0;
		}
	}
	
	/**
	 * Get hexadecimal value from user input
	 * @param none
	 * @return none
	 */
	private void getHex() {
		System.out.print("Please enter hexadecimal number to convert: ");
		hex = scan.next();
		
		this.pw.println("Please enter hexadecimal number to convert: " + hex);
	}
	
	/**
	 * Converts hexadecimal value to decimal
	 * @param none
	 * @return none
	 */
	private void toDec() {
		convert = "";
		int number = 0;
		int index = 0;
		
		for(int i=0; i < hex.length(); i++) {
			index = hexTable(hex.charAt(i));
			number = (number * 16) + index;
		}
		convert = String.valueOf(number);
	}
	
	/**
	 * Converts hexadecimal value to binary
	 * @param none
	 * @return none
	 */
	private void toBin() {
		convert = "";
		int number = 0;
		int mult = 0;
		int value = 0;
		int remainder = 0;
		
		for (int i=hex.length(); i>0; i--) {
			value = hexTable(hex.charAt(i-1));
			number += (value * Math.pow(16, mult));
			mult++;
		}
		do {
			remainder = number % 2;
			number /= 2;
			convert = remainder + convert;
		} while (number != 0);
	}
	
	/**
	 * Output hexadecimal to decimal conversion
	 * @param none
	 * @return none
	 */
	private void outDec() {
		System.out.println(hex + " to Decimal: " + convert);
		System.out.println();
		this.pw.println(hex + " to Decimal: " + convert);
		this.pw.println();
	}
	
	/**
	 * Output hexadecimal to binary conversion
	 * @param none
	 * @return none
	 */
	private void outBin() {
		System.out.println(hex + " to Binary: " + convert);
		System.out.println();
		this.pw.println(hex + " to Binary: " + convert);
		this.pw.println();
	}
}
