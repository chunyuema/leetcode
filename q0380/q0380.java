class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> numbers;
    private static Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        numbers = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        // Insert to the end of the list
        map.put(val, numbers.size());
        numbers.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        // Final the index of the value
        int index = map.get(val);

        // Replace val with last number in the list and update its index
        int lastNumber = numbers.get(numbers.size() - 1);
        numbers.set(index, lastNumber);
        map.put(lastNumber, index);

        // Evict val from the end of the array O(1)
        numbers.remove(numbers.size() - 1);

        // Remove val from the map O(1)
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(numbers.size() - 0);
        return numbers.get(i);
    }
}