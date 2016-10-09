
/** An instance is a doubly linked list. It provides much of the functionality of
 * Java class java.util.LinkedList.
 * It extends class java.util.AbstractList, which just means that it must override
 * certain methods. */

public class DLinkedList<E> extends java.util.AbstractList<E> {
    private int size;  // Number of nodes in the linked list.
    private Node head; // first node of the linked list (null if none)
    private Node tail; // last node of the linked list (null if none)

    /** Constructor: an empty linked list. */
    public DLinkedList() {
      
    	head = null;
    	tail = null;
    	size = 0;
    	
    }

    /** Return the head Node of this linked list */
    Node getHead() {// no access modifier. Accessible (only) in package
        return head;
    }

    /** Return the tail Node of this linked list */
    Node getTail() {// no access modifier. Accessible (only) in package
        return tail;
    }

    /** Return the number of elements in this list.
     * This operation must take constant time. */
    public @Override int size() {
       
        return size;
    }

    /** Return the elements of this list, in order, separated by ", " (comma blank),
     * and delimited by [ and ]. Elements e are turned into Strings using String
     * catenation. Thus, if e is null, the String "null" is automatically used. */
    public @Override String toString()
    {
        String res= "[";
        Node n= head;
        // invariant: all elements before n (or all if n is null) have been
        //      added to res, with ", " between them and with "[" in the beginning
        while (n != null) {
            if (res.length() > 1)
            	res= res + ", ";
            res= res + n.data;
            n= n.succ;
        }
        return res + "]";
    }

    /** Return a representation of this list: its values in reverse order, with
     * adjacent ones separated by ", " (comma blank), with "[" at the beginning,
     * and with "]" at the end. <br/>
     *
     * E.g. for the list containing 6 3 8 in that order, the result is "[8, 3, 6]".
     *
     * To add values to a list, use String catenation as in toString above. */
    public String toStringRev()
    {
    	String res= "[";
        Node n= tail;
        while (n != null) {
            if (res.length() > 1)
            	res= res + ", ";
            res= res + n.data;
            n= n.pred;
        }
        return res + "]";
    }
    

    /** Place element in a new node at the end of the list and return the new node.
     * This operation must take constant time. */
    Node append(E element) {// no access modifier. Accessible (only) in package

    	if (size == 0)
    	{
        	tail = new Node (null, element, null);
        	head = tail;
        	size = size + 1;
        	return tail;
        }
    	if (size == 1)
    	{
    		tail = new Node (head, element, null);
    		head.succ = tail;
    		size = size + 1;
    		return tail;
    	}
    	Node n = new Node (tail,element, null);
    	tail.succ = n;
    	tail = n;
    	size = size + 1;
    	return n;
    }

    /** Append element to the end of this list and return true. */
    public @Override boolean add(E element) {
        
    	this.append(element);
        return true;
    }

    /** Return Node number h of this list
     * (the first node is number 0, the second is number 1, etc.)
     * Throw an IndexOutOfBoundsException if h < 0 or h >= size of the list.
     * This method should take time proportional to min(h, size - h). */
    Node getNode(int h) {// no access modifier. Accessible (only) in package
       
        if (h < 0 || h >= size )
        {
        	throw new IndexOutOfBoundsException();
        	
        }
        else if (h > size/2)
        {
        	Node n = tail;
        	for (int i = size - 1; i > h; i--)
        	{
        		n = n.pred;
        	}
        	return n;
        }
        else
        {
        	Node n = head;
        	for (int i = 0; i < h; i++)
        	{
        		n = n.succ;
        	}
        	return n;
        }
        	
    	
    }

    /** Return element number h of this list.
     * (The first element is number 0, the second is number 1, etc.)
     * Throw an IndexOutOfBoundsException if h < 0 or h >= size of the list.
     * The time taken should be proportional to min(h, size - h).*/
    public @Override E get(int h) {
        
    	Node n = this.getNode(h);
    	return n.data;
    }

    /** Replace element number h of this list by e.
     * (The first element is number 0, the second is number 1, etc.)
     * Return the value that was previously element number h.
     * Throw an IndexOutOfBoundsException if h < 0 or h >= size of the list.
     * The time taken should be proportional to min(h, size - h). */
    public @Override E set(int h, E element) {
        
    	Node n = this.getNode(h);
    	E oldElement = n.data;
    	n.data = element;
    	return oldElement;
    }

    /** Insert element in a new node at the beginning of the list and
     * return the new node.
     * This operation must take constant time. */
    Node prepend(E element) {// no access modifier. Accessible (only) in package
        
        Node n = new Node(null, element, head);
        head = n;
        n.succ.pred = n;
        if (size == 1)
        	tail.pred = n;
        size = size + 1;
    	return n;
    }

    /** Insert element into a new node before Node node and return the new node.
     * Precondition: node must be a Node of this list; it must not be null.
     * This operation must take constant time.  */
    Node insertBefore(E element, Node node) {// no access modifier. Accessible (only) in package
        
    	if (this.getNode(0).pred == node.pred)
    	{
    		Node b = this.prepend(element);
    		return b;
    	}
    	if (this.getNode(size - 1).succ == node.succ)
    	{
    		Node a = new Node (node.pred, element, node);
        	node.pred.succ = a;
        	node.pred = a;
        	tail = a.succ;
        	size = size + 1;
        	return a;
    	}
    	Node a = new Node (node.pred, element, node);
    	node.pred.succ = a;
    	node.pred = a;
    	size = size + 1;
        return a;	
    }

    /**  Insert element in a new node of the list, making it number h.
     * The element that was number h becomesnumber h+1, the element that was number
     * h+1 becomes number h+2, and so on. 
     * Throw an IndexOutOfBoundsException if index < 0 or h > size of the list.
     * Note that if h = size of the list, this means to append element.
     * This operation must take time proportional to min (h, size - index). */
    public @Override void add(int h, E element) {
        
    	Node a = this.getNode(h);
    	this.insertBefore(element, a);
    }

    /** Remove node from this list and return its data.
     * Precondition: node must be a Node of this list; it must not be null.
     * Postcondition: To prevent memory leaks, every field of node should be set to null. */
    E removeNode(Node node) {// no access modifier. Accessible (only) in package
        
    	if (size == 1)
    	{
    		E data = node.data;
        	node.pred = null;
        	node.data = null;
        	node.succ = null;
        	size = size -1;
    		head = null;
    		tail = null;
        	return data;

    	}
    	if (node.pred == null)
    	{
    		node.succ.pred = null;
    		head = node.succ;
    	}
    	else if (node.succ == null)
    	{
    		node.pred.succ = null;
    		tail = node.pred;
    	}
    	else
    	{
    		node.pred.succ = node.succ;
    		node.succ.pred = node.pred;
    	}
    	E data = node.data;
    	node.pred = null;
    	node.data = null;
    	node.succ = null;
    	size = size -1;
    	return data;
    }

    /** Remove element number h from the list and return the element that was removed.
     * Throw an IndexOutOfBoundsException if h < 0 or h >= size of the list. */
    public @Override E remove(int h) {
        
    	Node a = this.getNode(h);
    	E data = this.removeNode(a);
    	return data;
    }

    /*********************/

    /** An instance is a node of this list. */
    class Node {// no access modifier. Accessible (only) in package
        /** Predecessor of this node on list (null if this is the first node). */
        Node pred; // no access modifier. Accessible (only) in package

        /** The data in this element. */
        E data; // no access modifier. Accessible (only) in package

        /** Successor of this node on list. (null if is the last node). */
        Node succ; // no access modifier. Accessible (only) in package

        /** Constructor: an instance with predecessor node p (can be null),
         * successor node s (can be null), and data e. */
        Node(Node p, E e, Node s) {// no access modifier. Accessible (only) in package
            pred= p;
            succ= s;
            data= e;
        }
    }
}
