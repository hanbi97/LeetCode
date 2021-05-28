import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*자바로 풀면 문제점: List, array 모두 연결되어있음.. 답에 넣을때 새로운 리스트 만들어줘야함
새로 삽입되지 않고 기존 값만 바뀜
자바 리스트: contains()로 값 있는지 확인 가능, 따로 불리언 변수 둘 필요 없음
*/
class Solution {

    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(list, new ArrayList<>(), nums);
       return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
       if(tempList.size() == nums.length){
          list.add(new ArrayList<>(tempList)); //넣을때 새 리스트를 반드시 만들어줘야함
          return;
       }
          for(int i = 0; i < nums.length; i++){ 
             if(tempList.contains(nums[i])) continue; // element already exists, skip
             tempList.add(nums[i]);
             backtrack(list, tempList, nums);
             tempList.remove(tempList.size() - 1);
          }
       
    } 
    
}
