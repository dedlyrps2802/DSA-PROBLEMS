class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> sol = new ArrayList<>();
        Solve(s,res ,sol , 0);
        return res;
    }

    void Solve(String str , List<List<String>> res , List<String> sol ,int start){
        if(start == str.length()){
            res.add(new ArrayList<>(sol));
            return;
        }
        for(int i = start; i<str.length() ; ++i){
            if(isPalindrome(str , start , i)){
                sol.add(str.substring(start , i+1));
                Solve(str , res , sol , i+1);
                sol.remove(sol.size()-1);
            }
        }
    }

    boolean isPalindrome(String str , int start , int end){
        while(start<=end){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}