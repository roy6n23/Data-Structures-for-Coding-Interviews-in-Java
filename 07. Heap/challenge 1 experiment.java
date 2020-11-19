class CheckConvert{
	public static void convertMax(int []maxHeap){
		buildMinHeap(maxHeap, maxHeap.length);
	}

	public static void buildMinHeap(int[] heapArray, int heapSize){

		for(int i = heapSize/2 - 1; i >= 0; i-- ){
			minHeapify(heapArray, i, heapSize);
		}
	}

	private static void minHeapify(int[] heapArray, int index, int heapSize){
		int smallest = index;
		while(smallest< heapSize / 2){
			int leftChild = (2 * index) + 1;
			int rightChild = (2 * index) + 2;

			if(leftChild < heapSize && heapArray[leftChild] < heapArray[index]){
				smallest = leftChild;
			}

			if(rightChild < heapSize && heapArray[rightChild] < heapArray[smallest]){
				smallest = rightChild;
			}

			if(smallest != index){
				int temp = heapArray[smallest];
				heapArray[smallest] = heapArray[index];
				heapArray[index] = temp;
				index = smallest;
			}else
				break;
		}
	}
}


