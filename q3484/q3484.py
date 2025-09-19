class Spreadsheet:

    def __init__(self, rows: int):
        self.grid = [[0 for _ in range(26)] for _ in range(rows)]
        
    def setCell(self, cell: str, value: int) -> None:
        (col, row) = self.getPos(cell)
        self.grid[row][col] = value     

    def resetCell(self, cell: str) -> None:
        (col, row) = self.getPos(cell)
        self.grid[row][col] = 0 

    def getValue(self, formula: str) -> int:
        parts = formula[1:].split("+")
        return sum(self.evaluateParts(part.strip()) for part in parts)
    
    def getPos(self, cell: str) -> Tuple[int, int]:
        col = ord(cell[0]) - ord('A')
        row = int(cell[1:]) - 1
        return (col, row)

    def evaluateParts(self, expression: str) -> int:
        if expression.isdigit():
            return int(expression)
        else:
            (col, row) = self.getPos(expression)
            return self.grid[row][col]