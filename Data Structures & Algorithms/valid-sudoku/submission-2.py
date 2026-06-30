class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [[False] * 9 for _ in range(9)]
        cols = [[False] * 9 for _ in range(9)]
        boxes = [[False] * 9 for _ in range(9)]

        for r in range(9):
            for c in range(9):
                val = board[r][c]
                
                if val == '.': continue

                num = ord(val) - ord('1')

                box_idx = (r//3)*3 + (c//3)

                if(rows[r][num] or cols[c][num] or boxes[box_idx][num]):
                    return False

                rows[r][num] = True
                cols[c][num] = True
                boxes[box_idx][num] = True

        return True

                
