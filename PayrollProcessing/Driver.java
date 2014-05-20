/**
 * Name: Patrick Stearns
 *
 * Payroll Processing Simulator
 */

import java.io.*;

/**
 * Driver class for Payroll Processing Simulator
 * @author Patrick Stearns
 *
 */
public class Driver {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
		Payroll payroll = new Payroll(pw);

		payroll.employees();
		payroll.showEmployees();
		payroll.employeeCount();
		payroll.showFemale();
		payroll.topEmployees();
		payroll.raise();
		payroll.sortList();
		payroll.hire();
		payroll.fire();

		pw.close();
	}

}
