class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        if (m > n) {
            return ans;
        }
        int[] pfa = new int[26];
        for (int i = 0; i < m; ++i) {
            pfa[p.charAt(i) - 97]++;
        }

        int[] sfa = new int[26];
        for (int i = 0; i < m; ++i) {
            sfa[s.charAt(i) - 97]++;
        }

        if (isAnagram(sfa, pfa)) {
            ans.add(0);
        }

        int i = 0;
        int j = m;
        while (i < n - m) {
            sfa[s.charAt(i) - 97]--;
            sfa[s.charAt(j) - 97]++;
            ++i;
            ++j;
            if (isAnagram(sfa, pfa)) {
                ans.add(i);
            }
        }
        return ans;

    }

    public boolean isAnagram(int[] sfa, int[] pfa) {
        for (int i = 0; i < 26; ++i) {
            if (sfa[i] != pfa[i]) {
                return false;
            }
        }
        return true;
    }
}