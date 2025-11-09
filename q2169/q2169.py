class Solution:
    def countOperations(self, num1: int, num2: int) -> int:
        ops = 0
        while num1 and num2:
            # Better performance than simulating the process
            ops += num1 // num2
            num1 %= num2
            num1, num2 = num2, num1
        return ops
