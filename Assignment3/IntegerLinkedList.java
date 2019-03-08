/*
 * Name:
 * Student Number:
 */

public class IntegerLinkedList implements IntegerList
{
	private IntegerNode head;
	private IntegerNode tail;
	int count;
	
	
	
	public IntegerLinkedList()
	{
		this.head = null;
		this.tail = null;
		this.count = 0;

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
		IntegerNode temp = new IntegerNode(x);
		temp.setNext(null);
		temp.setPrev(null);
		
		if(this.head != null){
			temp.setNext(head);
			head.setPrev(temp);
			head = temp;
		}
		else{
			head = temp;
		}
		
		if(this.tail!=null){
			
		}else{
			tail = temp;
		}
		
		this.count++;
		
		
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
		IntegerNode temp = new IntegerNode(x);
		temp.setNext(null);
		temp.setPrev(null);
		
		if(this.tail != null){
			temp.setNext(null);
			temp.setPrev(tail);
			tail.setNext(temp);
			tail=temp;
		}
		else{
			tail = temp;
		}
		
		if(this.head!=null){
			
		}else{
			head=temp;
		}
		
		this.count++;
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
		IntegerNode temp = new IntegerNode(x);
		temp.setNext(null);
		temp.setPrev(null);
		if(pos==0){
			addFront(x);
		}
		else if(pos==count){
			addBack(x);
		}
		else{
		IntegerNode curr = this.head;
		for(int i =0; curr.getNext()!= null;i++,curr=curr.getNext()){
			if(i == pos){
				IntegerNode prev = curr.getPrev();
				IntegerNode next = curr;
				
				prev.setNext(temp);
				temp.setPrev(prev);
				temp.setNext(next);
				next.setPrev(temp);
				this.count++;
				break;
				
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
		return this.count;
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
		IntegerNode curr = this.head;
		
		
		for(int i=0; curr.getNext()!=null;i++,curr = curr.getNext()){
			if(i == pos){
				return curr.getValue();
			}
		}
		
		if(pos == this.count-1){
			return curr.getValue();
		}
		
		return 0;
			
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
		head=null;
		tail=null;
		count=0;
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
		IntegerNode curr = this.head;
	for(;curr.getNext()!= null; curr=curr.getNext()){
		if(curr.getValue()==value){
			if(curr.getPrev()==null){
				head=head.getNext();
				head.setPrev(null);
				this.count--;
			}else{IntegerNode prev=curr.getPrev();
				  IntegerNode next=curr.getNext();
				  prev.setNext(next);
				  next.setPrev(prev);
				  this.count--;
			}
		}
	}
	if(count==1){
		if(tail.getValue()==value){
			clear();
		}}
	else if(count>=1){
		if(tail.getValue()==value){
			tail=tail.getPrev();
			tail.setNext(null);
			this.count--;
			
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
	{if(count==1){
		clear();
	}
	else if(count >=2){
		if(pos==0){
			head=head.getNext();
			head.setPrev(null);
			this.count--;
		}
			else if(pos==count-1){
				tail=tail.getPrev();
				tail.setNext(null);
				this.count--;
			}
			else{IntegerNode curr = this.head;
				for(int i = 0;curr.getNext()!=null;i++,curr=curr.getNext()){
					if(i==pos){
						IntegerNode prev=curr.getPrev();
						IntegerNode next=curr.getNext();
						prev.setNext(next);
						next.setPrev(prev);
						this.count--;
						break;
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
	{	String s = "{";
		if(this.count==0){
		return s+"}";
		}
		else{
			IntegerNode curr = this.head;
			for(;curr.getNext()!= null; curr=curr.getNext()){
				s+=curr.getValue()+",";
			}
			
		s+=curr.getValue()+"}";
		return s;
		
		}
	}
}
