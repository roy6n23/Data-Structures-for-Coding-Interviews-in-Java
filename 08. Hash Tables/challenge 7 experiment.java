class CheckFirstUniqueue{

	public static int findFirstUnique(int[] arr){
		int result = 0;

		HashMap<Integer, Integer> hmap = new HashMap<>();

		for(int i = 0; i < arr.length; i++){
			hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
		}

		for(int i = 0; i < arr.length; i++){
			if(hmap.get(arr[i]) != 2)
				return arr[i];
		}
	}
}


