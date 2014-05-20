import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Payroll Class
 * 
 * @author Patrick Stearns
 *
 */
public class Payroll {
	Scanner fileScan;
	private PrintWriter pw;
	private String delims;
	private Employee e;
	private ObjectList o;
	
	/**
	 * Payroll class constructor
	 * @param PrintWriter pw
	 */
	public Payroll(PrintWriter pw)
	{
		this.pw = pw;
		delims = "[ ]+";
		o = new ObjectList();
	}
	
	/**
	 * Set employee list
	 */
	public void employees()
	{		
		try {
			fileScan = new Scanner(new File("payfile.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("file not found: payfile.txt");
		}
		
		while (fileScan.hasNext()) {
			String buf = fileScan.nextLine();
			String[] values = buf.split(delims);
			e = new Employee();
			e.setFirstName(values[0]);
			e.setLastName(values[1]);
			e.setGender(values[2]);
			e.setTenure(Integer.parseInt(values[3]));
			e.setRate(values[4]);
			e.setSalary(Double.parseDouble(values[5]));
			o.addLast(e);
		}
		fileScan.close();
	}
	
	/**
	 * Output employee list
	 */
	public void showEmployees()
	{	
		Employee e = new Employee();
		ObjectListNode p = o.getFirstNode();
		
		System.out.format("%12s%12s%7s%7s%5s%10s\n","First Name","Last Name","Gender","Tenure","Rate","Salary");
		System.out.format("%12s%12s%7s%7s%5s%10s\n","----------","---------","------","------","----","------");
		pw.format("%12s%12s%7s%7s%5s%10s\n","First Name","Last Name","Gender","Tenure","Rate","Salary");
		pw.format("%12s%12s%7s%7s%5s%10s\n","----------","---------","------","------","----","------");
		while (p != null) {
			e = (Employee)p.getInfo();
			System.out.format("%12s%12s%7s%7s%5s%10.2f\n",e.getFirstName(),e.getLastName(),e.getGender(),e.getTenure(),e.getRate(),e.getSalary());
			pw.format("%12s%12s%7s%7s%5s%10.2f\n",e.getFirstName(),e.getLastName(),e.getGender(),e.getTenure(),e.getRate(),e.getSalary());
			p = (ObjectListNode)p.getNext();
		}
	}
	
	/**
	 * Output number of employees
	 */
	public void employeeCount()
	{
		System.out.format("\nNumber of Employees: %d\n", o.size());
		pw.format("\nNumber of Employees: %d\n", o.size());
	}
	
	/**
	 * Output first names of all female employees
	 */
	public void showFemale()
	{
		Employee e = new Employee();
		ObjectListNode p = o.getFirstNode();
		
		System.out.println("\nWomen: ");
		pw.println("\nWomen: ");
		while (p != null) {
			e = (Employee)p.getInfo();
			if (e.getGender().equals("F")) {
				System.out.print(e.getFirstName()+" ");
				pw.print(e.getFirstName()+" ");
			}
			p = (ObjectListNode)p.getNext();
		}
		System.out.println();
		pw.println();
	}
	
	/**
	 * Output top employees (over $35,000 in salary and 5+ years of tenure)
	 */
	public void topEmployees()
	{
		Employee e = new Employee();
		ObjectListNode p = o.getFirstNode();
		
		System.out.println("\nTop Employees: ");
		pw.println("\nTop Employees: ");
		System.out.format("%12s%12s%10s\n","First Name","Last Name","Salary");
		pw.format("%12s%12s%10s\n","First Name","Last Name","Salary");
		System.out.format("%12s%12s%10s\n","----------","---------","------");
		pw.format("%12s%12s%10s\n","----------","---------","------");
		
		while (p != null) {
			e = (Employee)p.getInfo();
			if (e.getRate().equals("W") && (e.getSalary()*52) > 35000 && e.getTenure() >= 5) {
				System.out.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
				pw.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
			}
			p = (ObjectListNode)p.getNext();
		}
	}
	
	/**
	 * Output list of employees that received a raise
	 */
	public void raise()
	{
		Employee e = new Employee();
		ObjectListNode p = o.getFirstNode();
		
		System.out.println("\nRaises: ");
		pw.println("\nRaises: ");
		System.out.format("%12s%12s%10s\n","First Name","Last Name","Salary");
		pw.format("%12s%12s%10s\n","First Name","Last Name","Salary");
		System.out.format("%12s%12s%10s\n","----------","---------","------");
		pw.format("%12s%12s%10s\n","----------","---------","------");
		
		while (p != null) {
			e = (Employee)p.getInfo();
			if (e.getRate().equals("H") && e.getSalary() < 10.00) {
				e.setSalary(e.getSalary() + 0.75);
				System.out.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
				pw.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
			}
			if (e.getRate().equals("W") && e.getSalary() < 350.00) {
				e.setSalary(e.getSalary() + 50.00);
				System.out.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
				pw.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
			}
			p = (ObjectListNode)p.getNext();
		}
	}
	
	/**
	 * Sort list of employees into alphabetical order by last name
	 */
	public void sortList()
	{
		Employee e = new Employee();
		ObjectList l = new ObjectList();
		ObjectListNode p = o.getFirstNode();		
		
		while (p != null) {
			e = (Employee)o.removeFirst();
			l.insert(e);
			p = (ObjectListNode)p.getNext();
		}
		o = l.copyList();
		
		System.out.println("\nSorted: ");
		pw.println("\nSorted: ");
		System.out.format("%12s%12s%10s\n","First Name","Last Name","Salary");
		pw.format("%12s%12s%10s\n","First Name","Last Name","Salary");
		System.out.format("%12s%12s%10s\n","----------","---------","------");
		pw.format("%12s%12s%10s\n","----------","---------","------");
		
		p = o.getFirstNode();
		while (p != null) {
			e = (Employee)p.getInfo();
			System.out.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
			pw.format("%12s%12s%10.2f\n",e.getFirstName(),e.getLastName(),e.getSalary());
			p = (ObjectListNode)p.getNext();
		}
	}
	
	/**
	 * Output list of employees after new hirings
	 */
	public void hire()
	{
		try {
			fileScan = new Scanner(new File("hirefile.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("file not found: hirefile.txt");
		}
		while (fileScan.hasNext()) {
			String buf = fileScan.nextLine();
			String[] values = buf.split(delims);
			e = new Employee();
			e.setFirstName(values[0]);
			e.setLastName(values[1]);
			e.setGender(values[2]);
			e.setTenure(Integer.parseInt(values[3]));
			e.setRate(values[4]);
			e.setSalary(Double.parseDouble(values[5]));
			o.insert(e);
		}
		System.out.println("\nEmployee List After Hire: ");
		pw.println("\nEmployee List After Hire: ");
		System.out.format("%12s%12s\n","First Name","Last Name");
		pw.format("%12s%12s\n","First Name","Last Name");
		System.out.format("%12s%12s\n","----------","---------");
		pw.format("%12s%12s\n","----------","---------");
		
		ObjectListNode p = o.getFirstNode();
		while (p != null) {
			e = (Employee)p.getInfo();
			System.out.format("%12s%12s\n",e.getFirstName(),e.getLastName());
			pw.format("%12s%12s\n",e.getFirstName(),e.getLastName());
			p = (ObjectListNode)p.getNext();
		}
		fileScan.close();
	}
	
	/**
	 * Output list of employees after firings
	 */
	public void fire()
	{		
		try {
			fileScan = new Scanner(new File("firefile.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("file not found: firefile.txt");
		}
		
		while (fileScan.hasNext()) {
			String buf = fileScan.nextLine();
			String[] values = buf.split(delims);
			Employee emp = new Employee();
			emp.setFirstName(values[0]);
			emp.setLastName(values[1]);
			o.remove(emp);
		}
		System.out.println("\nEmployee List After Fire: ");
		pw.println("\nEmployee List After Fire: ");
		System.out.format("%12s%12s\n","First Name","Last Name");
		pw.format("%12s%12s\n","First Name","Last Name");
		System.out.format("%12s%12s\n","----------","---------");
		pw.format("%12s%12s\n","----------","---------");
		
		ObjectListNode p = o.getFirstNode();
		while (p != null) {
			e = (Employee)p.getInfo();
			System.out.format("%12s%12s\n",e.getFirstName(),e.getLastName());
			pw.format("%12s%12s\n",e.getFirstName(),e.getLastName());
			p = (ObjectListNode)p.getNext();
		}
		fileScan.close();
	}
}
