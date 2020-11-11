class UnionIntersectionChallenge {
   	public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
		//corner case
		if(list1.isEmpty())
			return list2;
		if(list2.isEmpty())
			return list1;

		SinglyLinkedList<T>.Node last = list1.headNode;
		while(last.nextNode != null){
			last = last.nextNode;
		}

		last.nextNode = list2.headNode;

		list1.removeDuplicatesWithHashing();

		retturn list1;
	}

	public static <T> boolean contains(SinglyLinkedList<T> list, T data){
		SinglyLinkedList<T>.Node current = list.getHeadNode();
		while(current != null){
			if(current.data.equals(data))
				return true;
			current = current.nextNode;
		}
		return false;
	}

	public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        if (list1.isEmpty())
            return result;
        if (list2.isEmpty())
            return result;
        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        while (current != null) {
            if (contains(list2, current.data)) {
                result.insertAtHead(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

}