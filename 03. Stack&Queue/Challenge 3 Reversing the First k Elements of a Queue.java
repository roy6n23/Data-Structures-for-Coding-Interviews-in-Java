class CheckReverse {
	public static <V> void reverseK(Queue<V> queue, int k) {
		if(queue.isEmpty() || k <= 0)
			return;

		Stack<V> stack = new Stack<>(k);
		while(!stack.isFull())
			stack.push(queue.dequeue());
		while(!stack.isEmpty())
			queue.enqueue(stack.pop());
		int size = queue.getCurrrentSize();
		for(int i = 0; i < size - k; i++)
			queue.enqueue(queue.dequeue());
	}

}