class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // rightMatch[j] stores the right-most index in word1 that matches word2[j] 
        // when greedily matching from right to left.
        int[] rightMatch = new int[m];
        Arrays.fill(rightMatch, -1);
        
        int r1 = n - 1;
        for (int r2 = m - 1; r2 >= 0; r2--) {
            while (r1 >= 0 && word1.charAt(r1) != word2.charAt(r2)) {
                r1--;
            }
            if (r1 >= 0) {
                rightMatch[r2] = r1;
                r1--;
            } else {
                break; // Unmatched prefix, but suffix might still be valid
            }
        }
        
        int[] ans = new int[m];
        int j = 0;
        boolean changed = false;
        
        // Build the result by greedily matching from left to right
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            } else if (!changed) {
                // If it's a mismatch, we can ONLY change it if the remaining suffix
                // of word2 can perfectly match a subsequence in the remaining word1.
                // j == m - 1 handles the case where this is the last character.
                if (j == m - 1 || rightMatch[j + 1] > i) {
                    ans[j] = i;
                    j++;
                    changed = true; // Use up our wildcard
                }
            }
        }
        
        // If we successfully mapped all m characters, return the sequence
        if (j == m) {
            return ans;
        }
        
        // Otherwise, no valid sequence exists
        return new int[0];
    }
}