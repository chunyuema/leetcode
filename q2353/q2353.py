class Food: 
    def __init__(self, name, rating, cuisine):
        self.name = name
        self.rating = rating
        self.cuisine = cuisine
    
    def __lt__(self, other):
        if self.rating == other.rating: 
            return self.name < other.name
        return self.rating > other.rating
    
class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.foodMap = {}
        self.cuisineFoodMap = defaultdict(list)
        for i in range(len(foods)):
            name, rating, cuisine = foods[i], ratings[i], cuisines[i]
            self.foodMap[name] = Food(name, rating, cuisine)
            heapq.heappush(self.cuisineFoodMap[cuisine], Food(name, rating, cuisine))

    def changeRating(self, food: str, newRating: int) -> None:
        self.foodMap[food].rating = newRating
        cuisine = self.foodMap[food].cuisine
        heapq.heappush(self.cuisineFoodMap[cuisine], Food(food, newRating, cuisine))

    def highestRated(self, cuisine: str) -> str:
        highestRatedFood = self.cuisineFoodMap[cuisine][0]
        while (highestRatedFood.rating != self.foodMap[highestRatedFood.name].rating):
            heapq.heappop(self.cuisineFoodMap[cuisine])
            highestRatedFood = self.cuisineFoodMap[cuisine][0]
        return highestRatedFood.name