class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // dp[i][m] represents the max stones a player can get starting at index i with M = m
        int[][] dp = new int[n][n + 1];
        
        // suffixSum[i] stores the sum of stones from index i to the end
        int[] suffixSum = new int[n];
        
        // Precompute the suffix sums
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                // Base case: If the current player can take all remaining piles
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    int minOpponent = Integer.MAX_VALUE;
                    
                    // Try all possible moves X from 1 to 2M
                    for (int x = 1; x <= 2 * m; x++) {
                        // Find the minimum stones the opponent will be left with
                        minOpponent = Math.min(minOpponent, dp[i + x][Math.max(m, x)]);
                    }
                    
                    // Current player's max is total remaining stones minus the opponent's best outcome
                    dp[i][m] = suffixSum[i] - minOpponent;
                }
            }
        }
        
        // Start game at index 0 with M = 1
        return dp[0][1];
    }
}