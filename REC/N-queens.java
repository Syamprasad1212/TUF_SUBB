class Solution {
    public static boolean issafe(int row,int col,char board[][],List<List<String>>ans,int n){
        int dupcol=col;
        int duprow=row;

        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;

            row--;
            col--;
        }
        col=dupcol;
        row=duprow;

        while(col>=0){
             if(board[row][col]=='Q') return false;

             col--;
        }
        col=dupcol;
        row=duprow;

        while(row<n && col>=0){
            if(board[row][col]=='Q') return false;

            row++;
            col--;
        }
        return true;
    }
    public static void queens(int col,char board[][],List<List<String>>ans,int n){
        if(col==n){
            List<String>solution=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
        ans.add(solution);
        return;
        }
        for(int row=0;row<n;row++){
        if(issafe(row,col,board,ans,n)){
            board[row][col]='Q';
            queens(col+1,board,ans,n);
            board[row][col]='.';
        }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        queens(0,board,ans,n);
        return ans;
    }
}



/*In this problem, we first take an empty N × N board and start placing the queens column by column.

At every step, we check whether it is possible to place a queen at the current position. We check whether the position is safe from other queens.

If the position is safe, we place the queen there and recursively move to the next column.

After the recursive call is completed, we backtrack. That means we remove the queen we placed earlier and make that position empty again. Then we try the next possible position in the same column.

By doing this, we try all possible valid placements and generate all possible solutions for the N-Queens problem.

Complexity — our style
- Time: O(N!) — In the worst case, we try different ways of placing N queens, and the number of possibilities grows factorially.
- Space: O(N²) — We use an N × N board.
- Recursion stack: O(N) — At most N recursive calls are active at one time.
Main idea:
Place → Recursive Call → Remove → Try Next*/
