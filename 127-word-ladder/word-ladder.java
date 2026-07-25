class Solution {

   class Pairs{
    String str;
    int steps;

    Pairs(String str , int steps){
        this.str = str;
        this.steps = steps;
    }
   }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pairs> q = new LinkedList<>();
         q.add(new Pairs(beginWord,1));
        Set<String> st = new HashSet<>();

        for(int i = 0;  i<wordList.size(); i++){
            st.add(wordList.get(i));
        }

        st.remove(beginWord);

        while(!q.isEmpty()){
            Pairs c = q.poll();
            String word = c.str;
            int step = c.steps;

            if(word.equals(endWord) == true ) return step;

             char[] arr = word.toCharArray();
            for(int i= 0; i< word.length(); i++){
                char org = arr[i];
                for(char ch = 'a' ; ch<= 'z' ; ch++){
                    
                    arr[i] = ch;
                    String replace = new String(arr);

                    if(st.contains(replace) == true){
                        st.remove(replace);
                        q.add(new Pairs(replace , step+1));
                    }
                }

                arr[i] = org;

            }
        }
        return 0;
    }
}