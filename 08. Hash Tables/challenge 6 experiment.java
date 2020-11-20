class CheckSubZero{

	public static boolean findSubZero(int[] arr){

		HashMap<Integer, Integer> hMap = new HashMap<>();

		int sum = 0;

		for(int i = 0 ; i < arr.length; i++){
			sum += arr[i];

			if(arr[i] == 0 || sum == 0 || hMap.containsKey(sum))
				return true;

			hMap.put(sum, i);
		}

		return false;
	}
}