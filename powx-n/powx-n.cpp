//할때마다 곱하면 2^31-1일때 타임리밋
//빨리하려면? 비트연산..? 
//n을 비트로 보고 연산하면 된다, n을 비트로 바꿨을때 1인 부분만 곱하면됨
//재귀, 반복문 두가지 방법 있음 
#include <cmath>
class Solution {
public:
    double myPow(double x, int n) {
        double res=1;
        if(n==0) return res;
        int mul = abs(n);
        while(mul>0){
            if(mul%2==1) res*=x;
            mul=mul>>1;
            x*=x; //이거 안해주면 ㄴㄴ 자리수 늘어날때마다 곱해줘야함
        }
        res=n>0? res:1/res;
        return res;
    }
};