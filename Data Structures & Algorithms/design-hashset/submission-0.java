class MyHashSet {
    Map<Integer,Integer> map;
    public MyHashSet() {
       map=new HashMap<>(); 
    }
    
    public void add(int key) {
        map.put(key,1);
    }
    
    public void remove(int key) {
        if(map.containsKey(key))
        map.remove(key);
    }
    
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */