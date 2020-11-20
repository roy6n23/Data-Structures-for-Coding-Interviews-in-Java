class CheckDuplicate{

	public static <V> void removeDuplicatedWithHashing(SinglyLinkedList<V> list){

		SinglyLinkedList<V>.Node currentNode = list.getHeadNode();
		//V currentNode = list.headNode;

		HashMap<V, Integer> hmap = new HashMap<>();

		while(currentNode != null){
			hmap.put(currentNode, hmap.getOrDefault(currentNode, 0)+1);
		}

		SinglyLinkedList<V>.Node currentNode = list.getHeadNode();
		SinglyLinkedList<V>.Node preNode = null;
		// V preNode = null;
		// V currentNode = list.headNode;

		while(currentNode != null){
			if(hmap.get(currentNode) == 2){
				preNode.nextNode = currentNode.nextNode;
				currentNode = currentNode.nextNode;
				hmap.put(currentNode, hmap.get(currentNode)-1);
			}
			preNode = currentNode;
			currentNode = currentNode.nextNode;
		}
	}
}