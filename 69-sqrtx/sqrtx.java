class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int left = 1, right = x;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Avoid overflow by dividing instead of multiplying (mid * mid)
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1; // Look in the right half
            } else {
                right = mid - 1; // Look in the left half
            }
        }
        
        // When the loop ends, 'right' will hold the floor of the square root
        return right; 
    }
}