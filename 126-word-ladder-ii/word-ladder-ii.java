import java.util.*;

class Solution {
    // Map to store: word -> shortest distance level from beginWord
    Map<String, Integer> mpp = new HashMap<>();
    List<List<String>> axe = new ArrayList<>();
    String bWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        bWord = beginWord;
        q.add(beginWord);
        mpp.put(beginWord, 1);
        st.remove(beginWord);

        int wordLen = beginWord.length();

        // PHASE 1: BFS se har reachable word ka Level store karo
        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = mpp.get(word);

            if (word.equals(endWord)) break;

            char[] arr = word.toCharArray();
            for (int i = 0; i < wordLen; i++) {
                char org = arr[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String replace = new String(arr);

                    if (st.contains(replace)) {
                        q.add(replace);
                        st.remove(replace); // Queue mein ek baar add hone ke baad remove
                        mpp.put(replace, steps + 1);
                    }
                }
                arr[i] = org; // Restore back
            }
        }

        // PHASE 2: Agar endWord reach hua hai, to back-track karke paths build karo
        if (mpp.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path);
        }

        return axe;
    }

    // DFS: endWord se beginWord ki taraf (Reverse Backtracking)
    private void dfs(String word, List<String> path) {
        if (word.equals(bWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp); // Reverse kyunki hum endWord se start tak aaye hain
            axe.add(temp);
            return;
        }

        int steps = mpp.get(word);
        char[] arr = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char org = arr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String prevWord = new String(arr);

                // Sirf wahi word pick karo jiska level exact current level - 1 hai
                if (mpp.containsKey(prevWord) && mpp.get(prevWord) == steps - 1) {
                    path.add(prevWord);
                    dfs(prevWord, path);
                    path.remove(path.size() - 1); // Backtrack
                }
            }
            arr[i] = org;
        }
    }
}