package infixToPostfix;

/**
 * Object Stack Class
 * @author Patrick Stearns
 *
 */
public class ObjectStack implements ObjectStackInterface {
	
	private Object[] item;
	private int top;
	
	/**
	 * Constructor for Class Object Stack
	 */
	public ObjectStack()
	{
		item = new Object[1];
		top = -1;
	}
	
	/**
	 * Check if Object Stack is empty
	 * @return boolean - empty stack
	 */
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	/**
	 * Check if Object Stack is full
	 * @return boolean - stack is full
	 */
	public boolean isFull()
	{
		return top == item.length-1;
	}
	
	/**
	 * Clear Object Stack
	 */
	public void clear()
	{
		item = new Object[1];
		top = -1;
	}
	
	/**
	 * Add item to Object Stack
	 * @param Object - item to be added
	 */
	public void push(Object o)
	{
		if (isFull())
			resize(2 * item.length);
		item[++top] = o;
	}
	
	/**
	 * Remove item from Object Stack
	 * @return Object - item removed from stack
	 */
	public Object pop()
	{
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		Object temp = item[top];
		item[top--] = null;
		if (top == item.length/4)
			resize(item.length/2);
		
		return temp;
	}
	
	/**
	 * Top item in Object Stack
	 * @return Object - top stack item
	 */
	public Object top()
	{
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			System.exit(1);
		}
		
		return item[top];
	}
	
	/**
	 * Dynamically resize Object Stack
	 * @param int - size
	 */
	private void resize(int size)
	{
		Object[] temp = new Object[size];
		
		for (int i = 0; i <= top; i++) 
			temp[i] = item[i];
		
		item = temp;
	}
}
