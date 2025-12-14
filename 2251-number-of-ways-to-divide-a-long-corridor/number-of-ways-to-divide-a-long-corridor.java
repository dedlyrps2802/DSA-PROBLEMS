class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> seats = new ArrayList<>();

        for(int i = 0; i< corridor.length(); i++){
            if(corridor.charAt(i) == 'S'){
                seats.add(i);
            }
        }

        if(seats.size() == 0 || seats.size() % 2 != 0){
            return 0;
        }

        long answer = 1;
        int MOD = 1000000007;

        for(int i =1; i<seats.size()-1; i+=2){
            int current_seat = seats.get(i);
            int next_seat = seats.get(i+1);

            answer = (answer*(next_seat - current_seat)) % MOD;
        }

        return (int) (answer);
    }
}