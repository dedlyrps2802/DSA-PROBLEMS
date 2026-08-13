class Solution {
    private int[] maxLen;
    private int[] prefixLen;
    private int[] suffixLen;
    private char[] prefixChar;
    private char[] suffixChar;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int treeSize = 4 * n;

        maxLen = new int[treeSize];
        prefixLen = new int[treeSize];
        suffixLen = new int[treeSize];
        prefixChar = new char[treeSize];
        suffixChar = new char[treeSize];

        char[] chars = s.toCharArray();
        build(1, 0, n - 1, chars);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            
            update(1, 0, n - 1, idx, ch);
            ans[i] = maxLen[1];
        }

        return ans;
    }

    private void build(int node, int start, int end, char[] chars) {
        if (start == end) {
            maxLen[node] = 1;
            prefixLen[node] = 1;
            suffixLen[node] = 1;
            prefixChar[node] = chars[start];
            suffixChar[node] = chars[start];
            return;
        }

        int mid = start + (end - start) / 2;
        int left = 2 * node;
        int right = 2 * node + 1;

        build(left, start, mid, chars);
        build(right, mid + 1, end, chars);

        merge(node, left, right, end - start + 1, mid - start + 1, end - mid);
    }

    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            prefixChar[node] = ch;
            suffixChar[node] = ch;
            return;
        }

        int mid = start + (end - start) / 2;
        int left = 2 * node;
        int right = 2 * node + 1;

        if (idx <= mid) {
            update(left, start, mid, idx, ch);
        } else {
            update(right, mid + 1, end, idx, ch);
        }

        merge(node, left, right, end - start + 1, mid - start + 1, end - mid);
    }

    private void merge(int node, int left, int right, int totalLen, int leftLen, int rightLen) {
        prefixChar[node] = prefixChar[left];
        suffixChar[node] = suffixChar[right];

        prefixLen[node] = prefixLen[left];
        suffixLen[node] = suffixLen[right];

        maxLen[node] = Math.max(maxLen[left], maxLen[right]);

        if (suffixChar[left] == prefixChar[right]) {
            maxLen[node] = Math.max(maxLen[node], suffixLen[left] + prefixLen[right]);

            if (prefixLen[left] == leftLen) {
                prefixLen[node] = prefixLen[left] + prefixLen[right];
            }

            if (suffixLen[right] == rightLen) {
                suffixLen[node] = suffixLen[right] + suffixLen[left];
            }
        }
    }
}