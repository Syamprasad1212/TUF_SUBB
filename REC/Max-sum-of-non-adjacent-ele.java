class Solution {
    public static int solve(int []nums,int i,int n,int []dp){
        if(i>=n){
            return 0;
        }

        if(dp[i]!=-1) return dp[i];

        int take=nums[i]+solve(nums,i+2,n,dp);
        int skip=solve(nums,i+1,n,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int nonAdjacent(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,n,dp);
    }
}


/*To solve this problem, I first tried to build the recursive solution. Once we understand the recursion properly, it becomes much easier to convert it into memoization or dynamic programming.

The goal is to find the maximum sum of elements such that no two selected elements are adjacent.

At every index, I have two choices: take the current element or skip it.

If I take the current element, I cannot take the next adjacent element, so I move to i + 2.

If I skip the current element, I can consider the next element, so I move to i + 1.

So the recursive relation becomes:

take = arr[i] + solve(i + 2)
skip = solve(i + 1)

answer = max(take, skip)

The recursion explores both possibilities. It first goes down one branch, reaches the base case, and returns the calculated value. Then it explores the other branch. At every index, we compare the results of the take and skip choices and return the maximum of the two.

Once the recursive solution is working, converting it into memoization is straightforward.

The main problem with the recursive solution is that the same index can be calculated multiple times. So I create a dp array where dp[i] stores the answer for that particular index.

Before calculating solve(i), I check whether dp[i] already contains a calculated value. If it does, I directly return that value instead of recalculating the entire recursion tree.

If it has not been calculated yet, I calculate the answer recursively, store it in dp[i], and return it.

This avoids repeated calculations and reduces the time complexity from exponential to linear.

Complexity

Recursive Approach

Time: O(2^n) because each index can branch into two choices.

Space: O(n) because of the recursion stack.

Memoization Approach

Time: O(n) because each index is calculated only once.

Space: O(n) for the dp array + O(n) recursion stack, so overall O(n).*/
