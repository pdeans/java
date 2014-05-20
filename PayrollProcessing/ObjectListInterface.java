
public interface ObjectListInterface {
	
	 /**
     * Return the first node in the list
     * @return list
     */
    public ObjectListNode getFirstNode();
    
    /**
     * Return the last node in the list
     * @return last
     */
    public ObjectListNode getLastNode();
    
    /**
     * Return the info of the first object in the list
     * @return list.getInfo()
     */
    public Object getFirst();
    
    /**
     * Return the info of the last object in the last
     * @return last.getInfo()
     */
    public Object getLast();
    
    /**
     * Add an object to the front of a list
     * @param Object o
     */
    public void addFirst(Object o);
    
    /**
     * Add a node to the front of the list
     * @param ObjectListNode p
     */
    public void addFirst(ObjectListNode p);
    
    /**
     * Add an object to the end of the list
     * @param Object o
     */
    public void addLast(Object o);
    
    /**
     * Add a node to the end of the list
     * @param ObjectListNode p
     */
    public void addLast(ObjectListNode p);
    
    /**
     * Removes the first object from the list
     * @return p.getInfo()
     */
    public Object removeFirst();
    
    /**
     * Removes the last object from the list
     * @return p.getInfo()
     */
    public Object removeLast();
    
    /**
     * Inserts an object after the node referenced by p
     * @param ObjectListnode p
     * @param Object o
     */
    public void insertAfter (ObjectListNode p, Object o);
    
    /**
     * Inserts a node after the node referenced by p
     * @param ObjectListNode p
     * @param ObjectListNode q
     */
    public void insertAfter(ObjectListNode p, ObjectListNode q);
    
    /**
     * Deletes the node after the node referenced by p
     * @param ObjectListNode p
     * @return q.getInfo()
     */
     public Object deleteAfter(ObjectListNode p);
     
     /**
      * Inserts an item into its correct location within an ordered list
      * @param Object o
      */
    public void insert(Object o);
    
    /**
     * Inserts a node into its correct location within an ordered list
     * @param ObjectListNode r
     */
    public void insert(ObjectListNode r);
    
    /**
     * Removes the first occurrence of an item in a list
     * @param Object o
     * @return varies
     */
    public Object remove(Object o);
    
    /**
     * Returns true if the item is found in the list
     * @param Object o
     * @return true or false
     */
    public boolean contains(Object o);
    
    /**
     * Returns a reference to the node with the requested value; returns null otherwise
     * @param Object o
     * @return varies
     */
    public ObjectListNode select(Object o);
    
    /**
     * Determines whether or not a list is empty
     * @return true or false
     */
    public boolean isEmpty();
    
    /**
     * Removes all elements from a list
     */
    public void clear();
    
    /**
     * Returns the number of elements in the list
     * @return int count
     */
    public int size();
    
    /**
     * Makes a copy of a list
     * @return ObjectList newList
     */
    public ObjectList copyList();
    
    /**
     * Reverses a list
     */
    public void reverse();
}
