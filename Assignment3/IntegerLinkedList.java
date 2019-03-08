/*
 * Name:
 * Student Number:
 */

public class IntegerLinkedList implements IntegerList
{
	private IntegerNode head;
	private IntegerNode tail;
	int size;
	public IntegerLinkedList()
	{
		head = tail = null;
		size = 0;

	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{
		IntegerNode tmp = new IntegerNode(x, head);
		tmp.setPrev(null);
		if(head != null){
			head.setPrev(tmp);
		}
		head = tmp;
		if(tail == null){
			tail = tmp;
		}
		size++;
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */
	public void addBack (int x)
	{
		IntegerNode tmp = new IntegerNode(x, null);
		if(tail!=null){
			tail.setNext(tmp);
			tmp.setPrev(tail);
		}
		else{
			tmp.setPrev(null);
		}
		tail = tmp;

		if(head == null){
			head = tmp;
		}

		size++;
	}

	/*
	 * PURPOSE:
	 *   Add the element x at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for addAt are
	 *   0, 1, 2, 3.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos <= l.size()
	 *
	 * Examples:
	 *
	 * If l is {} and l.addAt(9,0) returns, then l is {9}.
	 * If l is {1} and l.addAt(9,0) returns, then l is {9,1}.
	 * If l is {1,2} and l.addAt(9,1) returns, then l is {1,9,2}
	 * If l is {1,2} and l.addAt(9,2) returns, then l is {1,2,9}
	 */
	public void addAt (int x, int pos)
	{
		if(pos == 0){
			addFront(x);
		}
		else if(pos == size){
			addBack(x);
		}
		else{
			IntegerNode tmp = new IntegerNode(x);
			IntegerNode curr = head;
			int count = 0;
			while(curr.getNext() != null){
				if(count == pos){
					tmp.setNext(curr);
					tmp.setPrev(curr.getPrev());
					curr.getPrev().setNext(tmp);
					curr.setPrev(tmp);
					size++;
					break;

				}else{
					count++;
					curr = curr.getNext();
				}

			}
		}

	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return size;
	}

	/*
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 *
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
		if(size == 0){
			return 0;
		}
		else{
			IntegerNode curr = head;
			int count =0;
			while(curr.getNext() != null){
				if(count == pos){
					return curr.getValue();
				}
				else{
					curr = curr.getNext();
					count++;
				}

			}
			if(count == pos){
				return curr.getValue();
			}
			return 0;

		}
	}

	/*
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{
		head = tail = null;
		size =0;
	}

	/*
	 * PURPOSE:
	 *   Remove all instances of value from the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{

		IntegerNode curr = head;
		while(curr.getNext()!= null){
			if(curr.getValue() == value){
				if(curr.getPrev() == null){//delete at the head
					head = curr.getNext();
					head.setPrev(null);
					curr = head;
					size--;
				}else{
					curr.getPrev().setNext(curr.getNext());
					curr.getNext().setPrev(curr.getPrev());
					curr =curr.getNext();
					size--;
				}

			}
			else{
				curr =curr.getNext();
			}

		}
		if(size == 1){
			if(tail.getValue() == value){
				head = tail = null;
				size =0;
			}

		}
		if(size>=2){
			if(tail.getValue() == value){
				tail = tail.getPrev();
				tail.setNext(null);
				size--;
			}

		}




	}

	/*
	 * PURPOSE:
	 *   Remove the element at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for removeAt are
	 *   0, 1, 2.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *
	 * If l is {1} and l.removeAt(0) returns, then l is {}.
	 * If l is {1,2,3} and l.removeAt(1) returns, then l is {1,3}
	 * If l is {1,2,3} and l.removeAt(2) returns, then l is {1,2}
	 */
	public void removeAt (int pos)
	{ 
			if(size == 0){
			}
			else if(size == 1){
				head = tail = null;
				size =0;
			}
			else{
				if(pos == 0){
					head = head.getNext();
					head.setPrev(null);
					size --;
				}
				else if(pos == size -1){
					tail = tail.getPrev();
					tail.setNext(null);
					size--;

				}
				else{
					IntegerNode curr = head;
					int count = 0;
					while(curr.getNext()!= null){
						if(count == pos){
							curr.getPrev().setNext(curr.getNext());
							curr.getNext().setPrev(curr.getPrev());
							size--;
							break;
						}
						else{
							count++;
							curr =curr.getNext();
						}
					}
				}
			}

	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		String s = "{";
		if(size ==0){
			return s+="}";

		}
		else{
			IntegerNode curr = head;
			while(curr.getNext() != null){
				s+= curr.getValue()+",";
				curr = curr.getNext();
			}
			s+= curr.getValue()+"}";
			return s;
		}
		
	}
}











