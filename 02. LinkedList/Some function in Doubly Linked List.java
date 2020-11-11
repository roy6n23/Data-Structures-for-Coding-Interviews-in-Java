public class DoublyLinkedList<T> {
    //Node inner class for DLL
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }
    public Node headNode;
    public int size;
    public DoublyLinkedList() {
        this.headNode = null;
    }

	public boolean isEmpty(){
		if(headNode == null)
			return true;
		return false;
	}

	public void insertAtHead(T data){
		Node newNode = headNode;
		newNode.data = data;

		newNode.nextNode = this.headNode;
		newNode.prevNode = null;

		if(headNode != null)
			headNode.prevNode = newNode;

		this.headNode = newNode;
		size++;
	}

	public void deleteAtHead(){
		if(isEmpty())
			return;

		headNode = headNode.nextNode;
		headNode.prevNode = null;
		size--;
	}

	public void deleteByValue(){
		if(isEmpty)
			return;

		Node currentNode = this.headNode;

		if(currentNode.data.equals(data)){
			deleteAtHead();
			return;
		}

		while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if(currentNode.nextNode != null)
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                size--;
            }
            currentNode = currentNode.nextNode;
        }

	}
}