#include <vector>
using namespace std; 

class Solution {
public:
    int get_x_diff(vector<int>& pt1, vector<int>& pt2) {
        return pt2[0] - pt1[0];
    }

    int get_y_diff(vector<int>& pt1, vector<int>& pt2) {
        return pt2[1] - pt1[1];
    }

    bool checkStraightLine(vector<vector<int>>& coordinates) {
        int initial_x_diff = get_x_diff(coordinates[0], coordinates[1]);
        int initial_y_diff = get_y_diff(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.size(); i++) {
            int new_x_diff = get_x_diff(coordinates[0], coordinates[i]);
            int new_y_diff = get_y_diff(coordinates[0], coordinates[i]);
            if (initial_x_diff * new_y_diff != initial_y_diff * new_x_diff) return false;
        }
        return true;
    }
};