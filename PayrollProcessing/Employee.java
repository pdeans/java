
/**
 * Employee Class
 * 
 * @author Patrick Stearns
 *
 */
public class Employee implements Comparable {
	private String firstName;
	private String lastName;
	private String gender;
	private int tenure;
	private String rate;
	private double salary;
	
	/**
	 * Employee class constructor
	 */
	public Employee()
	{
		firstName = "";
		lastName = "";
		gender = "";
		tenure = 0;
		rate = "";
		salary = 0.0;
	}
	
	/**
	 * Get Employee first name
	 * @return String firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Set Employee first name
	 * @param String s
	 */
	public void setFirstName(String s)
	{
		firstName = s;
	}
	
	/**
	 * Get Employee last name
	 * @return String lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Set Employee last name
	 * @param String s
	 */
	public void setLastName(String s)
	{
		lastName = s;
	}
	
	/**
	 * Get Employee gender
	 * @return String gender
	 */
	public String getGender()
	{
		return gender;
	}
	
	/**
	 * Set Employee gender
	 * @param String s
	 */
	public void setGender(String s)
	{
		gender = s;
	}
	
	/**
	 * Get Employee tenure
	 * @return int tenure
	 */
	public int getTenure()
	{
		return tenure;
	}
	
	/**
	 * Set Employee tenure
	 * @param int t
	 */
	public void setTenure(int t)
	{
		tenure = t;
	}
	
	/**
	 * Get Employee rate
	 * @return String rate
	 */
	public String getRate()
	{
		return rate;
	}
	
	/**
	 * Set Employee rate
	 * @param String s
	 */
	public void setRate(String s)
	{
		rate = s;
	}
	
	/**
	 * Get Employee salary
	 * @return double salary
	 */
	public double getSalary()
	{
		return salary;
	}
	
	/**
	 * Set Employee salary
	 * @param double s
	 */
	public void setSalary(double s)
	{
		salary = s;
	}
	
	/**
	 * Compare Object o to Employee object
	 * @return int 1 or 0 or -1
	 */
	public int compareTo(Object o)
    {
    	Employee e = new Employee();
    	e = (Employee)o;
    	
    	return lastName.compareTo(e.getLastName());
    }
}
