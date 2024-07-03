class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        // Converting the integer to a binary string
        bitset<32> binary(n);
        // Reverse the binary string and convert it back to an unsigned integer
        string binary_str = binary.to_string();
        reverse(binary_str.begin(), binary_str.end());
        uint32_t reversed = bitset<32>(binary_str).to_ulong();
        return reversed;        
    }
};