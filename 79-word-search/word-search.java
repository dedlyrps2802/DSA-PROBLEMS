class Solution {
    public boolean exist(char[][] board, String word) {
    int m = board.length;
    if(m==0){
        return false;
    }
    int n = board[0].length;
    for(int i = 0; i<m; i++){
        for(int j =0 ; j<n ; j++ ){
            if(check(board,word,i,j,0)){
                return true;
            }
        }
    }
    return false;
   }

   public boolean check(char[][]board , String w , int i , int j,int idx){
    if(idx == w.length()){
        return true;
    }

   if(i<0 || i>= board.length || j<0 || j>= board[0].length){
    return false;
   }

   if(board[i][j] != w.charAt(idx)){
     return false;
   }

   char saved = board[i][j];
   board[i][j] = '#';

   boolean found = check(board,w, i+1,j,idx+1) ||
                   check(board,w, i-1,j,idx+1) ||
                   check(board,w, i,j+1,idx+1) ||
                   check(board,w, i,j-1,idx+1) ;


     board[i][j] =saved;
     return found;


   }
}