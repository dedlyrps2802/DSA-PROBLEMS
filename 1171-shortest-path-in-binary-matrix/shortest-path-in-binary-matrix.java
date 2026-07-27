class Solution {
    static class Pair{
        int r ;
        int c; 
        int d;

        Pair(int r, int c , int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
          int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;

        if(n==1) return 1;


        int delrow[] = {-1,-1,-1,0,0,1,1,1};
        int delcol[] = {-1,0,1,-1,1,-1,0,1};

        boolean[][] vis = new boolean[n][n];


        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0,1));
        vis[0][0] = true;



        while(!q.isEmpty()){
           Pair curr = q.poll();
           int row = curr.r;
           int col = curr.c;
           int d = curr.d;


           for(int i = 0; i<8; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];


            if(nrow>= 0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 0 && !vis[nrow][ncol]){
            
            if(nrow == n-1 && ncol == n-1) return d+1;


                vis[nrow][ncol] = true;
                q.add(new Pair(nrow,ncol,d+1));
            }
           }
        }
        return -1;
    }
}