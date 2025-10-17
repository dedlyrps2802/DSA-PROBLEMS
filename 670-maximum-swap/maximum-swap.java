class Solution {
    public int maximumSwap(int num) {
        StringBuilder str = new StringBuilder();
        str.append(num);
        return Integer.parseInt(kswaps(str , 1).toString());
    }

     static StringBuilder kswaps(StringBuilder str , int k){

        StringBuilder res = new StringBuilder();
        res.append(str);
        Solve(str, k, res , 0);
        return res;

    }

    static void Solve(StringBuilder str , int k , StringBuilder res , int start){
        if(start == str.length()-1 || k == 0){
            return;
        }

        char max = '0';
        for(int i = start+1 ; i<str.length(); i++){
            if(str.charAt(i)>max){
                max = str.charAt(i);
            }
        }

        for (int i = start+1; i <str.length() ; i++) {
            if(str.charAt(i) > str.charAt(start) && str.charAt(i) == max ){
                swap(str, i , start);
                if(str.toString().compareTo(res.toString()) > 0 ){
                    res.setLength(0);
                    res.append(str);
                }
                Solve(str,k-1,res,start+1);
                swap(str , i ,start );
            }
        }
        Solve(str,k,res,start+1);
    }

    static void swap(StringBuilder str , int i , int j){
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j,temp);

    }
}