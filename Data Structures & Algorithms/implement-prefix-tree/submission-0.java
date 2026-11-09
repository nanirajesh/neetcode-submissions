class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        children = new TrieNode[26];
        isEnd=false;
    }
}
class PrefixTree {

  TrieNode head;
    public PrefixTree() {
         head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode root=head;
         for(char c:word.toCharArray()) {
            int index=c-'a';
            if(root.children[index]==null){
              root.children[index]=new TrieNode();
            }
            root=root.children[index];
         }
         root.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode root=head;
       for(char c:word.toCharArray()){
        int index=c-'a';
           if(root.children[index]==null){
           return false;
           }
           root=root.children[index];
       }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
       TrieNode curr=head;
        for(char c:prefix.toCharArray()){
            int index= c-'a';
            if(curr.children[index]== null) return false;
            curr=curr.children[index];
        }
        return true;
    }
}
