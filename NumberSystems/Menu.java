package numberSystemsLab;

import java.io.*;
import java.util.Scanner;

/**
 * Menu Class
 * @author Patrick Stearns
 *
 */
public class Menu {
	Scanner scan = new Scanner(System.in);
	private PrintWriter pw;
	private int choice;
	
	/**
	 * Constructor for Menu Class
	 * @param PrintWriter variable
	 */
	public Menu(PrintWriter pw) {
		this.pw = pw;
	}
	
	/**
	 * Displays menu for the Number Systems program
	 * @param none
	 * @return none
	 */
	public void display() {
		System.out.println("Number Systems Lab Menu");
		System.out.println("Convert decimal to binary - 1");
		System.out.println("Convert decimal to hexadecimal - 2");
		System.out.println("Convert binary to decimal - 3");
		System.out.println("Convert binary to hexadecimal - 4");
		System.out.println("Convert hexadecimal to decimal - 5");
		System.out.println("Convert hexadecimal to binary - 6");
		System.out.println("Exit Program - 7");
		System.out.print("Please enter choice: ");
		choice = scan.nextInt();
		
		this.pw.println("Number Systems Lab Menu");
		this.pw.println("Convert decimal to binary - 1");
		this.pw.println("Convert decimal to hexadecimal - 2");
		this.pw.println("Convert binary to decimal - 3");
		this.pw.println("Convert binary to hexadecimal - 4");
		this.pw.println("Convert hexadecimal to decimal - 5");
		this.pw.println("Convert hexadecimal to binary - 6");
		this.pw.println("Exit Program - 7");
		this.pw.println("Please enter choice: " + choice);
	}
	
	/**
	 * Returns the user's menu choice
	 * @param none
	 * @return the user's choice
	 */
	public int getSelection() {
		return choice;
	}
}
