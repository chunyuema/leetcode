class Food implements Comparable<Food> {
    public int rating;
    public String name;
    public String cuisine;

    public Food(int rating, String name, String cuisine) {
        this.rating = rating;
        this.name = name;
        this.cuisine = cuisine;
    }

    // Need to override compare to so that we can use it for the priority queue
    @Override
    public int compareTo(Food other) {
        if (this.rating == other.rating) {
            return this.name.compareTo(other.name);
        }
        return Integer.compare(other.rating, this.rating);
    }
}

class FoodRatings {
    // Use this as a source of truth of food related information
    private Map<String, Food> foodMap = new HashMap<>();

    // Use this queue as a playground of food objects
    private Map<String, PriorityQueue<Food>> cuisineFoodMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String name = foods[i];
            int rating = ratings[i];
            String cuisine = cuisines[i];
            Food food = new Food(rating, name, cuisine);
            foodMap.put(name, food);
            cuisineFoodMap.computeIfAbsent(cuisine, k -> new PriorityQueue<Food>())
                    // cannot reuse the food before due to interference
                    .add(new Food(rating, name, cuisine));
        }
    }

    public void changeRating(String name, int newRating) {
        // Update the rating of the food
        Food currFood = foodMap.get(name);
        // here we are modifying the food object, hence it cannot be the same as the
        // object on the queue
        currFood.rating = newRating;

        // Note that we just add the newFood with new rating, which invalidates the
        // original food with old rating
        // Hence in highestRated, we will need to check if the food we get from the
        // queue is still valid
        String cuisine = currFood.cuisine;
        Food newFood = new Food(newRating, name, cuisine);
        cuisineFoodMap.get(cuisine).add(newFood);
    }

    public String highestRated(String cuisine) {
        // Get the food from the queue until it is valid
        Food currFood = cuisineFoodMap.get(cuisine).peek();
        // Check the validity of the object against the source of truth
        while (foodMap.get(currFood.name).rating != currFood.rating) {
            cuisineFoodMap.get(cuisine).poll();
            currFood = cuisineFoodMap.get(cuisine).peek();
        }
        return currFood.name;
    }
}