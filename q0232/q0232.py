class MyQueue:

    def __init__(self):
        # elements are added to stack1 to ensure the order of processing
        self.stack1 = []
        # elements are peeked / removed from stack2 to ensure dequeue ordering
        self.stack2 = []

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        # Since elements are removed from only stack2, stack2 needs to be populated
        # With elements stored in stack1 (only if necessary)
        self.transferFromS1ToS2()
        return self.stack2.pop()

    def peek(self) -> int:
        # Since elements are peeked from only stack2, stack2 needs to be populated
        # With elements stored in stack1 (only if necessary)
        self.transferFromS1ToS2()
        return self.stack2[-1]
        
    def empty(self) -> bool:
        return len(self.stack1) == 0 and len(self.stack2) == 0
    
    # Make transfer from stack1 to stack2 only when stack2 is empty
    def transferFromS1ToS2(self): 
        if (len(self.stack2) == 0): 
            while (len(self.stack1) > 0):
                self.stack2.append(self.stack1.pop())