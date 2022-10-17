package LinkList;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName:isListPalindrome
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 12:25
 * @Version: v1.0
 */
public class isListPalindrome {

    // Singly-linked lists are already defined with this interface:
     class ListNode<T> {
       ListNode(T x) {
         value = x;
       }
       T value;
       ListNode<T> next;
     }

     // timeout not O(1)
    boolean solution(ListNode<Integer> l) {
        List<String> list = new LinkedList<>();
        while(l != null){
            list.add(String.valueOf(l.value));
            l = l.next;
        }
        for(int i = 0;i< list.size()/2;i++){
            // System.out.println( list.get(i));
            if(!list.get(i) .equals(list.get(list.size() - 1 -i))) return false;
        }
        return true;
    }


    // space complexity O(1)
    // using two pointer to find the middle location and reverse it
    boolean solution2(ListNode<Integer> node) {
        ListNode<Integer> slow = node;
        ListNode<Integer> fast = node;
        while (fast != null &&fast.next !=  null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse slow
        ListNode<Integer> prev = null;
        while (slow != null){
            ListNode<Integer> nextnode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextnode;
        }
        ListNode<Integer> left = node;
        ListNode<Integer> right = prev;
        while(right != null){
            if(!right.value.equals(left.value)) return false;
            right = right.next;
            left = left.next;
        }
        return true;
    }

}
