package finalProject;

import java.io.IOException;

/**
 * @author Laleh LINK LIST CLASS
 */
public class LinkedList {

	

	private Link first;
	private int size;

	// ================== constructor============================

	/**
	 * default constructor
	 */
	public LinkedList() {
		first = null;
		size = 0;

	}

	// =============== check the list is not empty =====================
	/**
	 * @return true if it is empty
	 */
	public boolean isEmpty() {

		return (first == null);
	}

	// =============== insert item in order ascending ===================
	/**
	 * @param co INSERT Ascending
	 */
	public void sortInsert(company co) // insert in order
	{
		Link newLink = new Link(co); // make new link
		Link previous = null; // start at first
		Link current = first;
		// until end of list,
		while (current != null && co.getSuggestedCost() > current.getCompany().getSuggestedCost()) { // or key >
																										// current,
			previous = current;
			current = current.next; // go to next item
		}
		if (previous == null) // at beginning of list
			first = newLink; // first --> newLink
		else // not at beginning
			previous.next = newLink; // old prev --> newLink
		newLink.next = current; // newLink --> old current
	}

	// ================ delete items of List from the end
	/**
	 * @return the deleted link
	 * @throws IOException
	 */
	public Link deletLast() throws Exception {
		Link cur = first;
		Link pre = first;
		if (isEmpty()) {
			throw new Exception("the List is empty");
			// cur= null;
		} else if (first.next == null) {
			first = null;
		}
		while (cur.next != null) {

			pre = cur;
			cur = cur.next;
		}
		pre.next = null;
		return (cur);
	}

	// ============ Average of suggestion cost ===============
	/**
	 * @param List
	 * @return average in the list
	 * @throws Exception
	 */
	public double Average(LinkedList m) throws Exception{
		// LinkedList m=new LinkedList();
		double ave = (m.peekMax().getSuggestedCost() + m.findMin().getSuggestedCost()) / 2;

		return ave;
	}

	// ===================== winner company ======================
	/**
	 * @param LinkedList
	 * @return winner `CO
	 * @throws Exception
	 */
	public company findWinner(LinkedList m) throws Exception // find link with given key
	{ // (assumes non-empty list)
		double key = (m.Average(m))*.90;
		Link current = first; // start at ‘first’
		while (current.getCompany().getSuggestedCost() < key) // while no match,
		{
			if (current.next == null) // if end of list,
				return current.getCompany(); // didn’t find it
			else // not end of list,
				current = current.next; // go to next link
		}
		return current.getCompany(); // found it
	}
	// ===================== delete first ======================
	/**
	 * @return delete first link
	 * @throws Exception
	 */
	public Link deleteFirst() throws Exception // delete first item
	{ // (assumes list not empty)
		if (isEmpty()) {
			throw new Exception("the List is empty");
			// cur= null;
		}else {
		Link temp = first; // save reference to link
		first = first.next; // delete it: first-->old next
		return temp;} // return deleted link
	}

	// ================ find maximum================
	/**
	 * @return Max 
	 */
	public company peekMax() {// throws IOException {
		Link cur = first;
		Link pre = first;
		if (isEmpty()) {
			System.out.println("List is empty");
			// cur= null;
		} else if (first.next == null) {
			cur = first;
		}
		while (cur.next != null) {
			pre = first;
			cur = cur.next;
		}
		// pre.next = null;
		return (cur.getCompany());
	}

	// ==================== find Min ===================
	/**
	 * @return company with max offer
	 * @throws Exception
	 */
	public company findMin() throws Exception {
		if (isEmpty()) {
			throw new Exception("List is empty");
		}
		return first.getCompany();
	}

	// ================== display List ======================
	/**
	 * display the list
	 */
	public void displaylist() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

	// ============ number of items in the list==============
	/**
	 * @return size
	 */
	public int getSize() throws IOException {
		if (isEmpty()) {
			size = 0;
		}
		else{ size = 1;
		Link Curr = first;
		while (Curr.next != null) {
			Curr = Curr.next;
			size++;
		}
		}
		return size;

	}
	@Override
	public String toString() {
		return "LinkedList [first=" + first + "]";
	}

}
