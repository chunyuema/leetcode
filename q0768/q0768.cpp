class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
       int min_num = INT_MAX;
        vector<int> min_right_track; // vector to keep track of the min on the right side
        // Traverse the array in reverse to populate min_right_track
        for (auto it = arr.rbegin(); it != arr.rend(); ++it) {
            min_num = std::min(*it, min_num);
            min_right_track.push_back(min_num);
        }
        // Reverse min_right_track to match the original order
        reverse(min_right_track.begin(), min_right_track.end());
        // Append -1 to the end of min_right_track
        min_right_track.push_back(-1);

        int r = 0;
        int max_num = 0; // int to keep track of the highest on the left
        int chunk_count = 1;

        while (r < arr.size()) {
            max_num = max(arr[r], max_num);
            // Time to make the chunk based on chunk eligibility
            // ***Chunk eligibility: highest number of the left <= lowest on the right
            if (max_num <= min_right_track[r + 1]) {
                chunk_count += 1;
                max_num = 0; // reset max_num to start a new chunk
            }
            r += 1;
        }

        return chunk_count;      
    }