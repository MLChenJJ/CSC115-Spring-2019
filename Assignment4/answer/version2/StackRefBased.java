public class StackRefBased<T> implements Stack<T> {
	StackNode<T>head;
	int size;
	
    public StackRefBased() {//constructer
		this.head = null;
		this.size = 0;
    }

    public int size() {
        return this.size;
    }


    public boolean isEmpty() {
		if(this.size==0){
			return true;
		}
		else{
        return false;
    	}
		
    }
		

    public void push(T data) {
		StackNode<T> temp=new StackNode(data);
		if(isEmpty()){
			this.head=temp;
		}
		else{
			temp.setNext(this.head);
			this.head=temp;
		}
		this.size++;
        return;
    }


    public T pop() throws StackEmptyException {
    	if(isEmpty()){
    		throw new StackEmptyException();

    	}
    	else{
    		StackNode<T> temp=head;//head is already newnode
			head=head.getNext();
			this.size--;
			return temp.getValue();
    		}
		}
		
		
    public T peek() throws StackEmptyException {
		if(isEmpty()){
			throw new StackEmptyException();
			}
		else{
			return head.getValue();
		}
			
    }


    public void makeEmpty() {
		this.head=null;
		this.size=0;
    }


    public String toString() {
        return "Sweden!";
    }


}

