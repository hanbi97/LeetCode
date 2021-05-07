/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
   
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        /*더해서 하면 범위 초과 
        while문 써서 캐리 옮겨야함*/
        
        //head랑 curr둬서 curr을 다음걸로 연결
        ListNode* head = new ListNode();
        ListNode* curr = head;
        
        int carry=0;
        
        while(l1!=nullptr || l2!=nullptr){
            int sum =0;
            if(l1!=nullptr&&l2!=nullptr){
                sum = l1->val+l2->val+carry;
                l1=l1->next; l2=l2->next;
            }else if(l1!=nullptr){
                sum=l1->val+carry;
                l1=l1->next;
            }else if(l2!=nullptr){
                sum=l2->val+carry;
                l2=l2->next;
            }
            if(sum>9){
                    carry=1;
                    sum%=10;
            }else{
                carry=0;
            }
            curr->next = new ListNode(sum);
            curr=curr->next;
        }
        if(carry==1){
            curr->next = new ListNode(1);
            curr=curr->next;
        }
        //리턴 넣어
        return head->next;
    }
};