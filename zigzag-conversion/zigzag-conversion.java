import java.util.ArrayList;

//어렵.. up을 그냥 하면 되는거였음 ㅠㅠ
class Solution {
    public String convert(String s, int numRows) {
        int idx=0; int len = s.length();
        ArrayList<Character>[] arr = new ArrayList[numRows];
        StringBuffer answer  = new StringBuffer();
        for(int i=0; i<numRows; i++){
            arr[i] = new ArrayList<>();
        }
        while(idx<s.length()) {
            /* down */
                for(int i=0; i < numRows && idx < len; i++) { //조건 두개넣기 가넝
                    arr[i].add(s.charAt(idx++));
                }
            /* up */
               for(int i=numRows-2; i>=1 && idx < len; i--){
                    arr[i].add(s.charAt(idx++));
               }
        }
        for(int i=0; i<numRows; i++){
            for(int j=0; j<arr[i].size(); j++){
                answer.append(arr[i].get(j)); //list는 get() array는 charAt, indexOf
            }
        }
        return answer.toString();
    }
}