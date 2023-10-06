class LRUCache {
    private int _capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        _capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            // remove the key and add it back in to make it the most recently used element
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }

        else if (map.size() >= _capacity) {
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }

        map.put(key, value);
    }
}