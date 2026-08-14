class Solution {
    public int maximumLengthSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < chars.length; right++) {
            int charIndex = chars[right] - 'a';
            freq[charIndex]++;
            
            
            while (freq[charIndex] > 2) {
                freq[chars[left] - 'a']--;
                left++;
            }
            
         
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}