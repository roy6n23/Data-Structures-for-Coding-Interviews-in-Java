class CheckSmall{

	public static int[] findKSmallest(int[] arr, int k){
		int arraySize = arr.length;
		if(k <= arraySize){
			int []result = new int[k];
			for(int i = 0; i < k; i++){
				result[i] = removeMin(arr, arraySize);
				--arraySize;
			}
			return result;
		}
		System.out.println("Value of k = " + k+ "out of bounds!");
    	return arr;
	}


	public static int removeMin(int[] heapArray, int heapSize){
		buildMinHeap(heapArray, heapSize);
		int min = heapArray[0];
		heapArray[0] = heapArray[heapSize -1];
		return min;
	}

	public static void buildMinHeap(int[] heapArray, int heapSize){
		for(int i = heapSize/2 -1; i >= 0; i--){
			minHeapify(heapArray, i, heapSize);
		}
	}

	public static void minHeapify(int[] heapArray, int i, int heapSize){
		int smallest = index;

		while(smallest < heapSize / 2){
			int left = (2*index) + 1;
			int right = (2*index) + 2;

			if(left < heapSize && heapArray[left] < heapArray[index])
				smallest = left;

			if(right < heapSize && heapArray[right] < heapArray[smallest])
				smallest = right;

			if(smallest != index){
				int temp = heapArray[index];
		        heapArray[index] = heapArray[smallest];
		        heapArray[smallest] = temp;
		        index = smallest;
			}else
				break;

		}
	}
}