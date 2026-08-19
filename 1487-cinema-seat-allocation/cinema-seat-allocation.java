class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
       
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            
            if (col > 1 && col < 10) {
                map.putIfAbsent(row, new HashSet<>());
                map.get(row).add(col);
            }
        }
        
       
        int ans = (n - map.size()) * 2;
        
    
        for (Set<Integer> blocked : map.values()) {
            boolean leftOk = !blocked.contains(2) && !blocked.contains(3) 
                          && !blocked.contains(4) && !blocked.contains(5);
                          
            boolean rightOk = !blocked.contains(6) && !blocked.contains(7) 
                           && !blocked.contains(8) && !blocked.contains(9);
                           
            boolean middleOk = !blocked.contains(4) && !blocked.contains(5) 
                            && !blocked.contains(6) && !blocked.contains(7);
            
            if (leftOk && rightOk) {
                ans += 2;
            } else if (leftOk || rightOk || middleOk) {
                ans += 1;
            }
        }
        
        return ans;
    }
}