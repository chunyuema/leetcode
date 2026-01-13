class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end(), greater<int>());
        int l = people.size() - 1;
        int r = 0;
        int boat = 0;

        while (r < people.size() && r <= l) {
            if (people[r] + people[l] <= limit) {
                l--;
            }
            boat++;
            r++;
        }
        return boat;  
    }
};