
/**
 * Interface for Object List Node Class
 * 
 * @author Patrick Stearns
 */
public interface ObjectListNodeInterface {
	
	/**
	 * Set the info field
	 */
	public void setInfo(Object o);
	
	/**
	 * Return object in info field
	 * @return info
	 */
	public Object getInfo();
	
	/**
	 * Set next field
	 * @param ObjectListNode p
	 */
	public void setNext(ObjectListNode p);
	
	/**
	 * Return object in next info field
	 * @return next
	 */
	public Object getNext();
}
