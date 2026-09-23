class Solution {
    public static void ratt(int n, int m,int[][]maze,StringBuilder st,ArrayList<String>ans,boolean visit[][],int i,int j){
        
        if(i>=n||j>=m){
            return ;
        }
        visit[i][j]=true;
        
        
        if(i==n-1 && j==m-1){
            ans.add(st.toString());
            visit[i][j]=false;
            return;
        }
        
        if(maze[i][j]==1){
            if(i+1<n && maze[i+1][j]==1 && !visit[i+1][j]){
                st.append('D');
                ratt(n,m,maze,st,ans,visit,i+1,j);
                st.deleteCharAt(st.length()-1);
            } 
            
             if(j>0 && maze[i][j-1]==1 && !visit[i][j-1]){
                st.append('L');
                ratt(n,m,maze,st,ans,visit,i,j-1);
                st.deleteCharAt(st.length()-1);
            }
            
            if(j+1<m && maze[i][j+1]==1 && !visit[i][j+1]){
                st.append('R');
                ratt(n,m,maze,st,ans,visit,i,j+1);
                st.deleteCharAt(st.length()-1);
            }
            
            if(i>0 && maze[i-1][j]==1 && !visit[i-1][j]){
                st.append('U');
                ratt(n,m,maze,st,ans,visit,i-1,j);
                st.deleteCharAt(st.length()-1);
            }
            
           
            
        }
        visit[i][j]=false;
        
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        StringBuilder st=new StringBuilder();
        ArrayList<String>ans=new ArrayList<>();
        int n=maze.length;
        int m=maze[0].length;
        boolean visit[][]=new boolean[n][m];
        if(maze[0][0]==0)return ans;
        ratt(n,m,maze,st,ans,visit,0,0);
        return ans;
    }
}


/*To solve this problem, we first know that the rat always starts from the (0,0) position.

So, first we check whether the starting cell is 1 or 0. If maze[0][0] == 0, we cannot start the traversal, so we simply return an empty result.

After that, we start the recursive function from (0,0) with an empty StringBuilder to store the current path.

At every position, the first thing we check is whether we are within the boundaries of the matrix. If we go outside the matrix, we simply return.

Then, we mark the current cell as visited so that we don't visit the same cell again and get stuck in a cycle.

Our main base case is when we reach the destination, which is (n-1, m-1). If we reach that position, it means we have found a valid path, so we add the current path stored in StringBuilder to our answer and return.

While traversing, we can move in four directions: Down, Left, Right, and Up. For every direction, we check two things:

The next position should be inside the matrix.

The next cell should contain 1 and should not already be visited.

If the direction is valid, we append the corresponding character (D, L, R, or U) to our current path and make the recursive call for that cell.

After the recursive call returns, we perform backtracking. We remove the last character from the StringBuilder because that particular choice belongs only to the path we just explored.

Similarly, after exploring all four directions from the current cell, we unmark the current cell as visited. This allows that cell to be used again when we explore a different possible path.

So overall, we are using DFS + Backtracking. At every cell, we try all four possible directions, continue only when the move is valid, and whenever we reach the destination, we store that complete path in our answer.*/
