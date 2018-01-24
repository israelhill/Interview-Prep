class LongestPalindromeSubstringDP {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }

        boolean[][] table = initTable(s);
        int startsAt = 0;
        int len = 1;
        int n = s.length();
        //init palindormes of length 1
        for(int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        //init palindormes of length 2
        for(int i = 0; i < n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                startsAt = i;
                len = 2;
            }
        }

        if(s.length() == 2) {
            return String.valueOf(s.substring(startsAt, len+1));
        }
        // everything else
        for(int curr_len = 3; curr_len <= n; curr_len++) {
            for(int i = 0; i < n-curr_len+1; i++) {
                int j = i + curr_len - 1;
                if(s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
                    table[i][j] = true;
                    startsAt = i;
                    len = curr_len;
                }
            }
        }
        return String.valueOf(s.substring(startsAt, len+1));
    }

    public boolean[][] initTable(String s) {
        int n = s.length();
        boolean[][] table = new boolean[n][n];
        return table;
    }
}
