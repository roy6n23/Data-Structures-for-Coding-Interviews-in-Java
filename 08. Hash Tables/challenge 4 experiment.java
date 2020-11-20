class CheckPath{

	public static String tracePath(Map<String, String> map){
		String result = "";

		HashMap<String, String> reverseMap = new HashMap<>();

		for(Map.Entry<String, String> entry : map.entrySet()){
			reverseMap.put(entry.getValue(), entry.getKey());
		}

		String from = "";

		int count = 0;

		for(Map.Entry<String, String> entry : map.entrySet()){
			(!reverseMap.containsKey(entry.getKey())){
				count++;
				from = entry.getKey();
			}
		}

		if(count > 1)
			return "null";

		String to = map.get(from);

		while(to != null){
			result += from + "->" + to + ",";
			from = to;
			to = map.get(from);
		}

		return result;
	}
}