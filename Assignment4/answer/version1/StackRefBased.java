public class StackRefBased<T> implements Stack<T> {

    StackNode<T> head;
    int size;

    public StackRefBased() {
        head = new StackNode(null);
        size = 0;
    }

    public int size() {
        return this.size;
    }


    public boolean isEmpty() {
        return this.size==0;
    }


    public void push(T data) {
        StackNode<T> temp = new StackNode(data);
        if(isEmpty()){
            this.head = temp; 
        }
        else{
            temp.setNext(this.head);
            head = temp;
        }
        this.size++;
        return;
    }


    public T pop() throws StackEmptyException {
        if(!isEmpty()){
            StackNode<T> pop_node = head;
            head = head.getNext();
            this.size--;
            return pop_node.getValue();
        }
        else{
            throw new StackEmptyException();
        }
        
    }


    public T peek() throws StackEmptyException {
        
        if(!isEmpty()){
            StackNode<T> peek_node = head;
            return peek_node.getValue();
        }
        else{
           throw new StackEmptyException();
        }
    }


    public void makeEmpty() {
         this.head = new StackNode(null);
         this.size = 0;
    }


    public String toString() {

        String s = "";
        StackNode<T> curr = this.head;
        while(curr.getNext()!=null){
            s+=curr.toString()+" ";
            curr = curr.getNext();
        }
        s+=curr.toString();
    
        return s;
    }
}

