class Solution {
    public String makeLargestSpecial(String s) {

        // Base case: empty string
        if (s.length() == 0) return "";
        
        int count = 0;
        int start = 0;
        List<String> segments = new ArrayList<>();
        
        // Split the string into special binary strings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            
            // When count becomes 0, we found a special binary string
            if (count == 0) {
                // Recursively process the inner part (excluding the first '1' and last '0')
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                segments.add("1" + inner + "0");
                start = i + 1;
            }
        }
        
        // Sort the segments in descending order to get lexicographically largest string
        Collections.sort(segments, Collections.reverseOrder());
        
        // Combine all segments
        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            result.append(segment);
        }
        
        return result.toString();
    }
}
    