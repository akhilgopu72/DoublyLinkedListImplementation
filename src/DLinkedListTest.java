
import static org.junit.Assert.*;

import org.junit.Test;

public class DLinkedListTest {

	
	@Test
	 public void testConstructor() {
		 DLinkedList<Integer> b= new DLinkedList<Integer>();
		 assertEquals("[]", b.toString());
		 assertEquals("[]", b.toStringRev());
		 assertEquals(0, b.size());
	 }

	@Test
	 public void testAppend() {
		 DLinkedList<String> ll= new DLinkedList<String>();
		 DLinkedList<String>.Node n= ll.append("Ross");
		 assertEquals("[Ross]", ll.toString());
		 assertEquals("[Ross]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 assertEquals(ll.getTail(), n);
	 }
	@Test
	 public void testAdd1() {
		 DLinkedList<Integer> ll= new DLinkedList<Integer>();
		 ll.add(1);
		 assertEquals("[1]", ll.toString());
		 assertEquals("[1]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 ll.add(2);
		 assertEquals("[1, 2]", ll.toString());
		 assertEquals("[2, 1]", ll.toStringRev());
		 assertEquals(2, ll.size());
	 }
	@Test
	 public void testGetNode() {
		 DLinkedList<String> ll= new DLinkedList<String>();
		 DLinkedList<String>.Node a= ll.append("Ross");
		 assertEquals("[Ross]", ll.toString());
		 assertEquals("[Ross]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 assertEquals(ll.getTail(), a);
		 assertEquals(ll.getHead(), a);
		 DLinkedList<String>.Node b= ll.append("Tate");
		 assertEquals("[Ross, Tate]", ll.toString());
		 assertEquals("[Tate, Ross]", ll.toStringRev());
		 assertEquals(2, ll.size());
		 assertEquals(ll.getTail(), b);
		 assertEquals(ll.getHead(), a);
		 assertEquals(ll.getNode(1), b);
		 assertEquals(ll.getNode(0), a);
	 }
	@Test
	 public void testGet() {
		 DLinkedList<Integer> ll= new DLinkedList<Integer>();
		 ll.add(1);
		 assertEquals("[1]", ll.toString());
		 assertEquals("[1]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 ll.add(2);
		 assertEquals("[1, 2]", ll.toString());
		 assertEquals("[2, 1]", ll.toStringRev());
		 assertEquals(2, ll.size());
		 assertEquals(1, (int) ll.get(0));
		 assertEquals(2, (int) ll.get(1));
	 }
	@Test
	 public void testSet() {
		 DLinkedList<Integer> ll= new DLinkedList<Integer>();
		 ll.add(1);
		 assertEquals("[1]", ll.toString());
		 assertEquals("[1]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 ll.add(2);
		 assertEquals("[1, 2]", ll.toString());
		 assertEquals("[2, 1]", ll.toStringRev());
		 assertEquals(2, ll.size());
		 assertEquals(1, (int) ll.set(0, 2));
		 assertEquals(2, (int) ll.set(1, 3));
		 assertEquals("[2, 3]", ll.toString());
		 assertEquals(2, ll.size());
	 }
	//@Test
	 public void testPrepend() {
		 DLinkedList<String> ll= new DLinkedList<String>();
		 DLinkedList<String>.Node b= ll.append("Tate");
		 assertEquals("[Tate]", ll.toString());
		 assertEquals("[Tate]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 assertEquals(ll.getTail(), b);
		 assertEquals(ll.getHead(), b);
		 DLinkedList<String>.Node a= ll.prepend("Ross");
		 assertEquals("[Ross, Tate]", ll.toString());
		 assertEquals(ll.getHead(), a);
		 assertEquals(ll.getTail(), b);


	 }
	@Test
	 public void testInsertBefore() {
		 DLinkedList<String> ll= new DLinkedList<String>();
		 DLinkedList<String>.Node b= ll.append("Tate");
		 assertEquals("[Tate]", ll.toString());
		 assertEquals("[Tate]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 assertEquals(ll.getTail(), b);
		 assertEquals(ll.getHead(), b);
		 DLinkedList<String>.Node a= ll.insertBefore("Ross", b);
		 assertEquals("[Ross, Tate]", ll.toString());
		 assertEquals(ll.getHead(), a);
		 assertEquals(ll.getTail(), b);
		 DLinkedList<String>.Node c= ll.insertBefore("The Boss", b);
		 assertEquals("[Ross, The Boss, Tate]", ll.toString());
		 assertEquals(ll.getHead(), a);
		 assertEquals(ll.getTail(), b); 
	}
	@Test
	 public void testAdd2() {
		 DLinkedList<Integer> ll= new DLinkedList<Integer>();
		 DLinkedList<Integer>.Node a= ll.append(1);
		 assertEquals("[1]", ll.toString());
		 assertEquals("[1]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 DLinkedList<Integer>.Node b= ll.append(3);
		 assertEquals("[1, 3]", ll.toString());
		 assertEquals("[3, 1]", ll.toStringRev());
		 ll.add(1,2);
		 assertEquals("[1, 2, 3]", ll.toString());
		 assertEquals("[3, 2, 1]", ll.toStringRev());
		 ll.add(0,0);
		 assertEquals("[0, 1, 2, 3]", ll.toString());
		 assertEquals("[3, 2, 1, 0]", ll.toStringRev());

		 
	 }
	
	@Test
	 public void testRemoveNode() {
		 DLinkedList<Integer> ll= new DLinkedList<Integer>();
		 DLinkedList<Integer>.Node a= ll.append(1);
		 assertEquals("[1]", ll.toString());
		 assertEquals("[1]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 DLinkedList<Integer>.Node b= ll.append(2);
		 assertEquals("[1, 2]", ll.toString());
		 assertEquals("[2, 1]", ll.toStringRev());
		 DLinkedList<Integer>.Node e= ll.append(3);
		 Integer c= ll.removeNode(b);
		 assertEquals("[1, 3]", ll.toString());
		 assertEquals("[3, 1]", ll.toStringRev());
		 Integer d= ll.removeNode(a);
		 assertEquals("[3]", ll.toString());
		 assertEquals("[3]", ll.toStringRev());
		 Integer f= ll.removeNode(a);
		 assertEquals("[]", ll.toString());
		 assertEquals("[]", ll.toStringRev());
	 }
	@Test
	 public void testRemove() {
		 DLinkedList<Integer> ll= new DLinkedList<Integer>();
		 DLinkedList<Integer>.Node a= ll.append(1);
		 assertEquals("[1]", ll.toString());
		 assertEquals("[1]", ll.toStringRev());
		 assertEquals(1, ll.size());
		 DLinkedList<Integer>.Node b= ll.append(2);
		 assertEquals("[1, 2]", ll.toString());
		 assertEquals("[2, 1]", ll.toStringRev());
		 ll.add(3);
		 ll.add(4);
		 ll.add(5);
		 ll.remove(4);
		 assertEquals("[1, 2, 3, 4]", ll.toString());
		 assertEquals("[4, 3, 2, 1]", ll.toStringRev());
		 ll.remove(0);
		 assertEquals("[2, 3, 4]", ll.toString());
		 assertEquals("[4, 3, 2]", ll.toStringRev());
	}
}
