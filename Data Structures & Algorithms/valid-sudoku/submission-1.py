class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in board:
            notEmpty = [x for x in row if x != "."]
            rowSet = {x for x in row if x != "."}
            if len(notEmpty) != len(rowSet): 
                print(notEmpty)
                print(rowSet)
                print("1")
                return False

        for c in range(9):
            notEmpty = [board[r][c] for r in range(9) if board[r][c] != "."]
            colSet   = {board[r][c] for r in range(9) if board[r][c] != "."}
            if len(notEmpty) != len(colSet): 
                print(notEmpty)
                print(colSet)
                print("2")
                return False

        return all([
            self.isValidSubBoxes(board, 1, 1),
            self.isValidSubBoxes(board, 1, 4),
            self.isValidSubBoxes(board, 1, 7),
            self.isValidSubBoxes(board, 4, 1),
            self.isValidSubBoxes(board, 4, 4),
            self.isValidSubBoxes(board, 4, 7),
            self.isValidSubBoxes(board, 7, 1),
            self.isValidSubBoxes(board, 7, 4),
            self.isValidSubBoxes(board, 7, 7),
        ])

    def isValidSubBoxes(self,board, c : int,r : int)-> bool:
        toRow = [board[c-1][r-1],board[c-1][r],board[c-1][r+1],board[c][r-1],board[c][r],board[c][r+1],board[c+1][r-1],board[c+1][r],board[c+1][r+1]]
        notEmpty = [x for x in toRow if x != "."]
        rowSet = {x for x in toRow if x != "."}
        if len(notEmpty) != len(rowSet): 
            print("3")
            return False
        return True     

