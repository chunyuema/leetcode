class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new LinkedList<>();
        stack.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int prev = stack.getLast();
            int curr = nums[i];
            if (gcd(prev, curr) == 1) {
                stack.add(curr);
            } else {
                int merge = lcm(prev, curr);
                while (!stack.isEmpty() && gcd(stack.getLast(), merge) != 1) {
                    merge = lcm(merge, stack.removeLast());
                }
                stack.add(merge);
            }
        }
        return stack;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }   

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b);
    }  
}