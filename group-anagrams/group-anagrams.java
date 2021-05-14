import java.util.*;
// 같은 알파벳으로 이루어진 문자열 찾기 만개
// string 하나하나 정렬 -> n*n logn
// 문법을 몰라서 못풀겠다
// <String, String> map 이용 key에는 anagram 넣고 value에는 원본 넣으면 됨

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();

        Map<String,List<String>> m = new HashMap<>();
        for(String s:strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch); //char[] to String

            if(!m.containsKey(key)) m.put(key,new ArrayList<>());
            m.get(key).add(s);
        }
        return new ArrayList<>(m.values());
    }
}