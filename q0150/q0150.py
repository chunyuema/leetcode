class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operandStack = []
        for token in tokens: 
            if token not in ['+', '-', '*', '/']:
                operandStack.append(int(token))
            else: 
                operand2 = operandStack.pop()
                operand1 = operandStack.pop()
                if token == '+': operandStack.append(operand1 + operand2)
                elif token == '-': operandStack.append(operand1 - operand2)
                elif token == '*': operandStack.append(operand1 * operand2)
                else: operandStack.append(int(operand1 / operand2))
        return operandStack.pop()