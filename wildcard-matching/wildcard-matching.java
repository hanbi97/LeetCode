//string은 .length() 배열은 .length 리스트는 .size()
//pIdx, sIdx 두개 포인터가지고 O(nm)에 해결하려 했으나 자꾸 에러발생..
//dp로 해결하는 방법도 있음

/* dp[i][j] = s[i]랑 p[j]가 매칭되는가?
origin: dp[0][0]: they do match, so dp[0][0] = true
first row: dp[0][j]: p[j]=='*'아니면 다 false(*면 공백 가능)
first col: dp[i][0]: p[j]가 없으니까 매칭 X 다 false

Iterate through every dp[i][j]
dp[i][j] = true:
if (s[ith] == p[jth] || p[jth] == '?') && dp[i-1][j-1] == true
elif p[jth] == '*' && (dp[i-1][j] == true || dp[i][j-1] == true)
-for dp[i-1][j], means that * acts like an empty sequence.
eg: ab, ab*
-for dp[i][j-1], means that * acts like any sequences
eg: abcd, ab*
Start from 0 to len
Output put should be dp[s.len][p.len], referring to the whole s matches the whole p
*/

class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        
        int sLen=s.length(); int pLen=p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        
        //init
        dp[0][0]=true;
        for(int i=1; i<=sLen; i++) dp[i][0]=false;
        for(int j=1; j<=pLen; j++) {
            if(p.charAt(j-1)=='*') dp[0][j] = dp[0][j-1];
        }
        
        //calc
        for(int i=1; i<=sLen; i++){
           for(int j = 1; j <= pLen; j++){
                if((s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') && dp[i-1][j-1])
                    dp[i][j] = true; //i-1, j-1한 이유: string 인덱스 맞추려고
                else if (p.charAt(j-1) == '*' && (dp[i-1][j] || dp[i][j-1]))
                    dp[i][j] = true;
            }
        }
        return dp[sLen][pLen];
    }
}