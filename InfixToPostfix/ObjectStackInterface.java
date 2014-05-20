package infixToPostfix;

/**
 * Interface for Object Stack Class
 * @author Patrick Stearns
 *
 */
public interface ObjectStackInterface {
	
	/**
	 * Interface for object stack isEmpty() method
	 * @return boolean - empty stack
	 */
	public boolean isEmpty();
	
	/**
	 * Interface for object stack isFull() method
	 * @return boolean - full stack
	 */
	public boolean isFull();
	
	/**
	 * Interface for object stack clear() method
	 */
	public void clear();
	
	/**
	 * Interface for object stack push() method
	 * @param Object - object to be added to stack
	 */
	public void push(Object o);
	
	/**
	 * Interface for object stack pop() method
	 * @return Object - remove object from stack
	 */
	public Object pop();
	
	/**
	 * Interface for object stack top() method
	 * @return Object - top of stack
	 */
	public Object top();
}
