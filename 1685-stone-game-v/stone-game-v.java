class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        int[][] maxL = new int[n][n];
        int[][] maxR = new int[n][n];
        
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
            maxL[i][i] = stoneValue[i];
            maxR[i][i] = stoneValue[i];
        }

        // Iterate over range lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            int mid = 0;
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                
                // Adjust mid pointer for range [i, j]
                if (mid < i) mid = i;
                int total = prefix[j + 1] - prefix[i];
                
                // Move mid until leftSum > total / 2
                while (mid < j && (prefix[mid + 1] - prefix[i]) * 2 < total) {
                    mid++;
                }

                int maxVal = 0;

                // Case 1: leftSum < rightSum (k from i to mid - 1)
                if (mid - 1 >= i) {
                    maxVal = Math.max(maxVal, maxL[i][mid - 1]);
                }

                // Case 2: leftSum > rightSum (k from mid + 1 to j - 1)
                // For k in [mid + 1, j - 1], right parts are [mid + 2, j] to [j, j]
                if (mid + 1 <= j) {
                    // Check if exact equal split at mid exists
                    int leftSumMid = prefix[mid + 1] - prefix[i];
                    if (leftSumMid * 2 == total) {
                        // Equal sum at mid: can take either left or right
                        int takeLeft = leftSumMid + dp[i][mid];
                        int takeRight = (prefix[j + 1] - prefix[mid + 1]) + dp[mid + 1][j];
                        maxVal = Math.max(maxVal, Math.max(takeLeft, takeRight));
                        
                        // Remaining right splits start from mid + 2
                        if (mid + 2 <= j) {
                            maxVal = Math.max(maxVal, maxR[mid + 2][j]);
                        }
                    } else {
                        // mid itself has leftSum > rightSum, so right part is [mid + 1, j]
                        maxVal = Math.max(maxVal, maxR[mid + 1][j]);
                    }
                }

                dp[i][j] = maxVal;
                
                // Update prefix and suffix max helpers
                maxL[i][j] = Math.max(maxL[i][j - 1], total + dp[i][j]);
                maxR[i][j] = Math.max(maxR[i + 1][j], total + dp[i][j]);
            }
        }

        return dp[0][n - 1];
    }
}