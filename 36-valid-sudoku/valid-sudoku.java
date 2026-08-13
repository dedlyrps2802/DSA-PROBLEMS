class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        HashSet<Character>[] rows = new HashSet[N];
         HashSet<Character>[] col = new HashSet[N];
          HashSet<Character>[] box = new HashSet[N];


       for(int r= 0; r<N; r++){
        rows[r] = new HashSet<Character>();
        col[r] =  new HashSet<Character>();
        box[r] =  new HashSet<Character>();
       }

       for(int r = 0; r <N; r++){
        for( int c = 0; c<N; c++){

            char ch = board[r][c];

           if(ch == '.' || ch == ',') continue;
            
            if(rows[r].contains(ch)){
                return false;
            }
            rows[r].add(ch);

            if(col[c].contains(ch)){
                return false;
            }
            col[c].add(ch);

             
             int bx = (r/3) * 3 + (c/3) ;
             if(box[bx].contains(ch)) return false;

             box[bx].add(ch); 
       
        }
       }

       return true;

    }
}