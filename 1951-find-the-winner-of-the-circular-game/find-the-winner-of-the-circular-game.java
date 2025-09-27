class Solution {
    public int findTheWinner(int n, int k) {
        
        return josephus(n, k) + 1; // Convert to 1-based indexing
    }
    
    private int josephus(int n, int k) {
        if (n == 1) {
            return 0; // Base case: only one person remains
        }
        return (josephus(n - 1, k) + k) % n;
    }
}
  
