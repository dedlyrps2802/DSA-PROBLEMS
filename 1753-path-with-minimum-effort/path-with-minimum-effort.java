class Solution {
   
   static class Pair implements Comparable<Pair>{
    int r ;
    int c ; 
    int d;

        Pair(int r, int c , int d){
            this.r = r;
            this.c = c;
            this.d = d;

        }

        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.d,other.d);
        }
   }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        if(n==1 && m==1) return 0;

        int[][] efforts = new int[n][m];
        for(int[] row: efforts){
        Arrays.fill(row,Integer.MAX_VALUE);
        
        }
        efforts[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
         pq.add(new Pair(0,0,0));

         int[] delrow = {-1,0,1,0};
         int[] delcol = {0,1,0,-1};

         while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int row = curr.r;
            int col = curr.c;
            int effort = curr.d;
          

          if(row == n-1 && col == m-1) return effort;

          if(effort > efforts[row][col]) continue;

            for(int  i = 0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];


                if(nrow>=0 && nrow < n && ncol>=0 && ncol<m ){

                    int stepeffort = Math.abs(heights[row][col] - heights[nrow][ncol]);

                    int maxeffort = Math.max(effort,stepeffort);
                     
                     if(maxeffort < efforts[nrow][ncol]){
                        efforts[nrow][ncol] = maxeffort;
                        pq.add(new Pair(nrow,ncol,maxeffort));
                     }

                }
            } 
          
         
         }


        return 0;
    }
}