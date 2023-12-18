class Food
{
public:
    string name;
    int rating;
    string cuisine;

    Food(string name, int rating, string cuisine)
    {
        this->name = name;
        this->rating = rating;
        this->cuisine = cuisine;
    }

    bool operator<(const Food &other) const
    {
        if (this->rating == other.rating)
        {
            return this->name > other.name;
        }
        return this->rating < other.rating;
    }
};

class FoodRatings
{
public:
    FoodRatings(vector<string> &foods, vector<string> &cuisines, vector<int> &ratings)
    {
        for (int i = 0; i < foods.size(); i++)
        {
            string name = foods[i];
            int rating = ratings[i];
            string cuisine = cuisines[i];
            foodMap.insert(make_pair(name, new Food(name, rating, cuisine)));
            cuisineFoodMap[cuisine].push(Food(name, rating, cuisine));
        }
    }

    void changeRating(string food, int newRating)
    {
        auto foodItem = foodMap[food];
        foodItem->rating = newRating;
        string cuisine = foodMap[food]->cuisine;
        cuisineFoodMap[cuisine].push(Food(food, newRating, cuisine));
    }

    string highestRated(string cuisine)
    {
        auto highestRatedFood = cuisineFoodMap[cuisine].top();
        while (highestRatedFood.rating !=
               foodMap[highestRatedFood.name]->rating)
        {
            cuisineFoodMap[cuisine].pop();
            highestRatedFood = cuisineFoodMap[cuisine].top();
        }
        return highestRatedFood.name;
    }

private:
    unordered_map<string, shared_ptr<Food>> foodMap;
    unordered_map<string, priority_queue<Food>> cuisineFoodMap;
};