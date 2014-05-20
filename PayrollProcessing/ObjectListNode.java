
/**
 * Object List Node Class
 * 
 * @author Patrick Stearns
 */
public class ObjectListNode implements ObjectListNodeInterface {
	private Object info;
	private ObjectListNode next;
	
	/**
	 * Constructor for ObjectListNode
	 */
	public ObjectListNode()
	{
		info = null;
		next = null;
	}
	
	/**
	 * One argument constructor for ObjectListNode
	 * @param Object o
	 */
	public ObjectListNode(Object o)
	{
		info = o;
		next = null;
	}
	
	/**
	 * Two argument constructor for ObjectListNode
	 * @param Object o, ObjectListNode p
	 */
	public ObjectListNode(Object o, ObjectListNode p)
	{
		info = o;
		next = p;
	}
	
	/**
	 * Set the info field
	 */
	public void setInfo(Object o)
	{
		info = o;
	}
	
	/**
	 * Return object in info field
	 * @return info
	 */
	public Object getInfo()
	{
		return info;
	}
	
	/**
	 * Set next field
	 * @param ObjectListNode p
	 */
	public void setNext(ObjectListNode p)
	{
		next = p;
	}
	
	/**
	 * Return object in next info field
	 * @return next
	 */
	public Object getNext()
	{
		return next;
	}
}
