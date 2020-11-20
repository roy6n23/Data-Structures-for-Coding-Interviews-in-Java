class CheckSymmetric{

	public static String findSymmetric(int [][]arr){
		HashMap<Integer, Integer> hmap = new HashMap<>();
		String result = "";

		for(int i = 0 ; i < arr.length; i++){
			hmap.put(arr[i][0], arr[i][1]);
		}

		for(int i = 0; i < arr.length; i++){
			if(hmap.containsValue(arr[i][1])){
				String += "{" + String.valueOf(arr[i][0]) + "," + String.valueOf(arr[i][1]) +  "}";
			}
		}

		return result;
	}
}