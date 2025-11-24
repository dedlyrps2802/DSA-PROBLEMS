class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> result = new ArrayList<>();
        int x = 0; 
        for(int b : nums){
            x = (x*2+b)%5;
            if(x==0){
                result.add(true);
            }else{
            result.add(false);
            }
        }
            return result;

            
    }
}