class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        cur_num = cur_str = ""
        for i in s:
            if i == '[':
                stack.append(cur_str)
                stack.append(int(cur_num))
                cur_num = cur_str = ""
            elif i == ']':
                num = stack.pop()
                prev_str = stack.pop()
                cur_str = prev_str + cur_str * num
            elif i.isdigit():
                cur_num += i
            else:
                cur_str += i
        return cur_str
