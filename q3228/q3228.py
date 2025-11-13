class Solution:
    def maxOperations(self, s: str) -> int:
        max_ops = 0
        ones_count = 0
        
        # We need to track the last character to find the *start* of a '0' block
        # Initialize to '1' so that a '0' at the very beginning is counted.
        prev_char = '1' 
        
        for char in s:
            if char == '1':
                ones_count += 1
                prev_char = '1'
            
            # Greedy, whenever you see a '10', let all the previous accumuluated 1's
            # jump once, such that we will maxmize the total number of operations
            elif char == '0':
                # Prev char needs to be '1' to form '10'.
                # Since '10000..' only allows you to jump once 
                if prev_char == '1': max_ops += ones_count
                
                prev_char = '0'
                
        return max_ops
