import java.util.*;

class Solution {
    public String addBinary(String a, String b) {
        Stack<Character> stA = new Stack<>();
        Stack<Character> stB = new Stack<>();
        
        for(char c: a.toCharArray()) stA.push(c);
        for(char c: b.toCharArray()) stB.push(c);
       
        StringBuffer sb = new StringBuffer();
        char carry='0';
        
        while(!stA.empty() && !stB.empty()){
            char aTop = stA.peek(); char bTop = stB.peek();
            stA.pop(); stB.pop();
             if(aTop=='1' && bTop=='1'){
                if(carry=='1'){
                    carry='1';
                    sb.append('1');
                }else{
                    carry='1';
                    sb.append('0');
                }
            }else if(aTop=='0' && bTop=='0'){
                if(carry=='1'){
                    carry='0';
                    sb.append('1');
                }else{
                    carry='0';
                    sb.append('0');
                }
            }else{
                 if(carry=='1'){
                    carry='1';
                    sb.append('0');
                }else{
                    carry='0';
                    sb.append('1');
                }
            }
        }
        while(!stA.empty()){
            char top = stA.peek(); stA.pop();
            if(carry=='1'){
                if(top=='1'){
                    carry='1';
                    sb.append('0');
                }else{
                    carry='0';
                    sb.append('1');
                }
            }else{
                sb.append(top);
            }
        }
        while(!stB.empty()){
             char top = stB.peek(); stB.pop();
            if(carry=='1'){
                if(top=='1'){
                    carry='1';
                    sb.append('0');
                }else{
                    carry='0';
                    sb.append('1');
                }
            }else{
                sb.append(top);
            }
        }
        if(carry=='1')
            sb.append('1');
        return sb.reverse().toString();
    }
}