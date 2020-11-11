public class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;
    }
    public Node headNode; //head node of the linked list
    public int size;      //size of the linked list
    //Constructor - initializes headNode and size
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }
    //Helper Function that checks if List is empty or not 
    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }



//================INSERT AT headNode=========

	public void insertAtHead(T data){
		Node newNode = new Node();
		newNode.data = data;

		newNode.nextNode = headNode;
		headNode = newNode;
		size++;
	}


//==========insert at end


	public void insertAtEnd(T data){
	        //if the list is empty then call insertATHead()
	        if (isEmpty()) {
	            insertAtHead(data);
	            return;
	        }
	        //Creating a new Node with value data
	        Node newNode = new Node();
	        newNode.data = data;
	        newNode.nextNode = null;
	        Node last = headNode;
	        //iterate to the last element
	        while (last.nextNode != null) {
	            last = last.nextNode;
	        }
	        //make newNode the next element of the last node
	        last.nextNode = newNode;
	        size++;
	}

//======insert after===========

	public void insertAfter(T data, T previous){
		Node newNode = new Node();
		newNode.data = data;

		Node currentNode = this.headNode;

		while(currentNode != null && !currentNode.data.equals(previous))
			currentNode = currentNode.nextNode;

		if(currentNode != null){
			newNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = newNode;
			size++;
		}
	}

//==============search===============
	public boolean searchNode(T data){
		Node currentNode = this.headNode;

		while(currentNode != null){
			if(currentNode.data.eaquals(data))
				return true;
			currentNode = currentNode.nextNode;
		}

		return false;

	}

//===================Detele HeadNode =========================
	public void deleteHeadNode(){
		if(isEmpty())
			return;

		headNode = headNode.nextNode;
		size--;
	}

//============delete by value===============
	public void deleteByValue(T data){
		if(isEmpty())
			return;

		Node currentNode = headNode;
		Node preNode = null;

		if(currentNode.data.equals(data)){
			deleteHeadNode();
			return;
		}

		while(currentNode != null){
			if(data.equals(currentNode.data)){
				preNode.nextNode = currentNode.next;
				size--;
				return;
			}
			preNode = currentNode;
			currentNode = currentNode.nextNode;

		}
	}
}