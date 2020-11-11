class CheckLoop {
    
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node slow = list.headNode;

		while(slow != null && fast != null && fast.nextNode != null){
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;

			if(slow == fast)
				return true;
		}

		return false;

    }
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        System.out.println("Before adding loop: " + detectLoop(list));
        list.headNode.nextNode.nextNode = list.headNode;
        System.out.println("After adding loop: " + detectLoop(list));
    }
}
