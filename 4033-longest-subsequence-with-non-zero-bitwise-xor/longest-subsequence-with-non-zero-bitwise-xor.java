class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean hasNonZero = false;

        for (int x : nums) {
            xor ^= x;
            if (x != 0) hasNonZero = true;
        }

        if (xor != 0) return nums.length;
        if (!hasNonZero) return 0;

        return nums.length - 1;
    }
}