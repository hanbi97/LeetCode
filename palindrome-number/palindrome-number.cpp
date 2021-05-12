// Could you solve it without converting the integer to a string
// stack, queue 타임리밋
// 나머지 이용해서 구한 수 -> 거꾸로 됨
class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        
        int tmp=x;
        int reverse=0;
        
        while(tmp>0){
            int mod = tmp%10;
            if(reverse<=(INT_MAX / 10)){
                reverse=reverse*10+mod;
                tmp=tmp/10;
            }else return false;
        }
        if(reverse==x) return true;
        return false;
    }
};