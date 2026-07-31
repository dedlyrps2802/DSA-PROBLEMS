class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n+1];
        Arrays.fill(dis,(int)(1e8));

        dis[k] = 0; 
         


       for(int i = 0; i<n-1; i++){
        for(int[] time : times){
            int  u = time[0];
            int v = time[1];
            int wt = time[2];
            
            if(dis[u] != 1e8 && dis[u] + wt < dis[v]){
                dis[v] = dis[u] + wt;
                
            }

        }
       }
         int max = 0;
        
        for(int i = 1; i <= n; i++){
            if(dis[i] == 1e8){ 
                return -1;
            }
            max = Math.max(max, dis[i]); 
        }
       return max;
    }
}