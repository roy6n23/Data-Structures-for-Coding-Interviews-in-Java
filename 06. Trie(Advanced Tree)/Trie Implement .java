class TrieNode{
	TrieNode[] children;
	boolean isEndWord;
	static final int ALPHABET_SIZE = 26;
	TrieNode(){
		this.isEndWord = false;
		this.children = new TrieNode[ALPHABET_SIZE];
	}

	public void markAsLeaf(){
		this.isEndWord = true;
	}

	public void unMarkAsLeaf(){
		this.isEndWord = false;
	}
}


class Trie{
	private TrieNode root;

	Trie(){
		root = new TrieNode();
	}

	public int getIndex(char x){
		return x - 'a';
	}

	public void insert(String key){
		if(key == null){
			System.out.println("Null key can not be Insert");
			return;
		}

		key = key.toLowerCase();
		TrieNode currentNode = this.root;
		int index = 0;

		for(int level = 0; level < key.length(); level++){
			index = getIndex(key.charAt(level));
			if(currentNode.children[index] == null){
				currentNode.children[index] = new TrieNode();
			}
			currentNode = currentNode.children[index];
		}

		currentNode.markAsLeaf();
	}

	public boolean search(String key){
		if(key == null){
			System.out.println("Null key can not be search");
			return false;
		}

		key = key.toLowerCase();
		TrieNode currentNode = this.root;
		int index = 0;

		for(int level = 0; level < key.length(); level++){
			index = getIndex.(key.charAt(level));
			if(currentNode.children[index] == null){
				return false;
			}			
			currentNode = currentNode.children[index];							
		}

		if(!currentNode.isEndWord)
			return false;
		else
			return true;
	}


	public boolean delete(String key){
		
	}
}