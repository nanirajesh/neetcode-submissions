class WordDictionary {

   class TrieNode { 
    TrieNode[] node ;
    boolean isEnd;

    TrieNode() { 
        node= new TrieNode[26];
    }
   }

   TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(curr.node[index] == null) {
                curr.node[index]=new TrieNode();
            }
            curr=curr.node[index];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
      return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) {
        if (curr == null) {
            return false;
        }

        if (index == word.length()) {
            return curr.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : curr.node) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        return dfs(word, index + 1, curr.node[c - 'a']);
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */