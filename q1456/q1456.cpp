class Solution {
public:
    int maxVowels(string s, int k) {
        int l = 0;
        int r = 0;
        std::unordered_set<char> vowels = {'a', 'e', 'i', 'o', 'u'};
        int max_vow = 0;
        int vow_count = 0;
        
        // Set the size k window by taking initial the vowel count within that window
        while (r < k) {
            if (vowels.find(s[r]) != vowels.end()) {
                vow_count++;
            }
            r++;
        }
        max_vow = std::max(max_vow, vow_count);
        
        while (r < s.length()) {
            if (vowels.find(s[r]) != vowels.end() && vowels.find(s[l]) == vowels.end()) {
                vow_count++;
            } else if (vowels.find(s[r]) == vowels.end() && vowels.find(s[l]) != vowels.end()) {
                vow_count--;
            }
            // Slide the whole window of size k
            l++;
            r++;
            max_vow = std::max(max_vow, vow_count);
        }
        
        return std::max(max_vow, vow_count);
    }
};