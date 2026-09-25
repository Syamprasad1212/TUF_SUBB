class Solution {
    public static boolean isvalid(char [][]board,char c,int row,int col){
        for(int i=0;i<9;i++){
            if(board[row][i]==c){
                return false;
            }

            if(board[i][col]==c){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                return false;
            }
        }
        return true;
    }
    public static boolean solvesudoku(char [][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isvalid(board,c,i,j)){
                            board[i][j]=c;
                            if(solvesudoku(board)==true){
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solvesudoku(board);
    }
}


/*In this problem, we are given a Sudoku board with some empty cells, represented by '.'. Our goal is to fill all the empty cells with numbers from 1 to 9 such that every number follows the Sudoku rules.

First, we find an empty cell in the board. Once we find an empty cell, we try all the possible candidates from 1 to 9.

For every candidate, we check whether placing that number is valid. To check this, we make sure that the number is not already present in:

The same row
The same column
The same 3 × 3 box

If the candidate is valid, we temporarily place that number in the empty cell and recursively call the Sudoku solver for the remaining empty cells.

Now there can be multiple possible candidates. We choose one candidate and continue with recursion. If the recursive call eventually returns true, it means that this choice leads to a valid completed Sudoku, so we keep the number and return true.

However, if the recursive call returns false, it means that placing that candidate caused a contradiction somewhere later in the board. In that case, we backtrack: we undo our previous choice by changing the cell back to '.', and then try the next candidate.

We continue this process of choosing, recursively exploring, checking for contradictions, and undoing incorrect choices until either we find a complete valid Sudoku or all possible candidates fail.

So the overall idea is:

Find empty cell → Try candidate → Check validity → Place it → Recurse → If contradiction, undo → Try next candidate.

When there are no empty cells left, the Sudoku is completely filled, so we return true.

Time: O(9^E × 9)
Space: O(E) recursion stack*/
