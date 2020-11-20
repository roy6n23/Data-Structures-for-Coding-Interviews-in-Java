class CheckPairs{

	static static String findPair(int[] arr){

		String result = "";

		HashMap<Integer, int[]> hMap = new HashMap<>();

		for(int i = 0 ; i < arr.length; i++){
			for(int j = i+1; j < arr.length; j++){
				int sum = arr[i] + arr[j];

				if(!hMap.containsKey(sum)){
					hMap.put(sum, new int[] {arr[i], arr[j]});
				}else{
					int[] prepair = hMap.get(sum);

					result += "{" + prepair[0] + "," + prepair[1] + "}" + "," + "{" + arr[i] + "," + arr[j] + "}";

					result result;
				}
			}
		}

		return result;
	}
}