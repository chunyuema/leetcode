class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        N = len(s)
        
        # Precompute the index of the next '0' for each position.
        # If there's no '0' after a position, it will be N (out of bounds).
        next_zero = [N] * N
        for i in range(N-2, -1, -1):
            if s[i + 1] == '0':
                next_zero[i] = i + 1
            else: 
                next_zero[i] = next_zero[i+1]
        
        res = 0
        for start in range(N):
            # zero_count: number of zeros included in the current substring
            zero_count = 1 if s[start] == '0' else 0

            zero_pos = start
            # Explore substrings starting at 'start' with increasing number of zeros
            while zero_pos < N and zero_count * zero_count <= N:
                next_zero_pos = next_zero[zero_pos]

                # one_count: number of '1's from 'start' to the position before the next zero
                one_count = next_zero_pos - start - zero_count

                # Check if the substring satisfies the "dominant condition":
                # number of '1's >= square of number of '0's
                if one_count >= zero_count * zero_count:
                    # The valid substrings start at 'start' and end anywhere between
                    # 'zero_pos' and 'next_zero_pos - 1'.
                    # The number of such substrings is limited by either:
                    # 1) The distance to the next zero (next_zero_pos - zero_pos)
                    # 2) How many additional '1's beyond the required square we have (one_count - zero_count^2 + 1)
                    res += min(next_zero_pos - zero_pos, one_count - zero_count * zero_count + 1)
                
                # Move to the next zero and increase zero_count
                zero_pos = next_zero_pos
                zero_count += 1
        
        return res

