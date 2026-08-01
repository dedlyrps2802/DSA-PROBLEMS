class Solution {
    public int trap(int[] height) {
        // Agar array empty ya chota hai toh pani trap nahi hoga
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int trappedWater = 0;
        
        // Pointers ko edge se center ki taraf move karte hain
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Naya max set karo
                } else {
                    trappedWater += leftMax - height[left]; // Pani collect karo
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Naya max set karo
                } else {
                    trappedWater += rightMax - height[right]; // Pani collect karo
                }
                right--;
            }
        }
        
        return trappedWater;
    }
}