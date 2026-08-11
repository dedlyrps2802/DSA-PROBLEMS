class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        
       
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }
        
      
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sum) {
                sum++;
                i = -1; 
            }
        }
        
        return sum;
    }
}